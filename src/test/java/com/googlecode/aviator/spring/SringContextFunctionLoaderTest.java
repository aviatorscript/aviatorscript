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


package com.googlecode.aviator.spring;

import static com.googlecode.aviator.TestUtils.assertEquals;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.googlecode.aviator.AviatorEvaluator;

public class SringContextFunctionLoaderTest {

  private SringContextFunctionLoader loader;

  @Before
  public void setUp() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
    loader = new SringContextFunctionLoader(ctx);
    AviatorEvaluator.addFunctionLoader(loader);
  }

  @Test
  public void testAdd() {
    assertEquals(100.0, AviatorEvaluator.exec("springAdd(x,y)", 1, 99));
  }

  @AfterClass
  public static void tearDown() {
    AviatorEvaluator.addFunctionLoader(null);
  }

}
