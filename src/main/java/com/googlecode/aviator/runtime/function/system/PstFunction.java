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

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;


/**
 * pst([out], e) function to print stacktrace of exception
 *
 * @author dennis
 *
 */
public class PstFunction extends AbstractFunction {


  private static final long serialVersionUID = -215228684025127631L;


  @Override
  public String getName() {
    return "pst";
  }


  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1) {
    Throwable t = (Throwable) arg1.getValue(env);
    t.printStackTrace();

    return AviatorNil.NIL;
  }


  @Override
  public AviatorObject call(final Map<String, Object> env, final AviatorObject arg1,
      final AviatorObject arg2) {

    OutputStream out = (OutputStream) FunctionUtils.getJavaObject(arg1, env);
    PrintStream printStream = new PrintStream(out);
    Throwable t = (Throwable) arg2.getValue(env);
    t.printStackTrace(printStream);

    return AviatorNil.NIL;
  }

}
