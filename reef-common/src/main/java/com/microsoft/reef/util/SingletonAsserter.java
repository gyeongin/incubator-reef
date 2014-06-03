/**
 * Copyright (C) 2014 Microsoft Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsoft.reef.util;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * A helper class that can be used to ensure that objects are only instantiated once.
 */
public final class SingletonAsserter {

  private static final Set<Class> classes = new HashSet<>();
  private static final Logger LOG = Logger.getLogger(SingletonAsserter.class.getName());

  /**
   * This class operates purely in static mode.
   */
  private SingletonAsserter() {
  }

  public static synchronized boolean assertSingleton(final Class clazz) {
    if (classes.contains(clazz)) {
      return false;
    } else {
      classes.add(clazz);
      return true;
    }

  }
}
