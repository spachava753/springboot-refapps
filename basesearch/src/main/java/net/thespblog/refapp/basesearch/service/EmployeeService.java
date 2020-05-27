package net.thespblog.refapp.basesearch.service;

import net.thespblog.refapp.basesearch.model.Employee;

import java.util.List;

public interface EmployeeService {
    /* (non-Javadoc)
     * @see com.springboot.elasticsearch.service.Employeeserv#saveEmployee(java.util.List)
     */
    void saveEmployee(List<Employee> employees);

    /* (non-Javadoc)
     * @see com.springboot.elasticsearch.service.Employeeserv#findAllEmployees()
     */
    Iterable<Employee> findAllEmployees();

    /* (non-Javadoc)
     * @see com.springboot.elasticsearch.service.Employeeserv#findByDesignation(java.lang.String)
     */
    List<Employee> findByDesignation(String designation);
}
