package cn.siwen.cloud.controller;

import cn.siwen.cloud.service.HystrixPaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentHystrixController {
    @Resource
    private HystrixPaymentService hystrixPaymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = hystrixPaymentService.paymentInfo_OK(id);
        return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = hystrixPaymentService.paymentInfo_TimeOut(id);
        return result;
    }
}
