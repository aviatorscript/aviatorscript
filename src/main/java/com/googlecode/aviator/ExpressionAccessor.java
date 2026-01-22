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


package com.googlecode.aviator;

import java.util.List;
import java.util.Map;
import com.googlecode.aviator.runtime.FunctionArgument;
import com.googlecode.aviator.runtime.LambdaFunctionBootstrap;
import com.googlecode.aviator.utils.Env;

/**
 * Base expression default methods accessor
 * 
 * @author dennis
 *
 */
public class ExpressionAccessor {

  public static void setSourceFile(final BaseExpression exp, String sourceFile) {
    exp.setSourceFile(sourceFile);
  }

  public static void setInstance(final BaseExpression exp, AviatorEvaluatorInstance instance) {
    exp.setInstance(instance);
  }

  public static void setCompileEnv(final BaseExpression exp, final Env compileEnv) {
    exp.setCompileEnv(compileEnv);
  }

  public static void setExpression(final BaseExpression exp, final String expression) {
    exp.setExpression(expression);
  }

  public static void setFuncsArgs(final BaseExpression exp,
      final Map<Integer, List<FunctionArgument>> funcsArgs) {
    exp.setFuncsArgs(funcsArgs);
  }

  public static void setLambdaBootstraps(final BaseExpression exp,
      final Map<String, LambdaFunctionBootstrap> lambdaBootstraps) {
    exp.setLambdaBootstraps(lambdaBootstraps);
  }

  public static void setFunctionNames(final BaseExpression exp, List<String> functionNames) {
    exp.setFunctionNames(functionNames);
  }
}
