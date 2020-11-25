package cn.siwen.cloud.service.impl;

import cn.siwen.cloud.entity.CommonResult;
import cn.siwen.cloud.entity.Payment;
import cn.siwen.cloud.service.PaymentFeignService;
import org.springframework.stereotype.Service;

@Service
public class PaymentFeignServiceImpl implements PaymentFeignService {

    public CommonResult getPaymentById(long id) {
        return new CommonResult(404,"ff",new Payment(id,"ss"));
    }
}
