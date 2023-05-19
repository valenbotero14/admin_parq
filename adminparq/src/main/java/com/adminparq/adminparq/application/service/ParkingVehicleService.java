package com.adminparq.adminparq.application.service;

import com.adminparq.adminparq.application.repository.ParkingVehicleRepository;
import com.adminparq.adminparq.domain.ParkingVehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingVehicleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service

public class ParkingVehicleService {

    private final ParkingVehicleRepository parkingVehicleRepository;


    public List<ParkingVehicleEntity> getAllParkingVehicle() {

        return parkingVehicleRepository.getAllParkingVehicle();

    }


    public  List<ParkingVehicleEntity> findAllByParkingId (Long id) {

        return parkingVehicleRepository.findAllByParkingId(id);
    }


    public ParkingVehicle getParkingVehicle(Long id) {

        return parkingVehicleRepository.findById(id);

    }


    public ParkingVehicle saveParkingVehicle(ParkingVehicle parkingVehicle) {

        return parkingVehicleRepository.save(parkingVehicle);

    }


    public void updateParkingVehicle(ParkingVehicle existentParkingVehicle) {

        parkingVehicleRepository.updateParkingVehicle(existentParkingVehicle);

    }

    public void deleteParkingVehicle(Long id) {

        parkingVehicleRepository.deleteById(id);

    }



}


