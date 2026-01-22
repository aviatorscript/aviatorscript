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
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.JavaMethodReflectionFunctionMissing;

/**
 * Run a script under examples folder.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class RunScriptExample {

  public static void main(final String[] args) throws Exception {
    // Enable java method invocation by reflection.
    AviatorEvaluator.getInstance()
        .setFunctionMissing(JavaMethodReflectionFunctionMissing.getInstance());
    // You can trry to test every script in examples folder by changing the file name.
    Expression exp = AviatorEvaluator.getInstance().compileScript("examples/hello.av");

    exp.execute();

  }

}
