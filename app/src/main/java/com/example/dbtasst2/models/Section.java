package com.example.dbtasst2.models;

import android.graphics.Color;

import java.util.List;

public class Section
{
    SectionType sectionType;
    SectionName sectionName;

    List<Entry> entryItems;

    Color color;




    public Section(SectionType sectionType, SectionName sectionName)
    {
        this.sectionType = sectionType;
        this.sectionName = sectionName;
    }


    enum SectionType { YESNO, RATING }

    public List<Entry> GetAll()
    {
        return entryItems;
    }


    enum SectionName
    {
        HIGHEST_URGE_TO("Highest Urge To"),
        HIGHEST_RATING("Highest Rating"),
        EMOTIONS("Emotions"),
        OTHERS("Others"),
        CUSTOM("Custom");

        String value;

        SectionName(String value)
        {
            this.value = value;
        }

    }
}
