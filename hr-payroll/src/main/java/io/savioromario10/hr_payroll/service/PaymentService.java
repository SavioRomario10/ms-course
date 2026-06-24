package io.savioromario10.hr_payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.savioromario10.hr_payroll.entity.Payment;
import io.savioromario10.hr_payroll.entity.Worker;
import io.savioromario10.hr_payroll.feignclients.WorkerFeignClients;

@Service
public class PaymentService {

  @Autowired
  private WorkerFeignClients workerFeignClients;

  public PaymentService(WorkerFeignClients workerFeignClients) {
    this.workerFeignClients = workerFeignClients;
  }

  public Payment getPayment(long workerId, int days){

    Worker worker = workerFeignClients.findById(workerId).getBody();

    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }
}