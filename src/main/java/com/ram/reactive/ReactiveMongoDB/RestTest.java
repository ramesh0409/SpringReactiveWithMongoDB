package com.ram.reactive.ReactiveMongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rest/emp")
public class RestTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public Mono<Employee> getData(){
        return Mono.just(Employee.builder()
                .empId(100)
                .empName("Ramesh")
                .build());
    }

    @GetMapping("/{docId}")
    public Mono<Employee> getEmpById(@PathVariable String docId){
        return employeeRepository.findById(docId);

    }

    @GetMapping("/empId/{empId}")
    public Mono<Employee> getEmpByEmpId(@PathVariable Integer empId){
        return employeeRepository.findByEmpId(empId);

    }

    @GetMapping("/name/{empName}")
    public Flux<Employee> getEmpByEmpName(@PathVariable String empName){
        return employeeRepository.findByEmpName(empName);

    }

    @PostMapping
    public Mono<Employee> postData(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @PostMapping("/mono")
    public void postDataMono(@RequestBody Mono<Employee> employee){
        employee.subscribe(employee1 -> {
            employeeRepository.save(employee1);
        });

    }

}
