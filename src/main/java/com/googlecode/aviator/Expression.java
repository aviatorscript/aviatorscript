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


package com.googlecode.aviator;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * A expression
 *
 * @author dennis
 *
 */
public interface Expression extends Serializable {

  /**
   * Execute an expression with an environment, returns the result.
   *
   * @param env Binding variable environment
   * @return the result of execution
   */
  Object execute(Map<String, Object> env);


  /**
   * Execute an expression with an empty environment, returns the result.
   *
   * @return the result of execution
   */
  Object execute();

  /**
   * Returns the source file name.
   *
   * @since 5.2.3
   * @return the source file name
   */
  public String getSourceFile();


  /**
   * Returns this expression's all uninitialized global variable names in order when using
   * AviatorEvaluator.EVAL mode, otherwise returns an empty list.
   *
   * @see com.googlecode.aviator.AviatorEvaluator#EVAL
   * @return
   */
  List<String> getVariableNames();


  /**
   * Returns this expression's all uninitialized global variable full names(contains dot) in order
   * when using AviatorEvaluator.EVAL mode, otherwise returns an empty list.
   *
   * @return
   */
  List<String> getVariableFullNames();

  /**
   * Created a faster env map(compare variable names by reference).The arguments should be a
   * sequence of pair <String, Object>.
   *
   * @param args
   * @return an env map
   */
  Map<String, Object> newEnv(final Object... args);

  /**
   * Adds the specified symbol to the symbol table and returns a reference to the unique symbol. If
   * the symbol already exists, the previous symbol reference is returned instead, in order
   * guarantee that symbol references remain unique.
   *
   * @param name The symbol name.
   */
  String addSymbol(String name);

  /**
   * Returns the function names in the expression when using AviatorEvaluator.EVAL mode, otherwise
   * returns an empty list.
   * 
   * @since 5.4.2
   * @return the function name list
   */
  List<String> getFunctionNames();
}
