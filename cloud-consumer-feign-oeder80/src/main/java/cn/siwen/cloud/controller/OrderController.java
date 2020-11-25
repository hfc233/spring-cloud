package cn.siwen.cloud.controller;


import cn.siwen.cloud.entity.CommonResult;

import cn.siwen.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class OrderController {
    private static final String PAYMENT_URL="http://PAYMENTCLOUD";

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/order/get/{id}")
    public CommonResult get(@PathVariable long id){
        return paymentFeignService.getPaymentById(id);
    }
}
