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
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.utils.TypeUtils;


/**
 * math.abs(d) function
 *
 * @author dennis
 *
 */
public class MathAbsFunction extends AbstractFunction {


  private static final long serialVersionUID = -862700689914934548L;


  @Override
  public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
    Number number = FunctionUtils.getNumberValue(arg1, env);
    if (TypeUtils.isDecimal(number)) {
      return new AviatorDecimal(((BigDecimal) number).abs(RuntimeUtils.getMathContext(env)));
    } else if (TypeUtils.isBigInt(number)) {
      return new AviatorBigInt(((BigInteger) number).abs());
    } else if (TypeUtils.isDouble(number)) {
      return new AviatorDouble(Math.abs(number.doubleValue()));
    } else {
      return AviatorLong.valueOf(Math.abs(number.longValue()));
    }
  }


  @Override
  public String getName() {
    return "math.abs";
  }

}
