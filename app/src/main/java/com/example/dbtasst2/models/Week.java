package com.example.dbtasst2.models;



import com.example.dbtasst2.MainActivity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Week
{
    LocalDate weekStartDate;
    LocalDate weekEndDate;

    List<Day> days;


    SkillUsage skillsUsed;
    Skill skillThisWeekFocus;

    //auto generated:
    int weekNum;
    int entryFrequency;
    LocalDate lastEntryDay;
    boolean enteredDuringSession;




    public Week()
    {
        //make days
        weekStartDate = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        weekEndDate = weekStartDate.plusDays(7);

        days = new ArrayList<>();

        for (int i = 0; i < 7; i++)
        {
            days.add(new Day(weekStartDate.plusDays(i)));
        }
    }


    public Week(LocalDate weekStart)
    {
        //make days
        weekStartDate = weekStart;
        weekEndDate = weekStartDate.plusDays(7);

        for (int i = 0; i < 7; i++)
        {
            days.add(new Day(weekStartDate.plusDays(i)));
        }
    }


    public List<Day> getDays()
    {
        return days;
    }


    public Day getDay(String dayOfWeek)
    {
        switch(dayOfWeek.toLowerCase().toLowerCase(Locale.ROOT)) {

            //no breaks for returns! lol

            case "sunday":
            case "sun":
                for(Day d : days)
                {
                    if(d.getDate().getDayOfWeek().equals(DayOfWeek.SUNDAY))
                        return d;
                }

            case "monday":
            case "mon":
                for(Day d : days)
                {
                    if(d.getDate().getDayOfWeek().equals(DayOfWeek.MONDAY))
                        return d;
                }

            case "tuesday":
            case "tue":
                for(Day d : days)
                {
                    if(d.getDate().getDayOfWeek().equals(DayOfWeek.TUESDAY))
                        return d;
                }

            case "wednesday":
            case "wed":
                for(Day d : days)
                {
                    if(d.getDate().getDayOfWeek().equals(DayOfWeek.WEDNESDAY))
                        return d;
                }

            case "thursday":
            case "thu":
                for(Day d : days)
                {
                    if(d.getDate().getDayOfWeek().equals(DayOfWeek.THURSDAY))
                        return d;
                }

            case "friday":
            case "fri":
                for(Day d : days)
                {
                    if(d.getDate().getDayOfWeek().equals(DayOfWeek.FRIDAY))
                        return d;
                }

            case "saturday":
            case "sat":
                for(Day d : days)
                {
                    if(d.getDate().getDayOfWeek().equals(DayOfWeek.SATURDAY))
                        return d;
                }

            default:
                throw new NullPointerException("Day: " + dayOfWeek + " - not found");
        }

    }

    public Day getToday() //checked
    {

        for (Day d : days)
        {
            LocalDate ldnow = LocalDate.now();

            if (d.date.getDayOfWeek().equals(LocalDate.now().getDayOfWeek()))
            {
                //checked
                return d;

            }
        }



        throw new NullPointerException("Day not found");
    }


    public LocalDate getWeekStartDate()
    {
        return weekStartDate;
    }

    public LocalDate getWeekEndDate()
    {
        return weekEndDate;
    }

    public void SetDefaults()
    {

    }

    //this week's assigned homework
    //- as string?
    //this week's homework results
    //- need more info?
}
