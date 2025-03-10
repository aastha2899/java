/*
Copyright 2024 The Kubernetes Authors.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package io.kubernetes.client.openapi;

import io.kubernetes.client.openapi.models.V1Secret;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

public class V1SecretTest {
    @Test
    public void testV1SecretEquality() {
        V1Secret left = new V1Secret()
                .data(new HashMap<String, byte[]>() {{
                    put("foo", "bar".getBytes());
                }});
        V1Secret right = new V1Secret()
                .data(new HashMap<String, byte[]>() {{
                    put("foo", "bar".getBytes());
                }});
        assertThat(right).isEqualTo(left);
    }
}
