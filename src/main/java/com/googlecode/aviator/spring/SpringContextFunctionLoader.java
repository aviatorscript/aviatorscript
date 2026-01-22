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

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import com.googlecode.aviator.FunctionLoader;
import com.googlecode.aviator.runtime.type.AviatorFunction;

/**
 * Function loader based on spring context, try to find the function by name from spring context.
 *
 * @since 4.0.0
 * @author dennis
 *
 */
public class SpringContextFunctionLoader implements FunctionLoader, ApplicationContextAware {

  private ApplicationContext applicationContext;


  public SpringContextFunctionLoader() {
    super();
  }


  public SpringContextFunctionLoader(final ApplicationContext applicationContext) {
    super();
    this.applicationContext = applicationContext;
  }


  public ApplicationContext getApplicationContext() {
    return this.applicationContext;
  }


  @Override
  public void setApplicationContext(final ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }


  @Override
  public AviatorFunction onFunctionNotFound(final String name) {
    try {
      return (AviatorFunction) this.applicationContext.getBean(name);
    } catch (NoSuchBeanDefinitionException e) {
      return null;
    }
  }

}
