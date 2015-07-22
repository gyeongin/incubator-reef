/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.reef.tang.test;

import org.apache.reef.tang.annotations.Name;
import org.apache.reef.tang.annotations.NamedParameter;
import org.apache.reef.tang.formats.ConfigurationModule;
import org.apache.reef.tang.formats.ConfigurationModuleBuilder;
import org.apache.reef.tang.formats.OptionalParameter;
import org.apache.reef.tang.formats.RequiredParameter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * All the configuration parameters and options for the test.
 */
public class TestConfiguration extends ConfigurationModuleBuilder {
  public static final String REQUIRED_STRING_VALUE = "Required String Value";
  public static final String OPTIONAL_STRING_VALUE = "Optional String Value";
  public static final RequiredParameter<String> REQUIRED_STRING = new RequiredParameter<>();
  public static final OptionalParameter<String> OPTIONAL_STRING = new OptionalParameter<>();
  public static final int NAMED_PARAMETER_INTEGER_VALUE = 42;
  public static final double NAMED_PARAMETER_DOUBLE_VALUE = 42.0;
  // Pre-defined lists used in injection
  private static final List<Class<? extends ListInterface>> INJECTED_IMPL_LIST =
      Arrays.asList(ListInterfaceImplOne.class, ListInterfaceImplTwo.class);
  private static final List<String> INJECTED_INTEGER_LIST = Arrays.asList("1", "2", "3");
  private static final List<String> INJECTED_DOUBLE_LIST = Arrays.asList("1", "2", "3");
  private static final List<String> INJECTED_STRING_LIST = Arrays.asList("1", "2", "3");

  public static final ConfigurationModule CONF = new TestConfiguration()
      .bindImplementation(RootInterface.class, RootImplementation.class)
      .bindNamedParameter(IntegerHandler.class, UnitClass.IntegerHandler.class)
      .bindNamedParameter(StringHandler.class, UnitClass.StringHandler.class)
      .bindNamedParameter(NamedParameterInteger.class, String.valueOf(NAMED_PARAMETER_INTEGER_VALUE))
      .bindNamedParameter(NamedParameterDouble.class, String.valueOf(NAMED_PARAMETER_DOUBLE_VALUE))
      .bindSetEntry(SetOfInstances.class, SetInterfaceImplOne.class)
      .bindSetEntry(SetOfInstances.class, SetInterfaceImplTwo.class)
          // Adds list implementations
      .bindList(ListOfInstances.class, INJECTED_IMPL_LIST)
      .bindNamedParameter(RequiredString.class, REQUIRED_STRING)
      .bindNamedParameter(OptionalString.class, OPTIONAL_STRING)
          // Sets of base types
      .bindSetEntry(SetOfBaseTypes.Integers.class, "1")
      .bindSetEntry(SetOfBaseTypes.Integers.class, "2")
      .bindSetEntry(SetOfBaseTypes.Integers.class, "3")
      .bindSetEntry(SetOfBaseTypes.Doubles.class, "1")
      .bindSetEntry(SetOfBaseTypes.Doubles.class, "2")
      .bindSetEntry(SetOfBaseTypes.Doubles.class, "3")
      .bindSetEntry(SetOfBaseTypes.Strings.class, "1")
      .bindSetEntry(SetOfBaseTypes.Strings.class, "2")
      .bindSetEntry(SetOfBaseTypes.Strings.class, "3")
          // Lists of base types
      .bindList(ListOfBaseTypes.Integers.class, INJECTED_INTEGER_LIST)
      .bindList(ListOfBaseTypes.Doubles.class, INJECTED_DOUBLE_LIST)
      .bindList(ListOfBaseTypes.Strings.class, INJECTED_STRING_LIST)
      .build();

  @NamedParameter()
  public static final class RequiredString implements Name<String> {
  }

  @NamedParameter(default_value = "default_string_default_value")
  public static final class OptionalString implements Name<String> {
  }

  @NamedParameter()
  public static final class IntegerHandler implements Name<Handler<Integer>> {
  }

  @NamedParameter()
  public static final class StringHandler implements Name<Handler<String>> {
  }

  @NamedParameter()
  public static final class NamedParameterInteger implements Name<Integer> {
  }

  @NamedParameter()
  public static final class NamedParameterDouble implements Name<Double> {
  }

  @NamedParameter
  public static final class SetOfInstances implements Name<Set<SetInterface>> {
  }

  @NamedParameter
  public static final class ListOfInstances implements Name<List<ListInterface>> {
  }


}
