package com.example.dbtasst2.models;



import java.sql.Time;

public class Entry
{
    //abstract these two types of entries?
    Rating rating;
    boolean yesNoRating;

    //references?
    //EntryGroup parentEntryGroup;
    //DayOfWeek parentDayOfWeek;
    //Week parentWeek;

    Time creationTime;
    Time setTime;

    EntryReason entryReason;

    public Entry()
    {

    }


    public enum Rating
    {
        _0(0),
        _1(1),
        _2(2),
        _3(3),
        _4(4),
        _5(5);

        int value;

        Rating(int v)
        {
            this.value = v;
        }

    }

    public enum EntryReason
    {
        MORNING,
        MIDDAY,
        EVENING,
        NIGHTTIME,
        OTHER,
        CUSTOM
    }
}
