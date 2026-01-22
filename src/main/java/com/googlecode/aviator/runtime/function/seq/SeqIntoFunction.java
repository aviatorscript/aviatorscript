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

package com.googlecode.aviator.runtime.function.seq;

import java.util.Map;
import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;

/**
 * into(to_coll, from_coll) Adds all elements in from_coll into to_coll by seq.add(to_coll, element)
 * and return the to_coll.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class SeqIntoFunction extends AbstractFunction {

  private static final long serialVersionUID = 1426576856324636917L;
  private static final AviatorFunction SEQ_ADD = new SeqAddFunction();

  @Override
  public String getName() {
    return "into";
  }

  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1,
      final AviatorObject arg2) {
    Object fromSeq = arg2.getValue(env);
    AviatorObject result = arg1;

    for (Object e : RuntimeUtils.seq(fromSeq, env)) {
      result = SEQ_ADD.call(env, result, AviatorRuntimeJavaType.valueOf(e));
    }

    return result;
  }

}
