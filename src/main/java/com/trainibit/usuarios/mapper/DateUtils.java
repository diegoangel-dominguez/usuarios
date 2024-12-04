package com.trainibit.usuarios.mapper;

import java.time.LocalDate;
import java.time.Period;

public class DateUtils {
    public static int calculateAge(LocalDate birthDate) {
        /*if (birthDate == null) {
            return 0;
        }*/
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
