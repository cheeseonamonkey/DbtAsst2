package com.example.dbtasst2.models;

import com.example.dbtasst2.MainActivity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Day
{
    //references?
    List<Entry> entries = new ArrayList<>();

    DayOfWeek dayOfWeek;

    LocalDate date;

    Week parentWeek;



    //boolean startDay;


    public Day(LocalDate date)
    {
        this.date = date;
        dayOfWeek = date.getDayOfWeek();



    }

    public List<Entry> getEntries()
    {
        return entries;
    }


    public LocalDate getDate()
    {
        return date;
    }

    public Entry addEntry(Entry.Reason reason)
    {
        Entry entOut = new Entry(reason);
        entries.add(entOut);

        MainActivity.log.log("Adding entry to " + this.getDate().toString() + " : " + entOut.reason.toString(), "Entry");



        return entOut;
    }

}