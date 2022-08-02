package com.tianyu.springcloudcontractdemoprovider.fraud.resource;

import com.tianyu.springcloudcontractdemoprovider.fraud.info.LoanResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fraud")
public class FraudController {

    @GetMapping(value="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoanResponse findById(@PathVariable String id){
        return LoanResponse.builder()
                .clientId(id)
                .loanAmount(5555l)
                .build();
    }

}
