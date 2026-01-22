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

package com.googlecode.aviator.exception;

public class LoadScriptFailureException extends ExpressionRuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = -4311966452570613367L;

  public LoadScriptFailureException() {
    super();
  }

  public LoadScriptFailureException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public LoadScriptFailureException(final String message) {
    super(message);
  }

  public LoadScriptFailureException(final Throwable cause) {
    super(cause);
  }

}
