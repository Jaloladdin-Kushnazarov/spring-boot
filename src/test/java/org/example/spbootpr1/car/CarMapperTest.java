package org.example.spbootpr1.car;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.example.spbootpr1.car.CarMapper.CAR_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest {

    @Test
    void toDTO() {
         Car car = new Car("1","Coblat", "GM", 1200);
        CarDTO dto = CAR_MAPPER.toDTO(car);
        Car entity = CAR_MAPPER.toEntity(dto);
        System.out.println(dto.toString());
        System.out.println(entity.toString());
    }
}