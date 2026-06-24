package io.savioromario10.hr_payroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.savioromario10.hr_payroll.entity.Worker;

@FeignClient(
  name = "hr-worker", 
  url="http://localhost:8001", 
  path = "/workers")
public interface WorkerFeignClients {

  @GetMapping("/{id}")
  ResponseEntity<Worker> findById(@PathVariable Long id);
}