/**
 * Media between the data access layer and the business logic layer
 */

package com.adminparq.adminparq.infrastructure.db.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adminparq.adminparq.infrastructure.db.springdata.dbo.EmployeeEntity;

/**
 * The annotation indicates that the underlying interface is a repository and tells Spring to register it
 * as a bean in the context during component scanning.
 */
@Repository
public interface SpringDataEmployeeRepository extends JpaRepository<EmployeeEntity, Long> {


}
