package com.tianyu.springcloudcontractdemoprovider.fraud.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponse {

    @JsonProperty("client.id")
    private String clientId;

    private Long loanAmount;

}
