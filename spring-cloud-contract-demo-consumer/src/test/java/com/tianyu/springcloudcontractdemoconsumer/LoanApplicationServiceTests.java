package com.tianyu.springcloudcontractdemoconsumer;

import fraud.info.LoanResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"com.tianyu:spring-cloud-contract-demo-provider:+:stubs"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class LoanApplicationServiceTests {

    @Spy RestTemplate restTemplate;
    @StubRunnerPort("spring-cloud-contract-demo-provider") int producerPort;

    @Test
    public void shouldBeReturnProperLoanAmount() throws Exception{
        ResponseEntity<LoanResponse> response = restTemplate.getForEntity(String.format("http://127.0.0.1:%s/fraud/5", producerPort), LoanResponse.class);
        Assertions.assertEquals(response.getStatusCodeValue(), 200);
        Assertions.assertEquals(response.getBody().getClientId(), "5");
    }

    @Test
    public void shouldReturnHello() throws Exception{
        ResponseEntity<String> response = restTemplate.getForEntity(String.format("http://127.0.0.1:%s/test", producerPort), String.class);
        Assertions.assertEquals(response.getStatusCodeValue(), 200);
        Assertions.assertEquals(response.getBody(), "hello");
    }

}
