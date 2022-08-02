package contracts

import org.springframework.cloud.contract.spec.internal.DslProperty
import org.springframework.http.MediaType

def example = new DslProperty("/test", "/test")
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method GET()
        url example
        body([])
    }
    response {
        status OK()
        body(
                "hello"
        )
        headers {
            contentType(MediaType.APPLICATION_JSON_VALUE)
        }
    }
}
