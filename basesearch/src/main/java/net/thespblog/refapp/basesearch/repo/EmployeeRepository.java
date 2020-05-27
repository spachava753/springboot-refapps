package net.thespblog.refapp.basesearch.repo;

import net.thespblog.refapp.basesearch.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    public List<Employee> findByDesignation(String designation);
 
}