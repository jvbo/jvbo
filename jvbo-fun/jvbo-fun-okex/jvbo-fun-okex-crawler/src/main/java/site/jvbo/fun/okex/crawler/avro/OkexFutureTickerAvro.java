/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package site.jvbo.fun.okex.crawler.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class OkexFutureTickerAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7545105223590317733L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OkexFutureTickerAvro\",\"namespace\":\"site.jvbo.fun.okex.crawler.avro\",\"fields\":[{\"name\":\"timestamp\",\"type\":[\"long\",\"null\"]},{\"name\":\"market\",\"type\":[\"string\",\"null\"]},{\"name\":\"symbol\",\"type\":[\"string\",\"null\"]},{\"name\":\"data\",\"type\":{\"type\":\"record\",\"name\":\"OkexFutureTickerDataAvro\",\"fields\":[{\"name\":\"high\",\"type\":[\"string\",\"null\"]},{\"name\":\"limitLow\",\"type\":[\"string\",\"null\"]},{\"name\":\"vol\",\"type\":[\"string\",\"null\"]},{\"name\":\"last\",\"type\":[\"string\",\"null\"]},{\"name\":\"low\",\"type\":[\"string\",\"null\"]},{\"name\":\"buy\",\"type\":[\"string\",\"null\"]},{\"name\":\"hold_amount\",\"type\":[\"string\",\"null\"]},{\"name\":\"sell\",\"type\":[\"string\",\"null\"]},{\"name\":\"contractId\",\"type\":[\"string\",\"null\"]},{\"name\":\"unitAmount\",\"type\":[\"string\",\"null\"]},{\"name\":\"limitHigh\",\"type\":[\"string\",\"null\"]}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<OkexFutureTickerAvro> ENCODER =
      new BinaryMessageEncoder<OkexFutureTickerAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OkexFutureTickerAvro> DECODER =
      new BinaryMessageDecoder<OkexFutureTickerAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<OkexFutureTickerAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<OkexFutureTickerAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<OkexFutureTickerAvro>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this OkexFutureTickerAvro to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a OkexFutureTickerAvro from a ByteBuffer. */
  public static OkexFutureTickerAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.Long timestamp;
  @Deprecated public java.lang.CharSequence market;
  @Deprecated public java.lang.CharSequence symbol;
  @Deprecated public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro data;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OkexFutureTickerAvro() {}

  /**
   * All-args constructor.
   * @param timestamp The new value for timestamp
   * @param market The new value for market
   * @param symbol The new value for symbol
   * @param data The new value for data
   */
  public OkexFutureTickerAvro(java.lang.Long timestamp, java.lang.CharSequence market, java.lang.CharSequence symbol, site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro data) {
    this.timestamp = timestamp;
    this.market = market;
    this.symbol = symbol;
    this.data = data;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return timestamp;
    case 1: return market;
    case 2: return symbol;
    case 3: return data;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: timestamp = (java.lang.Long)value$; break;
    case 1: market = (java.lang.CharSequence)value$; break;
    case 2: symbol = (java.lang.CharSequence)value$; break;
    case 3: data = (site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return The value of the 'timestamp' field.
   */
  public java.lang.Long getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(java.lang.Long value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'market' field.
   * @return The value of the 'market' field.
   */
  public java.lang.CharSequence getMarket() {
    return market;
  }

  /**
   * Sets the value of the 'market' field.
   * @param value the value to set.
   */
  public void setMarket(java.lang.CharSequence value) {
    this.market = value;
  }

  /**
   * Gets the value of the 'symbol' field.
   * @return The value of the 'symbol' field.
   */
  public java.lang.CharSequence getSymbol() {
    return symbol;
  }

  /**
   * Sets the value of the 'symbol' field.
   * @param value the value to set.
   */
  public void setSymbol(java.lang.CharSequence value) {
    this.symbol = value;
  }

  /**
   * Gets the value of the 'data' field.
   * @return The value of the 'data' field.
   */
  public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro getData() {
    return data;
  }

  /**
   * Sets the value of the 'data' field.
   * @param value the value to set.
   */
  public void setData(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro value) {
    this.data = value;
  }

  /**
   * Creates a new OkexFutureTickerAvro RecordBuilder.
   * @return A new OkexFutureTickerAvro RecordBuilder
   */
  public static site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder newBuilder() {
    return new site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder();
  }

  /**
   * Creates a new OkexFutureTickerAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OkexFutureTickerAvro RecordBuilder
   */
  public static site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder newBuilder(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder other) {
    return new site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder(other);
  }

  /**
   * Creates a new OkexFutureTickerAvro RecordBuilder by copying an existing OkexFutureTickerAvro instance.
   * @param other The existing instance to copy.
   * @return A new OkexFutureTickerAvro RecordBuilder
   */
  public static site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder newBuilder(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro other) {
    return new site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder(other);
  }

  /**
   * RecordBuilder for OkexFutureTickerAvro instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OkexFutureTickerAvro>
    implements org.apache.avro.data.RecordBuilder<OkexFutureTickerAvro> {

    private java.lang.Long timestamp;
    private java.lang.CharSequence market;
    private java.lang.CharSequence symbol;
    private site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro data;
    private site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder dataBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[0].schema(), other.timestamp);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.market)) {
        this.market = data().deepCopy(fields()[1].schema(), other.market);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.symbol)) {
        this.symbol = data().deepCopy(fields()[2].schema(), other.symbol);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.data)) {
        this.data = data().deepCopy(fields()[3].schema(), other.data);
        fieldSetFlags()[3] = true;
      }
      if (other.hasDataBuilder()) {
        this.dataBuilder = site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.newBuilder(other.getDataBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing OkexFutureTickerAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[0].schema(), other.timestamp);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.market)) {
        this.market = data().deepCopy(fields()[1].schema(), other.market);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.symbol)) {
        this.symbol = data().deepCopy(fields()[2].schema(), other.symbol);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.data)) {
        this.data = data().deepCopy(fields()[3].schema(), other.data);
        fieldSetFlags()[3] = true;
      }
      this.dataBuilder = null;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * @return The value.
      */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }

    /**
      * Sets the value of the 'timestamp' field.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder setTimestamp(java.lang.Long value) {
      validate(fields()[0], value);
      this.timestamp = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder clearTimestamp() {
      timestamp = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'market' field.
      * @return The value.
      */
    public java.lang.CharSequence getMarket() {
      return market;
    }

    /**
      * Sets the value of the 'market' field.
      * @param value The value of 'market'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder setMarket(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.market = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'market' field has been set.
      * @return True if the 'market' field has been set, false otherwise.
      */
    public boolean hasMarket() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'market' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder clearMarket() {
      market = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'symbol' field.
      * @return The value.
      */
    public java.lang.CharSequence getSymbol() {
      return symbol;
    }

    /**
      * Sets the value of the 'symbol' field.
      * @param value The value of 'symbol'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder setSymbol(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.symbol = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'symbol' field has been set.
      * @return True if the 'symbol' field has been set, false otherwise.
      */
    public boolean hasSymbol() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'symbol' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder clearSymbol() {
      symbol = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'data' field.
      * @return The value.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro getData() {
      return data;
    }

    /**
      * Sets the value of the 'data' field.
      * @param value The value of 'data'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder setData(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro value) {
      validate(fields()[3], value);
      this.dataBuilder = null;
      this.data = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'data' field has been set.
      * @return True if the 'data' field has been set, false otherwise.
      */
    public boolean hasData() {
      return fieldSetFlags()[3];
    }

    /**
     * Gets the Builder instance for the 'data' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder getDataBuilder() {
      if (dataBuilder == null) {
        if (hasData()) {
          setDataBuilder(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.newBuilder(data));
        } else {
          setDataBuilder(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.newBuilder());
        }
      }
      return dataBuilder;
    }

    /**
     * Sets the Builder instance for the 'data' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder setDataBuilder(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder value) {
      clearData();
      dataBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'data' field has an active Builder instance
     * @return True if the 'data' field has an active Builder instance
     */
    public boolean hasDataBuilder() {
      return dataBuilder != null;
    }

    /**
      * Clears the value of the 'data' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerAvro.Builder clearData() {
      data = null;
      dataBuilder = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OkexFutureTickerAvro build() {
      try {
        OkexFutureTickerAvro record = new OkexFutureTickerAvro();
        record.timestamp = fieldSetFlags()[0] ? this.timestamp : (java.lang.Long) defaultValue(fields()[0]);
        record.market = fieldSetFlags()[1] ? this.market : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.symbol = fieldSetFlags()[2] ? this.symbol : (java.lang.CharSequence) defaultValue(fields()[2]);
        if (dataBuilder != null) {
          record.data = this.dataBuilder.build();
        } else {
          record.data = fieldSetFlags()[3] ? this.data : (site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro) defaultValue(fields()[3]);
        }
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OkexFutureTickerAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<OkexFutureTickerAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OkexFutureTickerAvro>
    READER$ = (org.apache.avro.io.DatumReader<OkexFutureTickerAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
