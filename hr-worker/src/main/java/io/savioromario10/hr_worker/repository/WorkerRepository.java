package io.savioromario10.hr_worker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.savioromario10.hr_worker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}