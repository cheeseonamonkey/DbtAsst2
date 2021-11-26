package com.example.dbtasst2.models;

import com.example.dbtasst2.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class Diary
{
    List<Week> weeks = new ArrayList<>();

    //settings
    //reminders
    //colors

    public Diary()
    {
        setDefaults();

    }

    public Week getCurrentWeek()
    {
        return weeks.get(weeks.size() - 1);

    }




    public void setDefaults()
    {
        weeks.add(new Week());
    }

    public void setSampleData()
    {
        this.getCurrentWeek().days.get(0)
                .addEntry(Entry.Reason.MORNING)
                .addItem("MURDER", 3, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", 1, EntryItem.Section.HIGHEST_RATING)
                .addItem("MURDER", 3, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", 2, EntryItem.Section.HIGHEST_RATING)
                .addItem("MURDER", 3, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", false, EntryItem.Section.HIGHEST_RATING)
                .addItem("DEATH", false, EntryItem.Section.HIGHEST_RATING);

        this.getCurrentWeek().days.get(0)
                .addEntry(Entry.Reason.MIDDAY)
                .addItem("MURDER", 1, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", 2, EntryItem.Section.HIGHEST_RATING)
                .addItem("MURDER", 2, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", 4, EntryItem.Section.HIGHEST_RATING)
                .addItem("MURDER", 4, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", true, EntryItem.Section.HIGHEST_RATING)
                .addItem("DEATH", true, EntryItem.Section.HIGHEST_RATING);

        this.getCurrentWeek().days.get(0)
                .addEntry(Entry.Reason.EVENING)
                .addItem("MURDER", 1, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", 0, EntryItem.Section.HIGHEST_RATING)
                .addItem("MURDER", 0, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", 5, EntryItem.Section.HIGHEST_RATING)
                .addItem("MURDER", 1, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", true, EntryItem.Section.HIGHEST_RATING)
                .addItem("DEATH", false, EntryItem.Section.HIGHEST_RATING);


        MainActivity.log.log(Integer.toString( getCurrentWeek().days.get(0).getEntries().size()) );

        for (int i = 0; i < getCurrentWeek().days.get(0).getEntries().size() - 1; i++)
        {
            MainActivity.log.log("day " + i + ": " + Integer.toString( getCurrentWeek().days.get(0).getEntries().get(0).getItems().size()) );
        }




    }
}
