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


package com.googlecode.aviator.utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VarNameGeneratorTest {
  private VarNameGenerator gen;

  @Test
  public void testGen() {
    this.gen = new VarNameGenerator();
    assertEquals("A_0", this.gen.gen());
    assertEquals("A_1", this.gen.gen());
    assertEquals("A_2", this.gen.gen());
  }

  @Test
  public void testGenOverflow() {
    this.gen = new VarNameGenerator(Long.MAX_VALUE - 3);
    assertEquals("A_9223372036854775804", this.gen.gen());
    assertEquals("A_9223372036854775805", this.gen.gen());
    assertEquals("A_9223372036854775806", this.gen.gen());
    assertEquals("A_9223372036854775807", this.gen.gen());
    assertEquals("A_0", this.gen.gen());
    assertEquals("A_1", this.gen.gen());
    assertEquals("A_2", this.gen.gen());
  }
}
