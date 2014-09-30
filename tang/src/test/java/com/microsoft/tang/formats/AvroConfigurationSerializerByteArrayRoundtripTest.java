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
package com.microsoft.tang.formats;

import com.microsoft.tang.ClassHierarchy;
import com.microsoft.tang.Configuration;
import com.microsoft.tang.test.RoundTripTest;

/**
 * A RoundTripTest that uses avro to serialize to byte[].
 */
public final class AvroConfigurationSerializerByteArrayRoundtripTest extends RoundTripTest {
  @Override
  public Configuration roundTrip(Configuration configuration) throws Exception {
    final AvroConfigurationSerializer serializer = new AvroConfigurationSerializer();
    final byte[] theBytes = serializer.toByteArray(configuration);
    return serializer.fromByteArray(theBytes);
  }

  @Override
  public Configuration roundTrip(Configuration configuration, final ClassHierarchy classHierarchy) throws Exception {
    final AvroConfigurationSerializer serializer = new AvroConfigurationSerializer();
    final byte[] theBytes = serializer.toByteArray(configuration);
    return serializer.fromByteArray(theBytes, classHierarchy);
  }
}
