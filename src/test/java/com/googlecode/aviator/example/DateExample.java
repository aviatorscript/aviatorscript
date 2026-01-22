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


package com.googlecode.aviator.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.googlecode.aviator.AviatorEvaluator;


public class DateExample {
  public static void main(final String[] args) throws Exception {
    Map<String, Object> env = new HashMap<String, Object>();
    final Date date = new Date();
    String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(date);
    env.put("date", date);
    env.put("dateStr", dateStr);

    Boolean result = (Boolean) AviatorEvaluator.execute("date==dateStr", env);
    System.out.println(result);

    result = (Boolean) AviatorEvaluator.execute("date > '2009-12-20 00:00:00:00' ", env);
    System.out.println(result);

    result = (Boolean) AviatorEvaluator.execute("date < '2200-12-20 00:00:00:00' ", env);
    System.out.println(result);

    result = (Boolean) AviatorEvaluator.execute("date == date ", env);
    System.out.println(result);
  }

}
