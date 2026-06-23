package io.savioromario10.hr_payroll.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import io.savioromario10.hr_payroll.service.PaymentService;
import io.savioromario10.hr_payroll.entity.Payment;

@RestController
@RequestMapping("/payments")
public class PaymentController {

  @Autowired
  private PaymentService service;

  @GetMapping("/{workerId}/days/{days}")
  public ResponseEntity<Payment> getPayment(@PathVariable long workerId, @PathVariable int days){
    return ResponseEntity.ok(service.getPayment(workerId, days));
  }
}