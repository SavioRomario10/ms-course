package io.savioromario10.hr_worker.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.savioromario10.hr_worker.entity.Worker;
import io.savioromario10.hr_worker.repository.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerController {

  private static Logger logger = Logger.getLogger(WorkerController.class.getName());

  @Value("${test.config}")
  private String testConfig;

  @Autowired
  private WorkerRepository repository;

  public WorkerController(WorkerRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public ResponseEntity<List<Worker>> findAll(){
    List<Worker> list = repository.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Worker> findById(@PathVariable Long id){
    Worker worker = repository.findById(id).orElse(null);
    return ResponseEntity.ok().body(worker);
  }

  @GetMapping("/configs")
  public ResponseEntity<Void> getConfigs(){
    logger.info("CONFIG: " + testConfig);
    return ResponseEntity.noContent().build();
  }
}