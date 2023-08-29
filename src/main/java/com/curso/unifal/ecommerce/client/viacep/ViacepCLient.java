package com.curso.unifal.ecommerce.client.viacep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

@FeignClient(name = "via-cep-client", url = "https://viacep.com.br/")
public interface ViacepCLient {
    @GetMapping(path = "/ws/{zipCode}/json/")
    Object getZipCodeInfoByZipCode(@PathVariable String zipCode);
}
