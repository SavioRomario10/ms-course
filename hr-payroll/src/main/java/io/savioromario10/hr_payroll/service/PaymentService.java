package io.savioromario10.hr_payroll.service;

import org.springframework.stereotype.Service;

import io.savioromario10.hr_payroll.entity.Payment;

@Service
public class PaymentService {
  
  public Payment getPayment(long workerId, int days){
    return new Payment("Bob", 30.0, days);
  }
}