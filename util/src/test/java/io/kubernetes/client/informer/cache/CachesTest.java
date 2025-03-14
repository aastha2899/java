/*
Copyright 2020 The Kubernetes Authors.
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
package io.kubernetes.client.informer.cache;

import static org.assertj.core.api.Assertions.assertThat;

import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1Pod;
import java.util.List;
import org.junit.Test;

public class CachesTest {

  @Test
  public void testDefaultNamespaceNameKey() {
    String testName = "test-name";
    String testNamespace = "test-namespace";
    V1Pod pod = new V1Pod().metadata(new V1ObjectMeta().name(testName).namespace(testNamespace));
    assertThat(Caches.metaNamespaceKeyFunc(pod)).isEqualTo(testNamespace + "/" + testName);
  }

  @Test
  public void testDefaultNamespaceIndex() {
    String testName = "test-name";
    String testNamespace = "test-namespace";
    V1Pod pod = new V1Pod().metadata(new V1ObjectMeta().name(testName).namespace(testNamespace));
    List<String> indices = Caches.metaNamespaceIndexFunc(pod);
    assertThat(indices).containsExactly(pod.getMetadata().getNamespace());
  }
}
