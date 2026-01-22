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


package com.googlecode.aviator.runtime.function.seq;

import java.util.Map;
import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.exception.NoSuchPropertyException;
import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.utils.Reflector;


/**
 * A predicate function
 *
 * @author dennis
 */
public class SeqPredicateFunction extends AbstractFunction {

  private static final long serialVersionUID = 478017115680743291L;
  private final String name;
  private final OperatorType opType;
  private final AviatorObject value;
  private final AviatorObject propertyName;

  public SeqPredicateFunction(final String name, final OperatorType opType,
      final AviatorObject value) {
    this(name, opType, value, null);
  }

  public SeqPredicateFunction(final String name, final OperatorType opType,
      final AviatorObject value, final AviatorObject propertyName) {
    this.name = name;
    this.opType = opType;
    this.value = value;
    this.propertyName = propertyName;
  }

  @Override
  public AviatorObject call(final Map<String, Object> env, AviatorObject arg1) {
    if (this.propertyName != null) {
      String propertyNameStr = this.propertyName.stringValue(env);
      Object target = arg1.getValue(env);
      try {
        Object property = Reflector.getProperty(target, propertyNameStr);
        arg1 = AviatorRuntimeJavaType.valueOf(property);
      } catch (NoSuchPropertyException e) {
        throw new IllegalArgumentException(
            "Fail to get property <" + propertyNameStr + "> from <" + arg1.desc(env) + ">", e);
      }
    }
    switch (this.opType) {
      case EQ:
        return arg1.compare(this.value, env) == 0 ? AviatorBoolean.TRUE : AviatorBoolean.FALSE;
      case NEQ:
        return arg1.compare(this.value, env) != 0 ? AviatorBoolean.TRUE : AviatorBoolean.FALSE;
      case LT:
        return arg1.compare(this.value, env) < 0 ? AviatorBoolean.TRUE : AviatorBoolean.FALSE;
      case LE:
        return arg1.compare(this.value, env) <= 0 ? AviatorBoolean.TRUE : AviatorBoolean.FALSE;
      case GE:
        return arg1.compare(this.value, env) >= 0 ? AviatorBoolean.TRUE : AviatorBoolean.FALSE;
      case GT:
        return arg1.compare(this.value, env) > 0 ? AviatorBoolean.TRUE : AviatorBoolean.FALSE;
      default:
        throw new ExpressionRuntimeException(getName() + " is not a relation operator");
    }
  }


  @Override
  public String getName() {
    return this.name;
  }

}
