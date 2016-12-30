package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT/*,
    value = {
        "spring.application.name=feignclienttest",
        "feign.hystrix.enabled=false",
        "feign.okhttp.enabled=false" }*/)
public class DemoApplicationTests {
  @Test
  public void test() {
    AnnotationUtils.findAnnotation(DemoApplication.TestFeignClient.class, FeignClient.class);
  }

  @Autowired
  DemoApplication.TestFeignClient client;

  @Test
  public void name() throws Exception {

    assertNotNull(client);
    assertEquals("hello", client.my_hello());

  }
}

