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


package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import java.util.Map;


/**
 * Function to make predicate for filter function
 * 
 * @author dennis
 * 
 */
public class SeqMakePredicateFunFunction extends AbstractFunction {

  private static final long serialVersionUID = 5914895306808850530L;
  private final String name;
  private final OperatorType opType;
  private final AviatorObject value;


  public SeqMakePredicateFunFunction(String name, OperatorType opType) {
    this(name, opType, null);
  }


  public SeqMakePredicateFunFunction(String name, OperatorType opType, AviatorObject value) {
    super();
    this.name = name;
    this.opType = opType;
    this.value = value;
  }


  @Override
  public AviatorObject call(Map<String, Object> env) {
    return AviatorRuntimeJavaType
        .valueOf(new SeqPredicateFunction(this.name, this.opType, this.value));
  }


  @Override
  public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
    return AviatorRuntimeJavaType.valueOf(new SeqPredicateFunction(this.name, this.opType, arg1));
  }

  @Override
  public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
    return AviatorRuntimeJavaType
        .valueOf(new SeqPredicateFunction(this.name, this.opType, arg1, arg2));
  }

  @Override
  public String getName() {
    return this.name;
  }

}
