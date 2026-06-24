package io.savioromario10.hr_payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients(basePackages = "io.savioromario10.hr_payroll.feignclients")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}