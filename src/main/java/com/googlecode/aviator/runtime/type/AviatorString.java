/**
 * Copyright (C) 2010 dennis zhuang (killme2008@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 **/


package com.googlecode.aviator.runtime.type;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.AviatorEvaluatorInstance.StringSegments;
import com.googlecode.aviator.BaseExpression;
import com.googlecode.aviator.Feature;
import com.googlecode.aviator.exception.CompareNotSupportedException;
import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.utils.Constants;
import com.googlecode.aviator.utils.Env;
import com.googlecode.aviator.utils.TypeUtils;

/**
 * A aviator string
 *
 * @author dennis
 *
 */
public class AviatorString extends AviatorObject {

  private static final long serialVersionUID = -7430694306919959899L;
  private final String lexeme;
  private final boolean isLiteral;
  private boolean hasInterpolation = true; // default must be true to avoid corner cases;
  private int lineNo;

  @Override
  public String desc(final Map<String, Object> env) {
    Object val = this.getLexeme(env, false);
    if (val != this) {
      return "<" + getAviatorType() + ", " + val + ">";
    } else {
      return "<" + getAviatorType() + ", this>";
    }
  }

  @Override
  public AviatorType getAviatorType() {
    return AviatorType.String;
  }

  @Override
  public Object getValue(final Map<String, Object> env) {
    return getLexeme(env);
  }

  public AviatorString(final String lexeme) {
    this(lexeme, false);
  }

  public AviatorString(final String lexeme, final boolean isLiteral) {
    super();
    this.lexeme = lexeme;
    this.isLiteral = isLiteral;
  }

  public AviatorString(final String lexeme, final boolean isLiteral, final boolean hasInterpolation,
      final int lineNo) {
    super();
    this.lexeme = lexeme;
    this.isLiteral = isLiteral;
    this.hasInterpolation = hasInterpolation;
    this.lineNo = lineNo;
  }

  @Override
  public AviatorObject add(final AviatorObject other, final Map<String, Object> env) {
    final StringBuilder sb = new StringBuilder(getLexeme(env));

    if (other.getAviatorType() != AviatorType.Pattern) {
      sb.append(other.getValue(env));
    } else {
      final AviatorPattern otherPatterh = (AviatorPattern) other;
      sb.append(otherPatterh.pattern.pattern());
    }
    return new AviatorStringBuilder(sb);
  }

  private static final ThreadLocal<SimpleDateFormat> DATE_FORMATTER =
      new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected SimpleDateFormat initialValue() {
          return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        }

      };

  private int tryCompareDate(final Map<String, Object> env, final Date otherDate) {
    try {
      final SimpleDateFormat simpleDateFormat = DATE_FORMATTER.get();
      final Date thisDate = simpleDateFormat.parse(getLexeme(env));
      return thisDate.compareTo(otherDate);
    } catch (final Throwable t) {
      throw new ExpressionRuntimeException("Compare date error", t);
    }
  }

  @Override
  public int innerCompare(final AviatorObject other, final Map<String, Object> env) {
    final String left = getLexeme(env);

    if (other.getAviatorType() == AviatorType.String) {
      final AviatorString otherString = (AviatorString) other;
      final String right = otherString.getLexeme(env);
      if (left != null && right != null) {
        return left.compareTo(right);
      } else if (left == null && right != null) {
        return -1;
      } else if (left != null && right == null) {
        return 1;
      } else {
        return 0;
      }
    }

    switch (other.getAviatorType()) {
      case JavaType:
        final AviatorJavaType javaType = (AviatorJavaType) other;
        final Object otherJavaValue = javaType.getValue(env);
        if (left == null && otherJavaValue == null) {
          return 0;
        } else if (left != null && otherJavaValue == null) {
          return 1;
        }
        if (TypeUtils.isString(otherJavaValue)) {
          if (left == null) {
            return -1;
          } else {
            return left.compareTo(String.valueOf(otherJavaValue));
          }
        } else if (otherJavaValue instanceof Date) {
          return tryCompareDate(env, (Date) otherJavaValue);
        } else {
          throw new CompareNotSupportedException(
              "Could not compare " + desc(env) + " with " + other.desc(env));
        }
      case Nil:
        if (left == null) {
          return 0;
        } else {
          return 1;
        }
      default:
        throw new CompareNotSupportedException(
            "Could not compare " + desc(env) + " with " + other.desc(env));
    }
  }

  public String getLexeme(final Map<String, Object> env) {
    return this.getLexeme(env, true);
  }

  public String getLexeme(final Map<String, Object> env, final boolean warnOnCompile) {
    AviatorEvaluatorInstance engine = RuntimeUtils.getInstance(env);
    if (!this.isLiteral || !this.hasInterpolation
        || !engine.isFeatureEnabled(Feature.StringInterpolation) || this.lexeme == null
        || this.lexeme.length() < 3) {
      return this.lexeme;
    }
    StringSegments segs = null;
    BaseExpression exp = (BaseExpression) ((env == null || !(env instanceof Env)) ? null
        : ((Env) env).getExpression());
    if (exp != null) {
      segs = exp.getStringSegements(this.lexeme, this.lineNo);
    } else {
      segs = engine.compileStringSegments(this.lexeme);
      if (warnOnCompile) {
        warnOnCompileWithoutCaching();
      }
    }
    assert (segs != null);
    return segs.toString(env, this.lexeme);
  }

  private static int COMPILE_TIMES = 0;

  private void warnOnCompileWithoutCaching() {
    if (COMPILE_TIMES++ % 1000 == 0) {
      final StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
      StringBuilder sb = new StringBuilder();
      boolean wasFirst = true;
      for (StackTraceElement st : stackTraces) {
        if (!wasFirst) {
          sb.append("\t").append(st.toString()).append("\n");
        }
        if (wasFirst) {
          wasFirst = false;
        }
      }
      System.err.println("[Aviator WARN] compile lexeme `" + this.lexeme
          + "` without caching, it may hurt performance and cause metaspace full gc, the stack:\n"
          + sb.toString());
    }
  }


}
