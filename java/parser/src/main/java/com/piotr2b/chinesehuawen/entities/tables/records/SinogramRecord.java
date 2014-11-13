/**
 * This class is generated by jOOQ
 */
package com.piotr2b.chinesehuawen.entities.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SinogramRecord extends org.jooq.impl.UpdatableRecordImpl<com.piotr2b.chinesehuawen.entities.tables.records.SinogramRecord> implements org.jooq.Record7<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Byte, java.lang.Byte> {

	private static final long serialVersionUID = -577356774;

	/**
	 * Setter for <code>chinese.sinogram.cp</code>.
	 */
	public void setCp(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>chinese.sinogram.cp</code>.
	 */
	public java.lang.String getCp() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>chinese.sinogram.semantics</code>.
	 */
	public void setSemantics(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>chinese.sinogram.semantics</code>.
	 */
	public java.lang.String getSemantics() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>chinese.sinogram.consonants</code>.
	 */
	public void setConsonants(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>chinese.sinogram.consonants</code>.
	 */
	public java.lang.String getConsonants() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>chinese.sinogram.rhyme</code>.
	 */
	public void setRhyme(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>chinese.sinogram.rhyme</code>.
	 */
	public java.lang.String getRhyme() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>chinese.sinogram.tone</code>.
	 */
	public void setTone(java.lang.Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>chinese.sinogram.tone</code>.
	 */
	public java.lang.Integer getTone() {
		return (java.lang.Integer) getValue(4);
	}

	/**
	 * Setter for <code>chinese.sinogram.stroke</code>.
	 */
	public void setStroke(java.lang.Byte value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>chinese.sinogram.stroke</code>.
	 */
	public java.lang.Byte getStroke() {
		return (java.lang.Byte) getValue(5);
	}

	/**
	 * Setter for <code>chinese.sinogram.frequency</code>.
	 */
	public void setFrequency(java.lang.Byte value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>chinese.sinogram.frequency</code>.
	 */
	public java.lang.Byte getFrequency() {
		return (java.lang.Byte) getValue(6);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.String> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Byte, java.lang.Byte> fieldsRow() {
		return (org.jooq.Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Byte, java.lang.Byte> valuesRow() {
		return (org.jooq.Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return com.piotr2b.chinesehuawen.entities.tables.Sinogram.SINOGRAM.CP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.piotr2b.chinesehuawen.entities.tables.Sinogram.SINOGRAM.SEMANTICS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return com.piotr2b.chinesehuawen.entities.tables.Sinogram.SINOGRAM.CONSONANTS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return com.piotr2b.chinesehuawen.entities.tables.Sinogram.SINOGRAM.RHYME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field5() {
		return com.piotr2b.chinesehuawen.entities.tables.Sinogram.SINOGRAM.TONE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Byte> field6() {
		return com.piotr2b.chinesehuawen.entities.tables.Sinogram.SINOGRAM.STROKE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Byte> field7() {
		return com.piotr2b.chinesehuawen.entities.tables.Sinogram.SINOGRAM.FREQUENCY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value1() {
		return getCp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getSemantics();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getConsonants();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getRhyme();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value5() {
		return getTone();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Byte value6() {
		return getStroke();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Byte value7() {
		return getFrequency();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SinogramRecord value1(java.lang.String value) {
		setCp(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SinogramRecord value2(java.lang.String value) {
		setSemantics(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SinogramRecord value3(java.lang.String value) {
		setConsonants(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SinogramRecord value4(java.lang.String value) {
		setRhyme(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SinogramRecord value5(java.lang.Integer value) {
		setTone(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SinogramRecord value6(java.lang.Byte value) {
		setStroke(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SinogramRecord value7(java.lang.Byte value) {
		setFrequency(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SinogramRecord values(java.lang.String value1, java.lang.String value2, java.lang.String value3, java.lang.String value4, java.lang.Integer value5, java.lang.Byte value6, java.lang.Byte value7) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached SinogramRecord
	 */
	public SinogramRecord() {
		super(com.piotr2b.chinesehuawen.entities.tables.Sinogram.SINOGRAM);
	}

	/**
	 * Create a detached, initialised SinogramRecord
	 */
	public SinogramRecord(java.lang.String cp, java.lang.String semantics, java.lang.String consonants, java.lang.String rhyme, java.lang.Integer tone, java.lang.Byte stroke, java.lang.Byte frequency) {
		super(com.piotr2b.chinesehuawen.entities.tables.Sinogram.SINOGRAM);

		setValue(0, cp);
		setValue(1, semantics);
		setValue(2, consonants);
		setValue(3, rhyme);
		setValue(4, tone);
		setValue(5, stroke);
		setValue(6, frequency);
	}
}