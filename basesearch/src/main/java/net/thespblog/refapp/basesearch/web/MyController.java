package net.thespblog.refapp.basesearch.web;

import net.thespblog.refapp.basesearch.model.Employee;
import net.thespblog.refapp.basesearch.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/employee")
public class MyController {
 
    private final EmployeeService employeeService;

    public MyController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value= "/saveemployees")
    public String saveEmployee(@RequestBody List<Employee> myemployees) {
        employeeService.saveEmployee(myemployees);
        return "Records saved in the db.";
    }

    @GetMapping(value= "/getall")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping(value= "/findbydesignation/{employee-designation}")
    public Iterable<Employee> getByDesignation(@PathVariable(name= "employee-designation") String designation) {
        return employeeService.findByDesignation(designation);
    }
}