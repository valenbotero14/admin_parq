/**
 * Media entre la capa de acceso a datos y la capa de lógica empresarial
 */

package com.adminparq.adminparq.infrastructure.db.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adminparq.adminparq.infrastructure.db.springdata.dbo.EmployeeEntity;

/**
 * La anotación indica que la interfaz subyacente es un repositorio y le dice a Spring que lo registre
 * como un bean en el contexto durante la exploración de componentes.
 */
@Repository
public interface SpringDataEmployeeRepository extends JpaRepository<EmployeeEntity, Long> {


}
