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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.Sequence;

/**
 * seq.collector(seq) to create a collector for this sequence.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class SeqZipmapFunction extends AbstractFunction {

  private static final long serialVersionUID = -3174913891253579826L;

  private SeqZipmapFunction() {}

  public static final SeqZipmapFunction INSTANCE = new SeqZipmapFunction();

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1,
      final AviatorObject arg2) {
    final Sequence<?> seq1 = RuntimeUtils.seq(arg1.getValue(env), env);
    final Sequence<?> seq2 = RuntimeUtils.seq(arg2.getValue(env), env);

    Iterator<?> it1 = seq1.iterator();
    Iterator<?> it2 = seq2.iterator();

    Map result = new HashMap();

    while (it1.hasNext() && it2.hasNext()) {
      result.put(it1.next(), it2.next());
    }


    return AviatorRuntimeJavaType.valueOf(result);
  }

  @Override
  public String getName() {
    return "zipmap";
  }

}
