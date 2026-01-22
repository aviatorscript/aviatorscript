/**
 * Copyright (C) 2010 dennis zhuang (killme2008@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/


package com.googlecode.aviator.runtime.type;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import com.googlecode.aviator.exception.CompareNotSupportedException;
import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.utils.TypeUtils;


/**
 * Aviator number type
 *
 * @author dennis
 *
 */
public abstract class AviatorNumber extends AviatorObject {
  /**
   *
   */
  private static final long serialVersionUID = 6775726371182360535L;
  /**
   * Number union
   */
  // Only for bigint/decimal
  protected Number number;
  // Only valid for AviatorLong
  protected long longValue;
  // Only valid for AviatorDouble
  protected double doubleValue;


  public AviatorNumber(final long longValue) {
    super();
    this.longValue = longValue;
  }


  public AviatorNumber(final double doubleValue) {
    super();
    this.doubleValue = doubleValue;
  }



  public AviatorNumber(final Number number) {
    super();
    this.number = number;
  }


  @Override
  public Object getValue(final Map<String, Object> env) {
    return this.number;
  }


  public static AviatorNumber valueOf(final Object value) {
    if (TypeUtils.isLong(value)) {
      return AviatorLong.valueOf(((Number) value).longValue());
    } else if (TypeUtils.isDouble(value)) {
      return new AviatorDouble(((Number) value).doubleValue());
    } else if (TypeUtils.isBigInt(value)) {
      return AviatorBigInt.valueOf((BigInteger) value);
    } else if (TypeUtils.isDecimal(value)) {
      return AviatorDecimal.valueOf((BigDecimal) value);
    } else {
      throw new ClassCastException("Could not cast " + value.getClass().getName() + " to Number");
    }

  }


  public double doubleValue() {
    return this.number.doubleValue();
  }


  @Override
  public AviatorObject add(final AviatorObject other, final Map<String, Object> env) {
    switch (other.getAviatorType()) {
      case String:
        return new AviatorString(getValue(env).toString() + ((AviatorString) other).getLexeme(env));
      case BigInt:
      case Decimal:
      case Long:
      case Double:
        return innerAdd(env, (AviatorNumber) other);
      case JavaType:
        AviatorJavaType otherJavaType = (AviatorJavaType) other;
        final Object otherValue = otherJavaType.getValue(env);
        if (otherValue instanceof Number) {
          return innerAdd(env, AviatorNumber.valueOf(otherValue));
        } else if (TypeUtils.isString(otherValue)) {
          return new AviatorString(getValue(env).toString() + otherValue);
        } else {
          return super.add(other, env);
        }
      default:
        return super.add(other, env);
    }

  }


  @Override
  public AviatorObject sub(final AviatorObject other, final Map<String, Object> env) {
    switch (other.getAviatorType()) {
      case BigInt:
      case Decimal:
      case Long:
      case Double:
        return innerSub(env, (AviatorNumber) other);
      case JavaType:
        AviatorJavaType otherJavaType = (AviatorJavaType) other;
        final Object otherValue = otherJavaType.getValue(env);
        if (otherValue instanceof Number) {
          return innerSub(env, AviatorNumber.valueOf(otherValue));
        } else {
          return super.sub(other, env);
        }
      default:
        return super.sub(other, env);
    }

  }


  @Override
  public AviatorObject mod(final AviatorObject other, final Map<String, Object> env) {
    switch (other.getAviatorType()) {
      case BigInt:
      case Decimal:
      case Long:
      case Double:
        return innerMod(env, (AviatorNumber) other);
      case JavaType:
        AviatorJavaType otherJavaType = (AviatorJavaType) other;
        final Object otherValue = otherJavaType.getValue(env);
        if (otherValue instanceof Number) {
          return innerMod(env, AviatorNumber.valueOf(otherValue));
        } else {
          return super.mod(other, env);
        }
      default:
        return super.mod(other, env);
    }
  }


  @Override
  public AviatorObject div(final AviatorObject other, final Map<String, Object> env) {
    switch (other.getAviatorType()) {
      case BigInt:
      case Decimal:
      case Long:
      case Double:
        return innerDiv(env, (AviatorNumber) other);
      case JavaType:
        AviatorJavaType otherJavaType = (AviatorJavaType) other;
        final Object otherValue = otherJavaType.getValue(env);
        if (otherValue instanceof Number) {
          return innerDiv(env, AviatorNumber.valueOf(otherValue));
        } else {
          return super.div(other, env);
        }
      default:
        return super.div(other, env);
    }

  }


  @Override
  public AviatorObject mult(final AviatorObject other, final Map<String, Object> env) {
    switch (other.getAviatorType()) {
      case BigInt:
      case Decimal:
      case Long:
      case Double:
        return innerMult(env, (AviatorNumber) other);
      case JavaType:
        AviatorJavaType otherJavaType = (AviatorJavaType) other;
        final Object otherValue = otherJavaType.getValue(env);
        if (otherValue instanceof Number) {
          return innerMult(env, AviatorNumber.valueOf(otherValue));
        } else {
          return super.mult(other, env);
        }
      default:
        return super.mult(other, env);
    }

  }


  @Override
  public int innerCompare(final AviatorObject other, final Map<String, Object> env) {
    switch (other.getAviatorType()) {
      case BigInt:
      case Decimal:
      case Long:
      case Double:
        return innerCompare(env, (AviatorNumber) other);
      case JavaType:
        AviatorJavaType otherJavaType = (AviatorJavaType) other;
        final Object otherValue = otherJavaType.getValue(env);
        if (otherValue == null) {
          return 1;
        }
        if (otherValue instanceof Number) {
          return innerCompare(env, AviatorNumber.valueOf(otherValue));
        } else {
          throw new CompareNotSupportedException(
              "Could not compare " + desc(env) + " with " + other.desc(env));
        }
      case Nil:
        return 1;
      default:
        throw new CompareNotSupportedException(
            "Could not compare " + desc(env) + " with " + other.desc(env));

    }
  }


  public abstract AviatorObject innerSub(Map<String, Object> env, AviatorNumber other);


  public abstract AviatorObject innerMult(Map<String, Object> env, AviatorNumber other);


  public abstract AviatorObject innerMod(Map<String, Object> env, AviatorNumber other);


  public abstract AviatorObject innerDiv(Map<String, Object> env, AviatorNumber other);


  public abstract AviatorObject innerAdd(Map<String, Object> env, AviatorNumber other);


  public abstract int innerCompare(Map<String, Object> env, AviatorNumber other);


  public long longValue() {
    return this.number.longValue();
  }


  public final BigInteger toBigInt() {
    if (TypeUtils.isBigInt(this.number)) {
      return (BigInteger) this.number;
    } else {
      return new BigInteger(String.valueOf(longValue()));
    }
  }


  public final BigDecimal toDecimal(final Map<String, Object> env) {
    if (TypeUtils.isDecimal(this.number)) {
      return (BigDecimal) this.number;
    } else if (TypeUtils.isBigInt(this.number)) {
      return new BigDecimal(toBigInt());
    } else {
      return new BigDecimal(doubleValue(), RuntimeUtils.getMathContext(env));
    }
  }
}
