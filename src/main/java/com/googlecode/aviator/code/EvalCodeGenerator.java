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

package com.googlecode.aviator.code;

import java.util.Map;
import java.util.Set;
import com.googlecode.aviator.lexer.token.Token;
import com.googlecode.aviator.parser.AviatorClassLoader;
import com.googlecode.aviator.parser.VariableMeta;
import com.googlecode.aviator.runtime.LambdaFunctionBootstrap;

public interface EvalCodeGenerator extends CodeGenerator {
  void start();

  void initVariables(final Map<String, VariableMeta/* counter */> vars);

  void initConstants(final Set<Token<?>> constants);

  void initMethods(final Map<String, Integer/* counter */> methods);

  void setLambdaBootstraps(final Map<String, LambdaFunctionBootstrap> lambdaBootstraps);

  AviatorClassLoader getClassLoader();

  void genNewLambdaCode(final LambdaFunctionBootstrap bootstrap);
}
