package cn.siwen.cloud.service.impl;

import cn.siwen.cloud.dao.PaymentDao;
import cn.siwen.cloud.entity.Payment;
import cn.siwen.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    public int addPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }


    public Payment findPaymentById(long id) {
        return paymentDao.selectPaymentById(id);
    }
}
