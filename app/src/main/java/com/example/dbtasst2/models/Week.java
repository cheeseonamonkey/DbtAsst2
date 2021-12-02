package com.example.dbtasst2.models;



import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        weekStartDate = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
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



    public Day getToday()
    {


        for (Day d : days)
        {
            LocalDate ldnow = LocalDate.now();

            if (d.date.equals(LocalDate.now()))
                return d;
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
