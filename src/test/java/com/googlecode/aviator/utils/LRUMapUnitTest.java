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


package com.googlecode.aviator.utils;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.googlecode.aviator.TestUtils.assertEquals;


public class LRUMapUnitTest {

  private LRUMap<Integer, Integer> map;


  @Before
  public void setUp() {
    this.map = new LRUMap<Integer, Integer>(10);
  }


  @Test
  public void testPutGet() {
    assertTrue(map.isEmpty());
    assertEquals(0, map.size());
    for (int i = 0; i < 5; i++) {
      assertNull(this.map.get(i));
      this.map.put(i, i);
      assertEquals(i, this.map.get(i));
    }
    assertEquals(5, map.size());
  }


  @Test
  public void testLRU() {
    for (int i = 0; i < 20; i++) {
      assertNull(this.map.get(i));
      this.map.put(i, i);
      assertEquals(i, this.map.get(i));
    }
    assertEquals(10, map.size());
    for (int i = 0; i < 10; i++)
      assertNull(this.map.get(0));
    for (int i = 10; i < 11; i++)
      assertEquals(i, this.map.get(i));
    assertEquals(10, map.size());

  }

}
