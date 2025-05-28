package org.example.spbootpr1.car;


import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public interface CarMapper {

    CarMapper CAR_MAPPER = Mappers.getMapper(CarMapper.class);


    @Mapping(target = "carName", source = "name")
    @Mapping(target = "carPrice", source = "price")
    CarDTO toDTO(Car car);

//    @Mapping(target = "name", source = "carName")
//    @Mapping(target = "price", source = "carPrice")
    @InheritInverseConfiguration //bu anatatsiya orqali yuqorridagi 2 qatorni o'rnini bosadi ya'ni toDtoni ustidagi Mappinglarni teskarishini yozib beradi bu esa kod qayta takrorlanmaslikini oldini oladi
    @Mapping(target = "id" , expression = "java(generateID())")
    Car toEntity(CarDTO carDTO);


    default String generateID() {
        return UUID.randomUUID().toString();
    }
}
