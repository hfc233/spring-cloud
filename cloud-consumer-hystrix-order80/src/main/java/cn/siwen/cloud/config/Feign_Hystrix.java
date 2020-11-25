package cn.siwen.cloud.config;

import cn.siwen.cloud.service.HystrixService;

public class Feign_Hystrix implements HystrixService {


    public String paymentInfo_OK(Integer id) {
        return "服务降级方法!!!!";
    }


    public String paymentInfo_TimeOut(Integer id) {
        return "服务降级方法!!!!";
    }
}
