package com.piotr2b.chinesehuawen.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.gephi.graph.api.DirectedGraph;
import org.gephi.graph.api.GraphController;
import org.gephi.graph.api.GraphModel;
import org.gephi.project.api.ProjectController;
import org.openide.util.Lookup;

public class Substrate {

	public static Node mingle(Node node) {
		return (new Substrate()).flatten(node);
	}

	private ConcurrentHashMap<Integer, Node> in; // main map
	private ConcurrentHashMap<String, Integer> si;
	private ConcurrentHashMap<Integer, String> is;

	public Substrate() {
		in = new ConcurrentHashMap<>();
		si = new ConcurrentHashMap<>();
		is = new ConcurrentHashMap<>();
	}

	public Node flatten(Node node) {
		Node flattened = new Node();
		flattened.idc = node.idc;
		flattened.character = node.character;
		for (int i = 0; i < node.leaves.size(); i++) {
			Node n = node.leaves.get(i);
			flatten(n);
			if (!(in.get(n.getId()) == null)) {
				flattened.leaves.add(in.get(n.getId()));
			}
		}
		// On est sûr maintenant que les feuilles ont été intégrées.
		if (in.containsKey(node.getId())) {
			// Ce nœud est déjà connu.
			if (in.get(node.getId()).getCharacter() == null && flattened.getCharacter() != null) {
				// Le substrat contient un caractère anonyme, on le remplace
				// sans état d'âme.
				in.put(flattened.getId(), flattened);
				si.put(flattened.getCharacter(), flattened.getId());
				is.put(flattened.getId(), flattened.getCharacter());
			} else if (!(node.getCharacter() == null || in.get(node.getId()).getCharacter().equals(node.getCharacter()))) {
				// Ce sinograme se fait redéfinir, il s'agit d'une incohérence.
			}
		} else {
			// C'est un nouveau nœud.
			in.put(flattened.getId(), flattened);
			if (!(flattened.getCharacter() == null || flattened.getCharacter().equals(""))) {
				si.put(flattened.getCharacter(), flattened.getId());
				is.put(flattened.getId(), flattened.getCharacter());
			}
		}
		return flattened;
	}

	public Set<Node> getFSet(Node node) {
		if (in.containsKey(node.getId())) {
			return in.values().stream().filter(x -> x.contains(node)).collect(Collectors.toSet());
		} else {
			// Sinogramme inconnu, renvoie 0.
			return new HashSet<Node>();
		}
	}

	public void exportFiles(String outputPath, Node.TreeType type) throws FileNotFoundException {

		File outputNode = new File(outputPath + "/graphNode.txt");
		File outputEdge = new File(outputPath + "/graphEdge.txt");
		final PrintWriter printerNode = new PrintWriter(outputNode);
		final PrintWriter printerEdge = new PrintWriter(outputEdge);

		String split = "\t";

		// Ecriture des en-têtes
		printerEdge.write("Source" + split + "Target" + split + "Type" + split + "Weight\n");
		printerNode.write("Id" + split + "Label\n");

		HashMap<Integer, Integer> indexTranslation = new HashMap<Integer, Integer>(); // translation

		in.values().stream().flatMap(node -> node.getTSet().stream()).distinct().forEach(x -> {
			if (!indexTranslation.containsKey(x.getId())) {
				indexTranslation.put(x.getId(), indexTranslation.size());
				printerNode.write(indexTranslation.get(x.getId()) + split + x + "\n");
			}
			x.leaves.forEach(y -> {
				if (!indexTranslation.containsKey(y.getId())) {
					indexTranslation.put(y.getId(), indexTranslation.size());
					printerNode.write(indexTranslation.get(y.getId()) + split + y + "\n");
				}
				String printedEdge = indexTranslation.get(x.getId()) + split // Source
						+ indexTranslation.get(y.getId()) + split// Target
						+ "Directed" + split// Type
						+ "1"// Weight
						+ "\n";
				printerEdge.write(printedEdge);
			});
		});

		printerEdge.flush();
		printerNode.flush();
		printerNode.close();
		printerEdge.close();
	}

	public void exportVisual(Node.TreeType type) {
		PreviewJFrame previewJFrame = new PreviewJFrame(exportSet(type));
		previewJFrame.script();
	}

	public DirectedGraph exportGraph(/* String outputPath, */Node.TreeType type) {
		// Init a project - and therefore a workspace
		ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
		pc.newProject();

		// Get a graph model - it exists because we have a workspace
		GraphModel graphModel = Lookup.getDefault().lookup(GraphController.class).getModel();

		HashMap<Integer, org.gephi.graph.api.Node> indexTranslation = new HashMap<Integer, org.gephi.graph.api.Node>(); // translation
		DirectedGraph directedGraph = graphModel.getDirectedGraph();

		in.values().stream().flatMap(node -> node.getTSet().stream()).distinct().forEach(x -> {
			if (!indexTranslation.containsKey(x.getId())) {
				org.gephi.graph.api.Node n = graphModel.factory().newNode(Integer.toString(x.getId()));
				n.getNodeData().setLabel(x.toString());
				indexTranslation.put(x.getId(), n);
				directedGraph.addNode(n);
			}
			x.leaves.forEach(y -> {
				if (!indexTranslation.containsKey(y.getId())) {
					org.gephi.graph.api.Node n = graphModel.factory().newNode(Integer.toString(y.getId()));
					n.getNodeData().setLabel(y.toString());
					indexTranslation.put(y.getId(), n);
					directedGraph.addNode(n);
				}

				org.gephi.graph.api.Node n1 = indexTranslation.get(x.getId());
				org.gephi.graph.api.Node n2 = indexTranslation.get(y.getId());
				org.gephi.graph.api.Edge e = graphModel.factory().newEdge(n1, n2, 1f, true);
				directedGraph.addEdge(e);
			});
		});

		return directedGraph;
	}

	public Set<Node> exportSet(Node.TreeType type) {
		return in.values().stream().map(x -> type.export(x)).collect(Collectors.toCollection(HashSet<Node>::new));
	}

	public Collection<Node> values() {
		return in.values();
	}

	public Node getByCharacter(String character) {
		if (si.get(character) != null) {
			return in.get(si.get(character));
		}
		return null;
	}

	public Node getById(Integer id) {
		return in.get(id);
	}

	public int size() {
		return in.size();
	}

	public boolean isEmpty() {
		return in.isEmpty();
	}

	public Set<Entry<Integer, Node>> entrySetById() {
		return in.entrySet();
	}

	public Set<Entry<String, Node>> entrySetByCharacter() {
		return si.entrySet().stream().map(x -> {
			return new AbstractMap.SimpleEntry<String, Node>(x.getKey(), in.get(x.getValue()));
		}).collect(Collectors.toSet());
	}
}
