package cn.siwen.cloud.service;


import cn.siwen.cloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "PAYMENTCLOUD")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/find/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id);
}
