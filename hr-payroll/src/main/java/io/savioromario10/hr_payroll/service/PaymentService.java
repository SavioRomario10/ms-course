package io.savioromario10.hr_payroll.service;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.savioromario10.hr_payroll.entity.Payment;
import io.savioromario10.hr_payroll.entity.Worker;

@Service
public class PaymentService {
  
  @Value("${hr-worker.host}")
  private String workerHost;

  @Autowired
  private RestTemplate restTemplate;

  public Payment getPayment(long workerId, int days){

    Map<String, String> uriVariables = new HashMap<>();

    uriVariables.put("id", String.valueOf(workerId));

    Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }
}