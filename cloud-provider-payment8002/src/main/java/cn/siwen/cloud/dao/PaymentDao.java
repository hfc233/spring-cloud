package cn.siwen.cloud.dao;

import cn.siwen.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int insertPayment(Payment payment);

    public Payment selectPaymentById(@Param("id") long id);
}
