package org.example.spbootpr1.enums;

import org.junit.jupiter.api.Test;

import static org.example.spbootpr1.enums.WeekDaysMapper.WEEK_DAYS_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class WeekDaysMapperTest {

    @Test
    void from() {
        WeekDays from = WEEK_DAYS_MAPPER.from(HaftaKunlari.SESHANBA);
        System.out.println(from);

    }

    @Test
    void to() {
        HaftaKunlari haftaKunlari = WEEK_DAYS_MAPPER.to(WeekDays.WEDNESDAY);
        System.out.println(haftaKunlari);


    }
}