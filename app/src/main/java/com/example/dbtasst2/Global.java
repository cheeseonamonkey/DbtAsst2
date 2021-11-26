package com.example.dbtasst2;

import com.example.dbtasst2.models.Diary;

import java.time.LocalDate;
import java.time.LocalTime;

public class Global
{

    public LocalTime CurrentTime()
    {
        return LocalTime.now();
    }

    public LocalDate Today()
    {
        return LocalDate.now();
    }
}
