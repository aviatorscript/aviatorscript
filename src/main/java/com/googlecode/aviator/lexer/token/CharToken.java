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

import java.util.Map;


/**
 * Charactor token
 *
 * @author dennis
 *
 */
public class CharToken extends AbstractToken<Character> {

  private static final long serialVersionUID = -4529035977875919777L;
  private final char ch;
  private int startIndex;


  public char getCh() {
    return this.ch;
  }


  public CharToken(final char peek, final int lineNo, final int startIndex) {
    super(String.valueOf(peek), lineNo, startIndex);
    this.ch = peek;
  }


  @Override
  public com.googlecode.aviator.lexer.token.Token.TokenType getType() {
    return TokenType.Char;
  }


  @Override
  public Character getValue(final Map<String, Object> env) {
    return this.ch;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + this.ch;
    result = prime * result + this.startIndex;
    return result;
  }


  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    CharToken other = (CharToken) obj;
    if (this.ch != other.ch) {
      return false;
    }
    if (this.startIndex != other.startIndex) {
      return false;
    }
    return true;
  }

}
