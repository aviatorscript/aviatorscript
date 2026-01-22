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


package com.googlecode.aviator.exception;

/**
 * Compile expression exception
 * 
 * @author dennis
 * 
 */
public class CompileExpressionErrorException extends ExpressionRuntimeException {

  static final long serialVersionUID = -1;


  public CompileExpressionErrorException() {
    super();

  }


  public CompileExpressionErrorException(String message, Throwable cause) {
    super(message, cause);

  }


  public CompileExpressionErrorException(String message) {
    super(message);

  }


  public CompileExpressionErrorException(Throwable cause) {
    super(cause);

  }

}
