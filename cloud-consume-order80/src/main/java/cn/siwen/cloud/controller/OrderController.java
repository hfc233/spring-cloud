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
    private static final String PAYMENT_URL="http://PAYMENTCLOUD";

    @Autowired
    RestTemplate restTemplate;


    @GetMapping(value = "/order/get/{id}")
    public CommonResult get(@PathVariable long id){
        return restTemplate.getForObject(PAYMENT_URL+"/paymnet/find/"+id,CommonResult.class,id);
    }

    @GetMapping(value="/order/add")
    public CommonResult add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommonResult.class);
    }
}
