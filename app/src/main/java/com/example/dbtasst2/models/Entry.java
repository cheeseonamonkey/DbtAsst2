package com.example.dbtasst2.models;


import com.example.dbtasst2.MainActivity;
import com.example.dbtasst2.R;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Entry
{

    List<EntryItem> items = new ArrayList<>();

    LocalTime creationTime;
    //LocalTime customTime;

    Reason reason;

    public Entry(Reason reason)
    {


        creationTime = LocalTime.now();

        this.reason = reason;
    }

    //chain builder
    public Entry addItem(String name, boolean booVal, EntryItem.Section section)
    {
        this.items.add(new EntryItem(name, booVal, section));

        MainActivity.log.log("Adding item to entry " + this.reason.toString() + ": " + name, "Entry");

        return this;
    }

    public Entry addItem(String name, int intVal, EntryItem.Section section)
    {
        this.items.add(new EntryItem(name, intVal, section));

        MainActivity.log.log("Adding item to entry " + this.reason.toString() + ": " + name, "Entry");

        return this;
    }



    public String getScoresAsString()
    {
        String strOut = "";

        for (int i = 0; i < items.size(); i++)
        {
            strOut += items.get(i).getValue() + "/";
        }



        return strOut;
    }

    public List<EntryItem> getItems()
    {
        return items;
    }

    public LocalTime getCreationTime()
    {
        return creationTime;
    }

    public Reason getReason()
    {
        return reason;
    }

    public enum Reason
    {
        MORNING,
        MIDDAY,
        EVENING,
        NIGHTTIME,
        OTHER,
        CUSTOM
    }





}
