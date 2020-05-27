package net.thespblog.refapp.basesearch.service;

import net.thespblog.refapp.basesearch.model.Employee;
import net.thespblog.refapp.basesearch.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

    @Override
    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByDesignation(String designation) {
        return employeeRepository.findByDesignation(designation);
    }
}