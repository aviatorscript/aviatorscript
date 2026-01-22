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

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class InvokeScriptMethod {
  public static void main(final String[] args) throws Exception {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("AviatorScript");

    // AviatorScript code in a String. This code defines a script object 'obj'
    // with one method called 'hello'.
    String script =
        "let obj = seq.map(); obj.hello = lambda(name) -> print('Hello, ' + name); end;";
    // evaluate script
    engine.eval(script);

    // javax.script.Invocable is an optional interface.
    // Check whether your script engine implements or not!
    // Note that the JavaScript engine implements Invocable interface.
    Invocable inv = (Invocable) engine;

    // get script object on which we want to call the method
    Object obj = engine.get("obj");

    // invoke the method named "hello" on the script object "obj"
    inv.invokeMethod(obj, "hello", "Script Method !!");
  }
}

