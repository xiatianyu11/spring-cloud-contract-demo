package com.tianyu.springcloudcontractdemoprovider.contract;

import com.tianyu.springcloudcontractdemoprovider.core.ClassPathControllerScanningUtil;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BaseTestClass {
    @Value("${controller.base.package}")
    private String controllerBasePackage;

    @BeforeEach
    public void setUp(){
        RestAssuredMockMvc.standaloneSetup(ClassPathControllerScanningUtil.getInstance().scan(controllerBasePackage));
    }
}
