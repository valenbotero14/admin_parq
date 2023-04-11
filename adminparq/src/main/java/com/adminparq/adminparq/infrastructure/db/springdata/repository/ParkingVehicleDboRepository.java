package com.adminparq.adminparq.infrastructure.db.springdata.repository;

import com.adminparq.adminparq.application.repository.ParkingVehicleRepository;
import com.adminparq.adminparq.domain.Parking;
import com.adminparq.adminparq.domain.ParkingVehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingVehicleEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.mapper.ParkingVehicleEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class ParkingVehicleDboRepository implements ParkingVehicleRepository {

    private final SpringDataParkingVehicleRepository parkingVehicleRepository;

    private final ParkingVehicleEntityMapper parkingVehicleMapper;


    @Override
    public List<ParkingVehicleEntity> getAllParkingVehicle() {

        return parkingVehicleRepository.findAll();
    }

    @Override
    public ParkingVehicle findById(Long id) {

        return parkingVehicleMapper.toDomain(parkingVehicleRepository.findById(id).orElseThrow());
    }


    @Override
    public ParkingVehicle save(ParkingVehicle parkingVehicle) {

        return parkingVehicleMapper.toDomain(parkingVehicleRepository.save(parkingVehicleMapper.toDbo(parkingVehicle)));

    }

    @Override
    public void updateParkingVehicle(ParkingVehicle parkingVehicle) {

        parkingVehicleMapper.toDomain(parkingVehicleRepository.save(parkingVehicleMapper.toDbo(parkingVehicle)));
    }

    @Override
    public void deleteById(Long id) {

        parkingVehicleRepository.deleteById(id);

    }

}
