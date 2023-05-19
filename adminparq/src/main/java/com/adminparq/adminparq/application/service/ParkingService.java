package com.adminparq.adminparq.application.service;

import com.adminparq.adminparq.application.repository.ParkingRepository;
import com.adminparq.adminparq.domain.Parking;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service

public class ParkingService {

    private final ParkingRepository parkingRepository;

    public List<ParkingEntity> getAllParking() {

        return parkingRepository.getAllParking();

    }

    public List<ParkingEntity> getAllParkingByParkingType (String parkingType){

        return  parkingRepository.getAllParkingByParkingType(parkingType);

    }

    public Parking getParking(Long id) {

        return parkingRepository.findById(id);

    }

    public Parking saveParking(Parking parking) {

        return parkingRepository.save(parking);

    }

    public void updateParking(Parking existentParking) {

        parkingRepository.updateParking(existentParking);

    }

    public void deleteParking(Long id) {

        parkingRepository.deleteById(id);

    }

    /*public long countAllParking() {

        return ParkingRepository.count();
    }*/
}
