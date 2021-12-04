package com.example.dbtasst2.models;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.dbtasst2.MainActivity;
import com.google.gson.Gson;

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

       // setDefaults();

        initDiary();


    }

    public Week getCurrentWeek()
    {
        return weeks.get(weeks.size() - 1);
    }

    public List<Week> getWeeks()
    {
        return weeks;
    }

    public void initDiary()
    {

        if(weeks.size() == 0)
        {
            weeks.add(new Week());
        }



        MainActivity.global.selectedWeek = getCurrentWeek();
    }

    public void setDefaults()
    {
        weeks.add(new Week());
    }

    public String toJson()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

/*
    public void saveDiary(Activity activity)
    {
        SharedPreferences sharePrefs = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = sharePrefs.edit();

        prefEditor.putString("diary", MainActivity.diary.toJson());
        prefEditor.apply();
    }

    public void loadDiary()
    {
        SharedPreferences sharedPrefs = activity.getPreferences(Context.MODE_PRIVATE);

        String diaryJson = sharedPrefs.getString("diary","{\"weeks\":[{\"days\":[{\"date\":{},\"dayOfWeek\":\"MONDAY\",\"entries\":[]},{\"date\":{},\"dayOfWeek\":\"TUESDAY\",\"entries\":[]},{\"date\":{},\"dayOfWeek\":\"WEDNESDAY\",\"entries\":[]},{\"date\":{},\"dayOfWeek\":\"THURSDAY\",\"entries\":[]},{\"date\":{},\"dayOfWeek\":\"FRIDAY\",\"entries\":[]},{\"date\":{},\"dayOfWeek\":\"SATURDAY\",\"entries\":[]},{\"date\":{},\"dayOfWeek\":\"SUNDAY\",\"entries\":[]}],\"enteredDuringSession\":false,\"entryFrequency\":0,\"weekEndDate\":{},\"weekNum\":0,\"weekStartDate\":{}}]}");
        MainActivity.log.log(diaryJson,"load");
    }

 */



    public void setSampleData()
    {
        this.getCurrentWeek().getToday()
                .addEntry(Entry.Reason.MORNING)
                .addItem("MURDER", 3, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", 1, EntryItem.Section.HIGHEST_RATING)
                .addItem("MURDER", 3, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", 2, EntryItem.Section.HIGHEST_RATING)
                .addItem("MURDER", 3, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", false, EntryItem.Section.HIGHEST_RATING)
                .addItem("DEATH", false, EntryItem.Section.HIGHEST_RATING);

        this.getCurrentWeek().getToday()
                .addEntry(Entry.Reason.MIDDAY)
                .addItem("MURDER", 1, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", 2, EntryItem.Section.HIGHEST_RATING)
                .addItem("MURDER", 2, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", 4, EntryItem.Section.HIGHEST_RATING)
                .addItem("MURDER", 4, EntryItem.Section.HIGHEST_URGE_TO)
                .addItem("DEATH", true, EntryItem.Section.HIGHEST_RATING)
                .addItem("DEATH", true, EntryItem.Section.HIGHEST_RATING);

        this.getCurrentWeek().getToday()
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
