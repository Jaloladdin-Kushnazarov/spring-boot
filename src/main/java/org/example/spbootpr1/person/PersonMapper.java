package org.example.spbootpr1.person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper PERSON_MAPPER = Mappers.getMapper(PersonMapper.class);


    @Mapping(target = "fullName", source = "personDTO.name")
    @Mapping(target = "personAdressAppartement", source = "adressDTO.appartment")
    @Mapping(target = "personAdressCity", source = "adressDTO.city")
    @Mapping(target = "personPassportSeril", source = "passportDTO.serial")
    @Mapping(target = "personPassportNumber", source = "passportDTO.number")
    Person toEntity(PersonDTO personDTO, AdressDTO adressDTO, PassportDTO passportDTO);
}
