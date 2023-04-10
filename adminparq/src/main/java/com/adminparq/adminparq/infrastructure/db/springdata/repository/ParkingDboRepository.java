package com.adminparq.adminparq.infrastructure.db.springdata.repository;


import com.adminparq.adminparq.application.repository.ParkingRepository;
import com.adminparq.adminparq.domain.Parking;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.mapper.ParkingEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ParkingDboRepository implements ParkingRepository {

    private final SpringDataParkingRepository parkingRepository;

    private final ParkingEntityMapper parkingMapper;


    @Override
    public List<ParkingEntity> getAllParking() {

        return parkingRepository.findAll();
    }

    @Override
    public Parking findById(Long id) {

        return parkingMapper.toDomain(parkingRepository.findById(id).orElseThrow());
    }

    @Override
    public Parking save(Parking parking) {
        return parkingMapper.toDomain(parkingRepository.save(parkingMapper.toDbo(parking)));

    }

    @Override
    public void updateParking(Parking parking) {

        parkingMapper.toDomain(parkingRepository.save(parkingMapper.toDbo(parking)));
    }

    @Override
    public void deleteById(Long id) {

        parkingRepository.deleteById(id);

    }

}

