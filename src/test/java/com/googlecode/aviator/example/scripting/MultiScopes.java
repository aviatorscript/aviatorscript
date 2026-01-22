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


package com.googlecode.aviator.example.scripting;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;

public class MultiScopes {
  public static void main(final String[] args) throws Exception {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("AviatorScript");

    engine.put("x", "hello");
    // print global variable "x"
    engine.eval("println(x);");
    // the above line prints "hello"

    // Now, pass a different script context
    ScriptContext newContext = new SimpleScriptContext();
    Bindings engineScope = newContext.getBindings(ScriptContext.ENGINE_SCOPE);

    // add new variable "x" to the new engineScope
    engineScope.put("x", "world");

    // execute the same script - but this time pass a different script context
    engine.eval("println(x);", newContext);
    // the above line prints "world"
  }
}
