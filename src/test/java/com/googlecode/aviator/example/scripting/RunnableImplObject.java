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

public class RunnableImplObject {
  public static void main(final String[] args) throws Exception {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("AviatorScript");

    // AviatorScript code in a String
    String script =
        "let obj = seq.map(); obj.run = lambda() -> println('run method called'); end; ";

    // evaluate script
    engine.eval(script);

    // get script object on which we want to implement the interface with
    Object obj = engine.get("obj");

    Invocable inv = (Invocable) engine;

    // get Runnable interface object from engine. This interface methods
    // are implemented by script methods of object 'obj'
    Runnable r = inv.getInterface(obj, Runnable.class);

    // start a new thread that runs the script implemented
    // runnable interface
    Thread th = new Thread(r);
    th.start();
  }
}
