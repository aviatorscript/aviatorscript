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


package com.googlecode.aviator.scripts;

import org.junit.Before;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.EvalMode;
import com.googlecode.aviator.Options;
import com.googlecode.aviator.TestUtils;
import com.googlecode.aviator.runtime.JavaMethodReflectionFunctionMissing;

public class TestScriptsWithSerialize extends TestScripts {

  @Override
  @Before
  public void setup() throws Exception {
    this.instance = AviatorEvaluator.newInstance(EvalMode.ASM);
    this.instance.setOption(Options.SERIALIZABLE, true);
    this.instance.addStaticFunctions("j", TestUtils.class);
    this.instance.setFunctionMissing(JavaMethodReflectionFunctionMissing.getInstance());
    this.testSerialize = true;
  }

}
