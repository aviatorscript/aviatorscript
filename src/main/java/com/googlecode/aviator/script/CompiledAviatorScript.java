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

package com.googlecode.aviator.script;

import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import com.googlecode.aviator.Expression;


/**
 * A compiled aviator script.
 *
 * @author libinsong1204@gmail.com
 * @author dennis(killme2008@gmail.com)
 * @date 2011-1-18 上午11:03:34
 * @version
 */
public class CompiledAviatorScript extends CompiledScript {

  private final AviatorScriptEngine engine;
  private final Expression expression;


  CompiledAviatorScript(final AviatorScriptEngine engine, final Expression expression) {
    this.engine = engine;
    this.expression = expression;
  }


  @Override
  public Object eval(final ScriptContext context) throws ScriptException {
    try {
      return this.expression.execute(context.getBindings(ScriptContext.ENGINE_SCOPE));
    } catch (Exception e) {
      throw new ScriptException(e);
    }
  }


  @Override
  public ScriptEngine getEngine() {
    return this.engine;
  }

}
