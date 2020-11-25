package cn.siwen.cloud.controller;


import cn.siwen.cloud.entity.CommonResult;
import cn.siwen.cloud.entity.Payment;
import cn.siwen.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    //获取端口号
    @Value("${server.port}")
    String port;


    @PostMapping(value = "/payment/add")
    public CommonResult add(Payment payment){
        int result=paymentService.addPayment(payment);
        if(result>0){
            return new CommonResult(200,"seccuss",payment);
        }else{
            return new CommonResult(888,"falid");
        }
    }

    @GetMapping(value = "/payment/find/{id}")
    public CommonResult find(@PathVariable long id){
        Payment result=paymentService.findPaymentById(id);
        if(result!=null){
            return new CommonResult(200,"seccuss,查询的id"+id,"端口号:"+port);
        }else{
            return new CommonResult(999,"faild");
        }
    }

}
