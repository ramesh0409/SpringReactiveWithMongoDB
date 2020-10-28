package com.ram.reactive.ReactiveMongoDB;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String> {

    public Mono<Employee> findByEmpId(Integer id);
    public Flux<Employee> findByEmpName(String empName);
}
