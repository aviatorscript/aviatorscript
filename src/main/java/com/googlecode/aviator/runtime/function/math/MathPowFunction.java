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


package com.googlecode.aviator.runtime.function.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBigInt;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.utils.TypeUtils;


/**
 * math.pow(d1,d2) function
 *
 * @author dennis
 *
 */
public class MathPowFunction extends AbstractFunction {


  private static final long serialVersionUID = 5909888819672336251L;

  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1,
      final AviatorObject arg2) {
    Number left = FunctionUtils.getNumberValue(arg1, env);
    Number right = FunctionUtils.getNumberValue(arg2, env);
    if (TypeUtils.isBigInt(left)) {
      return new AviatorBigInt(((BigInteger) left).pow(right.intValue()));
    } else if (TypeUtils.isDecimal(left)) {
      return new AviatorDecimal(
          ((BigDecimal) left).pow(right.intValue(), RuntimeUtils.getMathContext(env)));
    } else {
      return new AviatorDouble(Math.pow(left.doubleValue(), right.doubleValue()));
    }

  }

  @Override
  public String getName() {
    return "math.pow";
  }
}
