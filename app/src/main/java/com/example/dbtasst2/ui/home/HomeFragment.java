package com.example.dbtasst2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TabHost;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dbtasst2.MainActivity;
import com.example.dbtasst2.databinding.FragmentHomeBinding;
import com.example.dbtasst2.models.Diary;
import com.example.dbtasst2.models.Entry;
import com.example.dbtasst2.models.Week;
import com.example.dbtasst2.ui.adapters.EntryAdapter;
import com.example.dbtasst2.ui.newEntry.NewEntryFragment;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment
{

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;


    List<LinearLayout> tabList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {


        binding = FragmentHomeBinding.inflate(inflater, container, false);

        View view = binding.getRoot();


        //set up tab list
        for (int i = 0; i < binding.tabcontent.getChildCount(); i++)
        {
            tabList.add( (LinearLayout) binding.tabcontent.getChildAt(i));
          //  MainActivity.log.log(binding.tabcontent.getChildAt(i).toString());
        }



        binding.txtWeekDateSunday.setText(MainActivity.global.selectedWeek.getDay("sun").getDate().toString());
        binding.txtWeekDateMon.setText(MainActivity.global.selectedWeek.getDay("mon").getDate().toString());
        binding.txtWeekDateTue.setText(MainActivity.global.selectedWeek.getDay("tue").getDate().toString());
        binding.txtWeekDateWed.setText(MainActivity.global.selectedWeek.getDay("wed").getDate().toString());
        binding.txtWeekDateThu.setText(MainActivity.global.selectedWeek.getDay("thu").getDate().toString());
        binding.txtWeekDateFri.setText(MainActivity.global.selectedWeek.getDay("fri").getDate().toString());
        binding.txtWeekDateSat.setText(MainActivity.global.selectedWeek.getDay("sat").getDate().toString());



        //tab host week
        TabHost tabHostWeek = binding.tabHostWeek;

        setupDayTabs(tabHostWeek);

//=======================================================================
        //listeners:




        //fab new entry
        binding.fabNewEntry.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                DialogFragment entryDialog = NewEntryFragment.newInstance();
                entryDialog.show(getChildFragmentManager(), "newEntryFragment");

            }
        });





        return view;
    }


    public void setupDayTabs(TabHost tabHost)
    {
        tabHost.setup();

        //sun
        TabHost.TabSpec tabSpecsun = tabHost.newTabSpec("Sunday");
        tabSpecsun.setContent(binding.weekdaytab1.getId());
        tabSpecsun.setIndicator("Sun");

        tabHost.addTab(tabSpecsun);

        //mond
        TabHost.TabSpec tabSpecmon = tabHost.newTabSpec("Monday");
        tabSpecmon.setContent(binding.weekdaytab2.getId());
        tabSpecmon.setIndicator("Mon");

        tabHost.addTab(tabSpecmon);

        //tue
        TabHost.TabSpec tabSpectue = tabHost.newTabSpec("Tuesday");
        tabSpectue.setContent(binding.weekdaytab3.getId());
        tabSpectue.setIndicator("Tues");

        tabHost.addTab(tabSpectue);

        //wed
        TabHost.TabSpec tabSpecwed = tabHost.newTabSpec("Wednesday");
        tabSpecwed.setContent(binding.weekdaytab4.getId());
        tabSpecwed.setIndicator("Wed");

        tabHost.addTab(tabSpecwed);

        //thu
        TabHost.TabSpec tabSpecthu = tabHost.newTabSpec("Thursday");
        tabSpecthu.setContent(binding.weekdaytab5.getId());
        tabSpecthu.setIndicator("Thu");

        tabHost.addTab(tabSpecthu);

        //fri
        TabHost.TabSpec tabSpecfri = tabHost.newTabSpec("Friday");
        tabSpecfri.setContent(binding.weekdaytab6.getId());
        tabSpecfri.setIndicator("Fri");

        tabHost.addTab(tabSpecfri);

        //sat
        TabHost.TabSpec tabSpecsat = tabHost.newTabSpec("Saturday");
        tabSpecsat.setContent(binding.weekdaytab7.getId());
        tabSpecsat.setIndicator("Sat");

        tabHost.addTab(tabSpecsat);






        List<String> weekSelections = new ArrayList<String>();
        for(Week w : MainActivity.diary.getWeeks())
        {
            String ws = w.getWeekStartDate().toString().substring(5) + "  to  " + w.getWeekEndDate().toString().substring(5);

            if(w == MainActivity.diary.getCurrentWeek())
                ws += "  (current)";

            weekSelections.add(ws);
        }

        ArrayAdapter<String> weekSelectionsAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, weekSelections);
        binding.spnWeekSelection.setAdapter(weekSelectionsAdapter);


        binding.recycEntriesSunday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesMonday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesTuesday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesWednesday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesThursday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesFriday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesSaturday.setLayoutManager(new LinearLayoutManager(getContext()));
        //=======================================================================
        binding.recycEntriesSunday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDay("sun").getEntries(), getContext()));
        binding.recycEntriesMonday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDay("mon").getEntries(), getContext()));
        binding.recycEntriesTuesday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDay("tue").getEntries(), getContext()));
        binding.recycEntriesWednesday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDay("wed").getEntries(), getContext()));
        binding.recycEntriesThursday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDay("thu").getEntries(), getContext()));
        binding.recycEntriesFriday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDay("fri").getEntries(), getContext()));
        binding.recycEntriesSaturday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDay("sat").getEntries(), getContext()));



        tabHost.setCurrentTab(LocalDate.now().getDayOfWeek().getValue());

    }


    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}