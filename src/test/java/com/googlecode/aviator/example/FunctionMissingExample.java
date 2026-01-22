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

import java.util.Arrays;
import java.util.Map;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.FunctionMissing;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;

public class FunctionMissingExample {

  private static class TestFunctionMissing implements FunctionMissing {

    @Override
    public AviatorObject onFunctionMissing(final String name, final Map<String, Object> env,
        final AviatorObject... args) {
      // Returns the function name.
      System.out.println(
          "Function not found, name=" + name + ", env=" + env + ", args=" + Arrays.toString(args));
      return FunctionUtils.wrapReturn(name);
    }

  }

  public static void main(final String[] args) {
    // Set function missing handler.
    AviatorEvaluator.setFunctionMissing(new TestFunctionMissing());

    System.out.println(AviatorEvaluator.execute("test(1,2,3)"));
    System.out.println(AviatorEvaluator.execute("not_found(1,2,3)"));
  }
}
