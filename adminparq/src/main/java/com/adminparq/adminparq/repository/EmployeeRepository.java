package com.adminparq.adminparq.repository;

import com.adminparq.adminparq.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    List<Employee> findByName(@Param("name") String name);
}
