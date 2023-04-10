package com.adminparq.adminparq.infrastructure.db.springdata.repository;


import com.adminparq.adminparq.infrastructure.db.springdata.dbo.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataVehicleRepository extends JpaRepository<VehicleEntity, Long> {


}
