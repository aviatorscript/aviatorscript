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


package com.googlecode.aviator.lexer.token;

import java.util.Map;


/**
 * A Number token
 *
 * @author dennis
 *
 */
public class NumberToken extends AbstractToken<Number> {


  private static final long serialVersionUID = 3787410200228564680L;
  private Number value;


  public NumberToken(final Number value, final String lexeme) {
    super(lexeme, 0, -1);
    this.value = value;
  }


  public NumberToken(final Number value, final String lexeme, final int lineNo,
      final int startIndex) {
    super(lexeme, lineNo, startIndex);
    this.value = value;
  }


  public void setNumber(final Number number) {
    this.value = number;
  }


  public Number getNumber() {
    return this.value;
  }


  @Override
  public Number getValue(final Map<String, Object> env) {
    return this.value;
  }


  @Override
  public TokenType getType() {
    return TokenType.Number;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.value == null) ? 0 : this.value.hashCode());
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
    NumberToken other = (NumberToken) obj;
    if (this.value == null) {
      if (other.value != null) {
        return false;
      }
    } else if (!this.value.equals(other.value)) {
      return false;
    }
    return true;
  }

}
