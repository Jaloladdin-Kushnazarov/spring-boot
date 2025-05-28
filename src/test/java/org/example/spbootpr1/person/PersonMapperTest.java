package org.example.spbootpr1.person;

import org.junit.jupiter.api.Test;

import static org.example.spbootpr1.person.PersonMapper.PERSON_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class PersonMapperTest {

    @Test
    void toEntity() {

        PersonDTO personDTO = new PersonDTO("Jaloladdin", 25);
        AdressDTO adressDTO = new AdressDTO("Qurilish 11", "Toshkent");
        PassportDTO passportDTO = new PassportDTO("AB", "1223434");
        Person entity = PERSON_MAPPER.toEntity(personDTO, adressDTO, passportDTO);
        System.out.println(entity);

    }
}