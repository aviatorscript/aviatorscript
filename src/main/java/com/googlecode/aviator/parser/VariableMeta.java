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

package com.googlecode.aviator.parser;

import java.io.Serializable;
import com.googlecode.aviator.lexer.token.Token;
import com.googlecode.aviator.utils.Constants;

/**
 * Variable metadata, collected in compile-time.
 *
 * @author dennis(killme2008@gmail.com)
 *
 */
public class VariableMeta implements Serializable {
  private static final long serialVersionUID = 7798932900127029432L;
  private CompileTypes type;
  private String name;
  private boolean isInit;
  private int refs;
  private int firstIndex;

  public VariableMeta(final CompileTypes type, final String name, final boolean isInit,
      final int firstIndex) {
    super();
    this.type = type;
    this.name = name;
    this.isInit = isInit;
    this.refs = 1;
    this.firstIndex = firstIndex;
  }

  public int getFirstIndex() {
    return this.firstIndex;
  }

  public void setFirstIndex(final int firstIndex) {
    this.firstIndex = firstIndex;
  }



  public int incRefsAndGet() {
    return ++this.refs;
  }

  public void add(final Token<?> token) {
    incRefsAndGet();
    if (!this.isInit) {
      this.isInit = token.getMeta(Constants.INIT_META, false);
    }
    this.type = (CompileTypes) token.getMeta(Constants.TYPE_META);
  }

  public int getRefs() {
    return this.refs;
  }

  public void setRefs(final int times) {
    this.refs = times;
  }

  public CompileTypes getType() {
    return this.type;
  }

  public void setType(final CompileTypes type) {
    this.type = type;
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public boolean isInit() {
    return this.isInit;
  }

  public void setInit(final boolean isInit) {
    this.isInit = isInit;
  }

  @Override
  public String toString() {
    return "VariableMeta [type=" + this.type + ", name=" + this.name + ", isInit=" + this.isInit
        + ", refs=" + this.refs + ", firstIndex=" + this.firstIndex + "]";
  }


}
