package com.example.dbtasst2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dbtasst2.MainActivity;
import com.example.dbtasst2.databinding.FragmentHomeBinding;
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

        binding.recycEntriesSunday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesMonday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesTuesday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesWednesday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesThursday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesFriday.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntriesSaturday.setLayoutManager(new LinearLayoutManager(getContext()));


        binding.recycEntriesSunday.setAdapter(new EntryAdapter(MainActivity.diary.getCurrentWeek().getDays().get(0).getEntries(), getContext()));
        binding.recycEntriesMonday.setAdapter(new EntryAdapter(MainActivity.diary.getCurrentWeek().getDays().get(1).getEntries(), getContext()));
        binding.recycEntriesTuesday.setAdapter(new EntryAdapter(MainActivity.diary.getCurrentWeek().getDays().get(2).getEntries(), getContext()));
        binding.recycEntriesWednesday.setAdapter(new EntryAdapter(MainActivity.diary.getCurrentWeek().getDays().get(3).getEntries(), getContext()));
        binding.recycEntriesThursday.setAdapter(new EntryAdapter(MainActivity.diary.getCurrentWeek().getDays().get(4).getEntries(), getContext()));
        binding.recycEntriesFriday.setAdapter(new EntryAdapter(MainActivity.diary.getCurrentWeek().getDays().get(5).getEntries(), getContext()));
        binding.recycEntriesSaturday.setAdapter(new EntryAdapter(MainActivity.diary.getCurrentWeek().getDays().get(6).getEntries(), getContext()));





    }


    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}