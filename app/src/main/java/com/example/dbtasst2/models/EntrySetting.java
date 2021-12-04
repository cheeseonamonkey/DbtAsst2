package com.example.dbtasst2.models;

public class EntrySetting
{
    String name;
    EntryItem.Type type;

    public EntrySetting(String name, EntryItem.Type type)
    {
        this.name = name;
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public EntryItem.Type getType()
    {
        return type;
    }
}
