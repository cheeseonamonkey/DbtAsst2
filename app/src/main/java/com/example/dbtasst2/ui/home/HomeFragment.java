package com.example.dbtasst2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dbtasst2.MainActivity;
import com.example.dbtasst2.R;
import com.example.dbtasst2.databinding.FragmentHomeBinding;

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
            MainActivity.log.log(binding.tabcontent.getChildAt(i).toString());
        }




        //listeners:

        //tab host week
        TabHost tabHostWeek = binding.tabHostWeek;

        setupDayTabs(tabHostWeek);








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



    }


    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}