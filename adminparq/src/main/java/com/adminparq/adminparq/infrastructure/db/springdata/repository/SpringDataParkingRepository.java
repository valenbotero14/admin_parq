package com.adminparq.adminparq.infrastructure.db.springdata.repository;


import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataParkingRepository extends JpaRepository<ParkingEntity, Long> {

}
