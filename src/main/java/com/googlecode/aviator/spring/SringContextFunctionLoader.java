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

import org.springframework.context.ApplicationContext;
import com.googlecode.aviator.FunctionLoader;

/**
 * Function loader based on spring context, try to find the function by name from spring context.
 *
 * @since 4.0.0
 * @author dennis
 * @deprecated Use {@link SpringContextFunctionLoader} instead.
 *
 */
@Deprecated
public class SringContextFunctionLoader extends SpringContextFunctionLoader
    implements FunctionLoader {
  public SringContextFunctionLoader() {
    super();
  }

  public SringContextFunctionLoader(ApplicationContext applicationContext) {
    super(applicationContext);
  }
}
