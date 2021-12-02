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
            tabList.add((LinearLayout) binding.tabcontent.getChildAt(i));
          //  MainActivity.log.log(binding.tabcontent.getChildAt(i).toString());
        }



//=======================================================================
        //listeners:

        //tab host week
        TabHost tabHostWeek = binding.tabHostWeek;

        setupDayTabs(tabHostWeek);


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

        for (int d = 1; d < DayOfWeek.values().length; d++)
        {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(DayOfWeek.of(d).name());
            tabSpec.setContent(tabList.get(d-1).getId());
            tabSpec.setIndicator(DayOfWeek.of(d).name().substring(0,3));

            tabHost.addTab(tabSpec);

        }

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

        binding.txtWeekDateMonday.setText(MainActivity.global.selectedWeek.getDays().get(0).getDate().toString());
        binding.txtWeekDateTuesday.setText(MainActivity.global.selectedWeek.getDays().get(1).getDate().toString());
        binding.txtWeekDateWednesday.setText(MainActivity.global.selectedWeek.getDays().get(2).getDate().toString());
        binding.txtWeekDateThursday.setText(MainActivity.global.selectedWeek.getDays().get(3).getDate().toString());
        binding.txtWeekDateFriday.setText(MainActivity.global.selectedWeek.getDays().get(4).getDate().toString());
        binding.txtWeekDateSaturday.setText(MainActivity.global.selectedWeek.getDays().get(5).getDate().toString());
        binding.txtWeekDateSunday.setText(MainActivity.global.selectedWeek.getDays().get(6).getDate().toString());


        binding.recycEntriesSunday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesMonday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesTuesday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesWednesday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesThursday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesFriday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesSaturday.setLayoutManager(new LinearLayoutManager(getContext()));
        //=======================================================================
        binding.recycEntriesSunday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDays().get(0).getEntries(), getContext()));
        binding.recycEntriesMonday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDays().get(1).getEntries(), getContext()));
        binding.recycEntriesTuesday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDays().get(2).getEntries(), getContext()));
        binding.recycEntriesWednesday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDays().get(3).getEntries(), getContext()));
        binding.recycEntriesThursday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDays().get(4).getEntries(), getContext()));
        binding.recycEntriesFriday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDays().get(5).getEntries(), getContext()));
        binding.recycEntriesSaturday.setAdapter(new EntryAdapter(MainActivity.global.selectedWeek.getDays().get(6).getEntries(), getContext()));





    }


    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}