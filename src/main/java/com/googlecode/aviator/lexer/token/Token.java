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


package com.googlecode.aviator.lexer.token;

import java.io.Serializable;
import java.util.Map;


/**
 * Lex token interface
 *
 * @author dennis
 *
 * @param <T>
 */
public interface Token<T> extends Serializable {
  enum TokenType {
    String, Variable, Number, Char, Operator, Pattern, Delegate
  }

  Token<T> withMeta(String name, Object v);

  Map<String, Object> getMetaMap();

  <V> V getMeta(final String name, final V defaultVal);

  <V> V getMeta(final String name);

  T getValue(Map<String, Object> env);

  TokenType getType();


  String getLexeme();


  int getStartIndex();

  int getEndIndex();

  int getLineNo();
}
