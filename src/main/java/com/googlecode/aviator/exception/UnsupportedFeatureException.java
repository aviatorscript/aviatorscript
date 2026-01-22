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

import com.googlecode.aviator.Feature;

public class UnsupportedFeatureException extends ExpressionSyntaxErrorException {
  private static final long serialVersionUID = 6543462982851212129L;

  public UnsupportedFeatureException(final Feature feature) {
    super("Feature." + feature + " is not enabled");
  }

  public UnsupportedFeatureException() {
    super();
  }

  public UnsupportedFeatureException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public UnsupportedFeatureException(final String message) {
    super(message);
  }

  public UnsupportedFeatureException(final Throwable cause) {
    super(cause);
  }

}
