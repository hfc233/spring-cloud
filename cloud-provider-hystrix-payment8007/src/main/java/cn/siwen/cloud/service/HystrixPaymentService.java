package cn.siwen.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class HystrixPaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池："+Thread.currentThread().getName()+",paymentInfo_OK,id:"+id;
    }

    @HystrixCommand(fallbackMethod = "HystrixPaymentService_fallBack",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber=3000;
        try {
            Thread.sleep(timeNumber);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+",paymentInfo_OK,id:"+id+",耗时+"+timeNumber+"毫秒";
    }

    public String HystrixPaymentService_fallBack(Integer id){
        return "线程池："+Thread.currentThread().getName()+",系统繁忙,请稍后再试!id:"+id;
    }
    @HystrixCommand(fallbackMethod = "HystrixPaymentService_fallBack",commandProperties = {

    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("*********id 不能为负数");
        }
        String serialNumber= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"调用成功,流水号:"+serialNumber;
    }

}
