package org.example.spbootpr1.enums;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeekDaysMapper {

    WeekDaysMapper WEEK_DAYS_MAPPER = Mappers.getMapper(WeekDaysMapper.class);

    @ValueMapping(target = "MONDAY", source = "DUSHANBA")
    @ValueMapping(target = "TUESDAY", source = "SESHANBA")
    @ValueMapping(target = "WEDNESDAY", source = "CHORSHANBA")
     WeekDays from(HaftaKunlari haftaKunlari);

    @InheritInverseConfiguration
     HaftaKunlari to(WeekDays weekDays);
}
