package org.example.spbootpr1.employee;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.example.spbootpr1.employee.EmployeMapper.EMPLOYE_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class EmployeMapperTest {

    @Test
    void fromMap() {

        var params = Map.of(
                "firstName", "Jaloladiin",
                "lastName", "Kushnazarov",
                "age", "26"
        );

        Employe employe = EMPLOYE_MAPPER.fromMap(params);
        System.out.println(employe);
    }




    @Test
    void fromMap2() {

        Map<String, Object> params = Map.of(
                "firstName", "Jaloladiin",
                "lastName", "Kushnazarov",
                "age", "26"
        );

        Employe employe = EMPLOYE_MAPPER.fromMap2(params);
        System.out.println(employe);
    }
}