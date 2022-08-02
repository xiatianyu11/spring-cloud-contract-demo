package contracts

import org.springframework.http.MediaType

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method GET()
        url '/fraud/5'
        body([])
    }
    response {
        status OK()
        body([
                "client.id":5,
                "loanAmount": $(regex('[0-9]+'))
        ])
        headers {
            contentType(MediaType.APPLICATION_JSON_VALUE)
        }
    }
}
