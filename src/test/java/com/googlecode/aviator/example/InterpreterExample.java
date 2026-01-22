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


package com.googlecode.aviator.example;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.EvalMode;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Options;

/**
 * Interpreter example
 *
 * @since 5.3
 * @author dennis(killme2008@gmail.com)
 *
 */
public class InterpreterExample {

  public static void main(final String[] args) {
    AviatorEvaluatorInstance engine = AviatorEvaluator.newInstance(EvalMode.INTERPRETER);
    // Enable tracing eval procedure(don't open it in production)
    engine.setOption(Options.TRACE_EVAL, true);

    Expression exp = engine.compile("score > 80 ? 'good' : 'bad'");
    System.out.println(exp.execute(exp.newEnv("score", 100)));
    System.out.println(exp.execute(exp.newEnv("score", 50)));
  }
}
