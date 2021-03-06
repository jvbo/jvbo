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
public class OkexFutureTickerDataAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8508185631186833294L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OkexFutureTickerDataAvro\",\"namespace\":\"site.jvbo.fun.okex.crawler.avro\",\"fields\":[{\"name\":\"high\",\"type\":[\"string\",\"null\"]},{\"name\":\"limitLow\",\"type\":[\"string\",\"null\"]},{\"name\":\"vol\",\"type\":[\"string\",\"null\"]},{\"name\":\"last\",\"type\":[\"string\",\"null\"]},{\"name\":\"low\",\"type\":[\"string\",\"null\"]},{\"name\":\"buy\",\"type\":[\"string\",\"null\"]},{\"name\":\"hold_amount\",\"type\":[\"string\",\"null\"]},{\"name\":\"sell\",\"type\":[\"string\",\"null\"]},{\"name\":\"contractId\",\"type\":[\"string\",\"null\"]},{\"name\":\"unitAmount\",\"type\":[\"string\",\"null\"]},{\"name\":\"limitHigh\",\"type\":[\"string\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<OkexFutureTickerDataAvro> ENCODER =
      new BinaryMessageEncoder<OkexFutureTickerDataAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OkexFutureTickerDataAvro> DECODER =
      new BinaryMessageDecoder<OkexFutureTickerDataAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<OkexFutureTickerDataAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<OkexFutureTickerDataAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<OkexFutureTickerDataAvro>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this OkexFutureTickerDataAvro to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a OkexFutureTickerDataAvro from a ByteBuffer. */
  public static OkexFutureTickerDataAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence high;
  @Deprecated public java.lang.CharSequence limitLow;
  @Deprecated public java.lang.CharSequence vol;
  @Deprecated public java.lang.CharSequence last;
  @Deprecated public java.lang.CharSequence low;
  @Deprecated public java.lang.CharSequence buy;
  @Deprecated public java.lang.CharSequence hold_amount;
  @Deprecated public java.lang.CharSequence sell;
  @Deprecated public java.lang.CharSequence contractId;
  @Deprecated public java.lang.CharSequence unitAmount;
  @Deprecated public java.lang.CharSequence limitHigh;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OkexFutureTickerDataAvro() {}

  /**
   * All-args constructor.
   * @param high The new value for high
   * @param limitLow The new value for limitLow
   * @param vol The new value for vol
   * @param last The new value for last
   * @param low The new value for low
   * @param buy The new value for buy
   * @param hold_amount The new value for hold_amount
   * @param sell The new value for sell
   * @param contractId The new value for contractId
   * @param unitAmount The new value for unitAmount
   * @param limitHigh The new value for limitHigh
   */
  public OkexFutureTickerDataAvro(java.lang.CharSequence high, java.lang.CharSequence limitLow, java.lang.CharSequence vol, java.lang.CharSequence last, java.lang.CharSequence low, java.lang.CharSequence buy, java.lang.CharSequence hold_amount, java.lang.CharSequence sell, java.lang.CharSequence contractId, java.lang.CharSequence unitAmount, java.lang.CharSequence limitHigh) {
    this.high = high;
    this.limitLow = limitLow;
    this.vol = vol;
    this.last = last;
    this.low = low;
    this.buy = buy;
    this.hold_amount = hold_amount;
    this.sell = sell;
    this.contractId = contractId;
    this.unitAmount = unitAmount;
    this.limitHigh = limitHigh;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return high;
    case 1: return limitLow;
    case 2: return vol;
    case 3: return last;
    case 4: return low;
    case 5: return buy;
    case 6: return hold_amount;
    case 7: return sell;
    case 8: return contractId;
    case 9: return unitAmount;
    case 10: return limitHigh;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: high = (java.lang.CharSequence)value$; break;
    case 1: limitLow = (java.lang.CharSequence)value$; break;
    case 2: vol = (java.lang.CharSequence)value$; break;
    case 3: last = (java.lang.CharSequence)value$; break;
    case 4: low = (java.lang.CharSequence)value$; break;
    case 5: buy = (java.lang.CharSequence)value$; break;
    case 6: hold_amount = (java.lang.CharSequence)value$; break;
    case 7: sell = (java.lang.CharSequence)value$; break;
    case 8: contractId = (java.lang.CharSequence)value$; break;
    case 9: unitAmount = (java.lang.CharSequence)value$; break;
    case 10: limitHigh = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'high' field.
   * @return The value of the 'high' field.
   */
  public java.lang.CharSequence getHigh() {
    return high;
  }

  /**
   * Sets the value of the 'high' field.
   * @param value the value to set.
   */
  public void setHigh(java.lang.CharSequence value) {
    this.high = value;
  }

  /**
   * Gets the value of the 'limitLow' field.
   * @return The value of the 'limitLow' field.
   */
  public java.lang.CharSequence getLimitLow() {
    return limitLow;
  }

  /**
   * Sets the value of the 'limitLow' field.
   * @param value the value to set.
   */
  public void setLimitLow(java.lang.CharSequence value) {
    this.limitLow = value;
  }

  /**
   * Gets the value of the 'vol' field.
   * @return The value of the 'vol' field.
   */
  public java.lang.CharSequence getVol() {
    return vol;
  }

  /**
   * Sets the value of the 'vol' field.
   * @param value the value to set.
   */
  public void setVol(java.lang.CharSequence value) {
    this.vol = value;
  }

  /**
   * Gets the value of the 'last' field.
   * @return The value of the 'last' field.
   */
  public java.lang.CharSequence getLast() {
    return last;
  }

  /**
   * Sets the value of the 'last' field.
   * @param value the value to set.
   */
  public void setLast(java.lang.CharSequence value) {
    this.last = value;
  }

  /**
   * Gets the value of the 'low' field.
   * @return The value of the 'low' field.
   */
  public java.lang.CharSequence getLow() {
    return low;
  }

  /**
   * Sets the value of the 'low' field.
   * @param value the value to set.
   */
  public void setLow(java.lang.CharSequence value) {
    this.low = value;
  }

  /**
   * Gets the value of the 'buy' field.
   * @return The value of the 'buy' field.
   */
  public java.lang.CharSequence getBuy() {
    return buy;
  }

  /**
   * Sets the value of the 'buy' field.
   * @param value the value to set.
   */
  public void setBuy(java.lang.CharSequence value) {
    this.buy = value;
  }

  /**
   * Gets the value of the 'hold_amount' field.
   * @return The value of the 'hold_amount' field.
   */
  public java.lang.CharSequence getHoldAmount() {
    return hold_amount;
  }

  /**
   * Sets the value of the 'hold_amount' field.
   * @param value the value to set.
   */
  public void setHoldAmount(java.lang.CharSequence value) {
    this.hold_amount = value;
  }

  /**
   * Gets the value of the 'sell' field.
   * @return The value of the 'sell' field.
   */
  public java.lang.CharSequence getSell() {
    return sell;
  }

  /**
   * Sets the value of the 'sell' field.
   * @param value the value to set.
   */
  public void setSell(java.lang.CharSequence value) {
    this.sell = value;
  }

  /**
   * Gets the value of the 'contractId' field.
   * @return The value of the 'contractId' field.
   */
  public java.lang.CharSequence getContractId() {
    return contractId;
  }

  /**
   * Sets the value of the 'contractId' field.
   * @param value the value to set.
   */
  public void setContractId(java.lang.CharSequence value) {
    this.contractId = value;
  }

  /**
   * Gets the value of the 'unitAmount' field.
   * @return The value of the 'unitAmount' field.
   */
  public java.lang.CharSequence getUnitAmount() {
    return unitAmount;
  }

  /**
   * Sets the value of the 'unitAmount' field.
   * @param value the value to set.
   */
  public void setUnitAmount(java.lang.CharSequence value) {
    this.unitAmount = value;
  }

  /**
   * Gets the value of the 'limitHigh' field.
   * @return The value of the 'limitHigh' field.
   */
  public java.lang.CharSequence getLimitHigh() {
    return limitHigh;
  }

  /**
   * Sets the value of the 'limitHigh' field.
   * @param value the value to set.
   */
  public void setLimitHigh(java.lang.CharSequence value) {
    this.limitHigh = value;
  }

  /**
   * Creates a new OkexFutureTickerDataAvro RecordBuilder.
   * @return A new OkexFutureTickerDataAvro RecordBuilder
   */
  public static site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder newBuilder() {
    return new site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder();
  }

  /**
   * Creates a new OkexFutureTickerDataAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OkexFutureTickerDataAvro RecordBuilder
   */
  public static site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder newBuilder(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder other) {
    return new site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder(other);
  }

  /**
   * Creates a new OkexFutureTickerDataAvro RecordBuilder by copying an existing OkexFutureTickerDataAvro instance.
   * @param other The existing instance to copy.
   * @return A new OkexFutureTickerDataAvro RecordBuilder
   */
  public static site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder newBuilder(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro other) {
    return new site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder(other);
  }

  /**
   * RecordBuilder for OkexFutureTickerDataAvro instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OkexFutureTickerDataAvro>
    implements org.apache.avro.data.RecordBuilder<OkexFutureTickerDataAvro> {

    private java.lang.CharSequence high;
    private java.lang.CharSequence limitLow;
    private java.lang.CharSequence vol;
    private java.lang.CharSequence last;
    private java.lang.CharSequence low;
    private java.lang.CharSequence buy;
    private java.lang.CharSequence hold_amount;
    private java.lang.CharSequence sell;
    private java.lang.CharSequence contractId;
    private java.lang.CharSequence unitAmount;
    private java.lang.CharSequence limitHigh;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.high)) {
        this.high = data().deepCopy(fields()[0].schema(), other.high);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.limitLow)) {
        this.limitLow = data().deepCopy(fields()[1].schema(), other.limitLow);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.vol)) {
        this.vol = data().deepCopy(fields()[2].schema(), other.vol);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.last)) {
        this.last = data().deepCopy(fields()[3].schema(), other.last);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.low)) {
        this.low = data().deepCopy(fields()[4].schema(), other.low);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.buy)) {
        this.buy = data().deepCopy(fields()[5].schema(), other.buy);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.hold_amount)) {
        this.hold_amount = data().deepCopy(fields()[6].schema(), other.hold_amount);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.sell)) {
        this.sell = data().deepCopy(fields()[7].schema(), other.sell);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.contractId)) {
        this.contractId = data().deepCopy(fields()[8].schema(), other.contractId);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.unitAmount)) {
        this.unitAmount = data().deepCopy(fields()[9].schema(), other.unitAmount);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.limitHigh)) {
        this.limitHigh = data().deepCopy(fields()[10].schema(), other.limitHigh);
        fieldSetFlags()[10] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing OkexFutureTickerDataAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.high)) {
        this.high = data().deepCopy(fields()[0].schema(), other.high);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.limitLow)) {
        this.limitLow = data().deepCopy(fields()[1].schema(), other.limitLow);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.vol)) {
        this.vol = data().deepCopy(fields()[2].schema(), other.vol);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.last)) {
        this.last = data().deepCopy(fields()[3].schema(), other.last);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.low)) {
        this.low = data().deepCopy(fields()[4].schema(), other.low);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.buy)) {
        this.buy = data().deepCopy(fields()[5].schema(), other.buy);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.hold_amount)) {
        this.hold_amount = data().deepCopy(fields()[6].schema(), other.hold_amount);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.sell)) {
        this.sell = data().deepCopy(fields()[7].schema(), other.sell);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.contractId)) {
        this.contractId = data().deepCopy(fields()[8].schema(), other.contractId);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.unitAmount)) {
        this.unitAmount = data().deepCopy(fields()[9].schema(), other.unitAmount);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.limitHigh)) {
        this.limitHigh = data().deepCopy(fields()[10].schema(), other.limitHigh);
        fieldSetFlags()[10] = true;
      }
    }

    /**
      * Gets the value of the 'high' field.
      * @return The value.
      */
    public java.lang.CharSequence getHigh() {
      return high;
    }

    /**
      * Sets the value of the 'high' field.
      * @param value The value of 'high'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder setHigh(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.high = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'high' field has been set.
      * @return True if the 'high' field has been set, false otherwise.
      */
    public boolean hasHigh() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'high' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder clearHigh() {
      high = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'limitLow' field.
      * @return The value.
      */
    public java.lang.CharSequence getLimitLow() {
      return limitLow;
    }

    /**
      * Sets the value of the 'limitLow' field.
      * @param value The value of 'limitLow'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder setLimitLow(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.limitLow = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'limitLow' field has been set.
      * @return True if the 'limitLow' field has been set, false otherwise.
      */
    public boolean hasLimitLow() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'limitLow' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder clearLimitLow() {
      limitLow = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'vol' field.
      * @return The value.
      */
    public java.lang.CharSequence getVol() {
      return vol;
    }

    /**
      * Sets the value of the 'vol' field.
      * @param value The value of 'vol'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder setVol(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.vol = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'vol' field has been set.
      * @return True if the 'vol' field has been set, false otherwise.
      */
    public boolean hasVol() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'vol' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder clearVol() {
      vol = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'last' field.
      * @return The value.
      */
    public java.lang.CharSequence getLast() {
      return last;
    }

    /**
      * Sets the value of the 'last' field.
      * @param value The value of 'last'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder setLast(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.last = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'last' field has been set.
      * @return True if the 'last' field has been set, false otherwise.
      */
    public boolean hasLast() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'last' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder clearLast() {
      last = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'low' field.
      * @return The value.
      */
    public java.lang.CharSequence getLow() {
      return low;
    }

    /**
      * Sets the value of the 'low' field.
      * @param value The value of 'low'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder setLow(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.low = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'low' field has been set.
      * @return True if the 'low' field has been set, false otherwise.
      */
    public boolean hasLow() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'low' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder clearLow() {
      low = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'buy' field.
      * @return The value.
      */
    public java.lang.CharSequence getBuy() {
      return buy;
    }

    /**
      * Sets the value of the 'buy' field.
      * @param value The value of 'buy'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder setBuy(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.buy = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'buy' field has been set.
      * @return True if the 'buy' field has been set, false otherwise.
      */
    public boolean hasBuy() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'buy' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder clearBuy() {
      buy = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'hold_amount' field.
      * @return The value.
      */
    public java.lang.CharSequence getHoldAmount() {
      return hold_amount;
    }

    /**
      * Sets the value of the 'hold_amount' field.
      * @param value The value of 'hold_amount'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder setHoldAmount(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.hold_amount = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'hold_amount' field has been set.
      * @return True if the 'hold_amount' field has been set, false otherwise.
      */
    public boolean hasHoldAmount() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'hold_amount' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder clearHoldAmount() {
      hold_amount = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'sell' field.
      * @return The value.
      */
    public java.lang.CharSequence getSell() {
      return sell;
    }

    /**
      * Sets the value of the 'sell' field.
      * @param value The value of 'sell'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder setSell(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.sell = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'sell' field has been set.
      * @return True if the 'sell' field has been set, false otherwise.
      */
    public boolean hasSell() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'sell' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder clearSell() {
      sell = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'contractId' field.
      * @return The value.
      */
    public java.lang.CharSequence getContractId() {
      return contractId;
    }

    /**
      * Sets the value of the 'contractId' field.
      * @param value The value of 'contractId'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder setContractId(java.lang.CharSequence value) {
      validate(fields()[8], value);
      this.contractId = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'contractId' field has been set.
      * @return True if the 'contractId' field has been set, false otherwise.
      */
    public boolean hasContractId() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'contractId' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder clearContractId() {
      contractId = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'unitAmount' field.
      * @return The value.
      */
    public java.lang.CharSequence getUnitAmount() {
      return unitAmount;
    }

    /**
      * Sets the value of the 'unitAmount' field.
      * @param value The value of 'unitAmount'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder setUnitAmount(java.lang.CharSequence value) {
      validate(fields()[9], value);
      this.unitAmount = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'unitAmount' field has been set.
      * @return True if the 'unitAmount' field has been set, false otherwise.
      */
    public boolean hasUnitAmount() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'unitAmount' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder clearUnitAmount() {
      unitAmount = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'limitHigh' field.
      * @return The value.
      */
    public java.lang.CharSequence getLimitHigh() {
      return limitHigh;
    }

    /**
      * Sets the value of the 'limitHigh' field.
      * @param value The value of 'limitHigh'.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder setLimitHigh(java.lang.CharSequence value) {
      validate(fields()[10], value);
      this.limitHigh = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'limitHigh' field has been set.
      * @return True if the 'limitHigh' field has been set, false otherwise.
      */
    public boolean hasLimitHigh() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'limitHigh' field.
      * @return This builder.
      */
    public site.jvbo.fun.okex.crawler.avro.OkexFutureTickerDataAvro.Builder clearLimitHigh() {
      limitHigh = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OkexFutureTickerDataAvro build() {
      try {
        OkexFutureTickerDataAvro record = new OkexFutureTickerDataAvro();
        record.high = fieldSetFlags()[0] ? this.high : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.limitLow = fieldSetFlags()[1] ? this.limitLow : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.vol = fieldSetFlags()[2] ? this.vol : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.last = fieldSetFlags()[3] ? this.last : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.low = fieldSetFlags()[4] ? this.low : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.buy = fieldSetFlags()[5] ? this.buy : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.hold_amount = fieldSetFlags()[6] ? this.hold_amount : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.sell = fieldSetFlags()[7] ? this.sell : (java.lang.CharSequence) defaultValue(fields()[7]);
        record.contractId = fieldSetFlags()[8] ? this.contractId : (java.lang.CharSequence) defaultValue(fields()[8]);
        record.unitAmount = fieldSetFlags()[9] ? this.unitAmount : (java.lang.CharSequence) defaultValue(fields()[9]);
        record.limitHigh = fieldSetFlags()[10] ? this.limitHigh : (java.lang.CharSequence) defaultValue(fields()[10]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OkexFutureTickerDataAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<OkexFutureTickerDataAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OkexFutureTickerDataAvro>
    READER$ = (org.apache.avro.io.DatumReader<OkexFutureTickerDataAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
