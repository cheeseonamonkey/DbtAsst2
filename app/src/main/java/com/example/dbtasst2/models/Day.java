package com.example.dbtasst2.models;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Day
{
    //references? maybe use a method
    List<Section> entryGroups;

    DayOfWeek dayOfWeek;

    LocalDate date;

    boolean startDay;


    public Day(LocalDate date)
    {
        date = date;
        dayOfWeek = date.getDayOfWeek();



    }

    public List<Entry> GetAllEntries()
    {
        return new ArrayList<>();
    }

    public List<Section> GetAllSections()
    {
        return new ArrayList<>();
    }

}