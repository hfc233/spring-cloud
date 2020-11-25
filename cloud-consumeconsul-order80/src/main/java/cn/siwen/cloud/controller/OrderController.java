package cn.siwen.cloud.controller;


import cn.siwen.cloud.entity.CommonResult;
import cn.siwen.cloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrderController {
    private static final String PAYMENT_URL="http://cloud-provider-payment";

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/consumer/payment/consul")
    public String payment (){
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
        return result;
    }
}
