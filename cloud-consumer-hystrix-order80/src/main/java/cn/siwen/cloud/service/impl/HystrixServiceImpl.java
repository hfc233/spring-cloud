package cn.siwen.cloud.service.impl;

import cn.siwen.cloud.service.HystrixService;

public class HystrixServiceImpl implements HystrixService {

    public String paymentInfo_OK(Integer id) {
        return "线程池："+Thread.currentThread().getName()+",paymentInfo_OK,id:"+id;
    }


    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber=3000;
        try {
            Thread.sleep(timeNumber);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+",paymentInfo_OK,id:"+id+",耗时+"+timeNumber+"毫秒";
    }
}
