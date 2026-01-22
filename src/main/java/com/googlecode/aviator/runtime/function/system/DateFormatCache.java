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

package com.googlecode.aviator.runtime.function.system;

import java.text.SimpleDateFormat;
import com.googlecode.aviator.utils.LRUMap;


/**
 * DateFormat cache
 * 
 * @author dennis(killme2008@gmail.com)
 * 
 */
public class DateFormatCache {

  private static int maxSize =
      Integer.valueOf(System.getProperty("aviator.date_format.cache.max", "256"));

  private static ThreadLocal<LRUMap<String/* format */, SimpleDateFormat>> formatCache =
      new ThreadLocal<LRUMap<String, SimpleDateFormat>>();


  public static SimpleDateFormat getOrCreateDateFormat(String format) {
    LRUMap<String/* format */, SimpleDateFormat> cache = formatCache.get();
    if (cache == null) {
      cache = new LRUMap<String, SimpleDateFormat>(maxSize);
      formatCache.set(cache);
    }
    SimpleDateFormat rt = cache.get(format);
    if (rt == null) {
      rt = new SimpleDateFormat(format);
      cache.put(format, rt);
    }
    return rt;
  }

}
