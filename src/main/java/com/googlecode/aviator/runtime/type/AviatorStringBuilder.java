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

package com.googlecode.aviator.runtime.type;

import java.util.Map;

/**
 * Aviator string builder for fast concatenating string.
 *
 * @author boyan(boyan@antfin.com)
 *
 */
public class AviatorStringBuilder extends AviatorString {

  private static final long serialVersionUID = 1958289382573221857L;
  private final StringBuilder sb;

  public AviatorStringBuilder(final StringBuilder sb) {
    super(null);
    this.sb = sb;
  }

  public AviatorStringBuilder(final String lexeme) {
    super(null);
    this.sb = new StringBuilder(lexeme);
  }

  @Override
  public String getLexeme(final Map<String, Object> env, final boolean warnOnCompile) {
    return this.sb.toString();
  }


  @Override
  public AviatorObject deref(final Map<String, Object> env) {
    return new AviatorString(getLexeme(env));
  }

  @Override
  public AviatorObject add(final AviatorObject other, final Map<String, Object> env) {
    if (other.getAviatorType() == AviatorType.Pattern) {
      final AviatorPattern otherPatterh = (AviatorPattern) other;
      this.sb.append(otherPatterh.pattern.pattern());
    } else {
      this.sb.append(other.getValue(env));
    }
    return new AviatorStringBuilder(this.sb);
  }
}
