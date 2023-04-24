package com.adminparq.adminparq.infrastructure.db.springdata.repository;


import com.adminparq.adminparq.application.repository.VehicleRepository;
import com.adminparq.adminparq.domain.Vehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.VehicleEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.mapper.VehicleEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
public class VehicleDboRepository implements VehicleRepository {

    private final SpringDataVehicleRepository vehicleRepository;

    private final VehicleEntityMapper vehicleMapper;


    @Override
    public List<VehicleEntity> getAllVehicle() {

        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(Long id) {

        return vehicleMapper.toDomain(vehicleRepository.findById(id).orElseThrow());
    }

    @Override
    public Vehicle findByPlate (String plate){

        return vehicleMapper.toDomain(vehicleRepository.findByPlate(plate));
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleMapper.toDomain(vehicleRepository.save(vehicleMapper.toDbo(vehicle)));

    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        vehicleMapper.toDomain(vehicleRepository.save(vehicleMapper.toDbo(vehicle)));
    }

    @Override
    public void deleteById(Long id) {

        vehicleRepository.deleteById(id);

    }


}


