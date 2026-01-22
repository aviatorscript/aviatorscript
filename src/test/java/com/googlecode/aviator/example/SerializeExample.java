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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Options;

/**
 * Demo for expression serialization
 * 
 * @author dennis
 *
 */
public class SerializeExample {

  public static void main(String[] args) throws Exception {
    // Enable expression serialization feature
    AviatorEvaluatorInstance engine = AviatorEvaluator.getInstance();
    engine.setOption(Options.SERIALIZABLE, true);

    Expression exp = engine.compile("if (a>b) { return a; } else { return b; }");

    // Execute the raw expression
    Object result = exp.execute(exp.newEnv("a", 42, "b", 99));
    System.out.println("Raw expression result:" + result);

    // Serialize the expression
    byte[] bs = null; // the serialized bytes
    try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
      // Create the ObjectOutputStream
      ObjectOutputStream output = engine.newObjectOutputStream(out);
      // Write the expression object
      output.writeObject(exp);
      output.close();
      // Get the result byte array
      bs = out.toByteArray();
    }

    System.out.println("Serialize expression bytes array length: " + bs.length);

    // Deserialize expression from bytes
    try (ByteArrayInputStream in = new ByteArrayInputStream(bs)) {
      // Create the ObjectInputStream from ByteArrayInputStream(bs)
      ObjectInputStream input = engine.newObjectInputStream(in);
      // Read the expression from ObjectInputStream
      Expression newExp = (Expression) input.readObject();
      // Execute the expression
      result = newExp.execute(newExp.newEnv("a", 42, "b", 99));
      System.out.println("Deserialized expression result:" + result);
    }
  }

}
