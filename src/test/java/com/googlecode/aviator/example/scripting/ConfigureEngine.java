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


package com.googlecode.aviator.example.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Feature;
import com.googlecode.aviator.Options;
import com.googlecode.aviator.script.AviatorScriptEngine;

public class ConfigureEngine {
  public static void main(final String[] args) throws Exception {
    final ScriptEngineManager sem = new ScriptEngineManager();
    ScriptEngine engine = sem.getEngineByName("AviatorScript");
    AviatorEvaluatorInstance instance = ((AviatorScriptEngine) engine).getEngine();
    // Use compatible feature set
    instance.setOption(Options.FEATURE_SET, Feature.getCompatibleFeatures());
    // Doesn't support if in compatible feature set mode.
    engine.eval("if(true) { println('support if'); }");
  }
}
