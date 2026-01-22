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


package com.googlecode.aviator.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.googlecode.aviator.AviatorEvaluator;


public class CollectionExample {
  public static void main(String[] args) {
    final List<String> list = new ArrayList<String>();
    list.add("hello");
    list.add(" world");

    final int[] array = new int[3];
    array[0] = 0;
    array[1] = 1;
    array[2] = 3;

    final Map<String, Date> map = new HashMap<String, Date>();
    map.put("date", new Date());

    Map<String, Object> env = new HashMap<String, Object>();
    env.put("list", list);
    env.put("array", array);
    env.put("mmap", map);

    System.out.println(AviatorEvaluator.execute(
        "list[0]+list[1]+'\narray[0]+array[1]+array[2]='+(array[0]+array[1]+array[2]) +' \ntoday is '+mmap.date ",
        env));
  }
}
