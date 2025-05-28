package org.example.spbootpr1.employee;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface EmployeMapper {

    EmployeMapper EMPLOYE_MAPPER = Mappers.getMapper(EmployeMapper.class);

    @MapMapping(keyTargetType = String.class, valueTargetType = String.class)
    Employe fromMap(Map<String, String> params);


    @MapMapping(keyTargetType = String.class, valueTargetType = Object.class)
    Employe fromMap2(Map<String, Object> params);

     default String fromObjectToStrine(Object obj) {
         return String.valueOf(obj);
     }
}
