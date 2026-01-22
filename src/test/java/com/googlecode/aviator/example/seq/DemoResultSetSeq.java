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


package com.googlecode.aviator.example.seq;

import java.sql.ResultSet;
import org.mockito.Mockito;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

public class DemoResultSetSeq {

  public static void main(final String[] args) throws Exception {
    // Mock a result set.
    ResultSet resultSet = Mockito.mock(ResultSet.class);
    Mockito.when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    Mockito.when(resultSet.getString("username")).thenReturn("dennis").thenReturn("catty");
    Mockito.when(resultSet.getInt("age")).thenReturn(30).thenReturn(20);

    // Use it in aviator
    Expression exp = AviatorEvaluator.getInstance().compileScript("examples/result_set_seq.av");
    exp.execute(exp.newEnv("results", new ResultSetSequence(resultSet)));

  }
}
