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

package com.googlecode.aviator.runtime.function.system;

import java.math.BigInteger;
import java.util.Map;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorBigInt;
import com.googlecode.aviator.runtime.type.AviatorNumber;
import com.googlecode.aviator.runtime.type.AviatorObject;


/**
 * Cast value to bigint
 *
 * @author dennis
 * @Date 2011-5-18
 * @since 1.1.1
 *
 */
public class BigIntFunction extends AbstractFunction {


  private static final long serialVersionUID = 820173052464302490L;


  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1) {
    switch (arg1.getAviatorType()) {
      case Boolean:
        return AviatorBigInt.valueOf(arg1.booleanValue(env) ? BigInteger.ONE : BigInteger.ZERO);
      case JavaType:
        Object obj = arg1.getValue(env);
        if (obj instanceof Number) {
          return AviatorBigInt.valueOf(new BigInteger(String.valueOf(obj)));
        } else if (obj instanceof String) {
          return AviatorBigInt.valueOf(new BigInteger((String) obj));
        } else if (obj instanceof Character) {
          return AviatorBigInt.valueOf(new BigInteger(String.valueOf(obj)));
        } else {
          throw new ClassCastException(
              "Could not cast " + (obj != null ? obj.getClass().getName() : "null")
                  + " to bigint, AviatorObject is " + arg1);
        }
      case String:
        return AviatorBigInt.valueOf(new BigInteger((String) arg1.getValue(env)));
      case BigInt:
      case Decimal:
      case Long:
      case Double:
        return AviatorBigInt.valueOf(((AviatorNumber) arg1).toBigInt());
      default:
        throw new ClassCastException("Could not cast " + arg1 + " to bigint");
    }
  }


  @Override
  public String getName() {
    return "bigint";
  }

}
