package com.example.dbtasst2.models;



public class EntryItem
{
    //abstract these two types of entries?
    Value value;

    String name;

    Section section;
    Type type;

    //references?
    //DayOfWeek parentDayOfWeek;
    //Week parentWeek;





public EntryItem()
{

}


//yes no constructor
    public EntryItem(String name, boolean booVal, Section section)
    {
        this.name = name;
        type = Type.YESNO;
        this.section = section;

        if(booVal)
        {
            value = Value.YES;
        }
        else
        {
            value = Value.NO;
        }
    }


//rating value constructor
    public EntryItem(String name, int intVal, Section section)
    {

        this.name = name;

        type = Type.RATING;

        this.section = section;

        switch(intVal)
        {
            case 0:
                value = Value._0;
                break;

            case 1:
                value = Value._1;
                break;

            case 2:
                value = Value._2;
                break;

            case 3:
                value = Value._3;
                break;

            case 4:
                value = Value._4;
                break;

            case 5:
                value = Value._5;
                break;

            default:
                break;

        }
    }




    public static EntryItem newEntryItem(String name, boolean booVal, Section section)
    {
        return new EntryItem(name, booVal, section);
    }
    public static EntryItem newEntryItem(String name, int intVal, Section section)
    {
        return new EntryItem().setName(name).setValue(Value._0).setSection(section);
    }



    public EntryItem setValue(Value value)
    {
        this.value = value;
        return this;
    }



    public EntryItem setName(String name)
    {
        this.name = name;
        return this;
    }

    public EntryItem setSection(Section section)
    {
        this.section = section;
        return this;
    }

    public EntryItem setType(Type type)
    {
        this.type = type;
        return this;
    }




    public String getValue()
    {
        return value.value;
    }


    public String getName()
    {
        return name;
    }

    public enum Value
    {
        _0("0"),
        _1("1"),
        _2("2"),
        _3("3"),
        _4("4"),
        _5("5"),
        YES("Y"),
        NO("N");

        String value;

        Value(String v)
        {
            this.value = v;
        }

    }

    public enum Type
    { YESNO, RATING }

    public enum Section
    {
        HIGHEST_URGE_TO("Highest Urge To"),
        HIGHEST_RATING("Highest Rating"),
        EMOTIONS("Emotions"),
        OTHERS("Others"),
        CUSTOM("Custom");

        public String value;

        Section(String value)
        {
            this.value = value;
        }

    }

}
