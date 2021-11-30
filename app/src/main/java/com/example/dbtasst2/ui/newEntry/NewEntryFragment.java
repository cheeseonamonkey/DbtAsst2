package com.example.dbtasst2.ui.newEntry;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.example.dbtasst2.R;
import com.example.dbtasst2.databinding.NewEntryFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class NewEntryFragment extends DialogFragment
{

    //this could all be optimized better for future development but I'm hard-coding each section to get a release out quickly

    private NewEntryViewModel mViewModel;
    NewEntryFragmentBinding binding;

    public static NewEntryFragment newInstance()
    {
        NewEntryFragment newFrag = new NewEntryFragment();
        return newFrag;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        binding = NewEntryFragmentBinding.inflate(getLayoutInflater(), container,false);

        View view=binding.getRoot();

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++







//=========
//LISTENERS:




//=========



setupEntryTabs(binding.tabHostNewEntry);

return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NewEntryViewModel.class);
        // TODO: Use the ViewModel
    }

    public void setupEntryTabs(TabHost tabHost)
    {
        tabHost.setup();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("HighestUrgeTo");
        spec1.setContent( binding.newEntrytab1.getId() );
        spec1.setIndicator("Highest urge to");

        TabHost.TabSpec spec2 = tabHost.newTabSpec("HighestRating");
        spec2.setContent( binding.newEntrytab2.getId() );
        spec2.setIndicator("Highest rating");

        TabHost.TabSpec spec3 = tabHost.newTabSpec("HighestUrgeTo");
        spec3.setContent( binding.newEntrytab3.getId() );
        spec3.setIndicator("Emotions");

        TabHost.TabSpec spec4 = tabHost.newTabSpec("HighestUrgeTo");
        spec4.setContent( binding.newEntrytab4.getId() );
        spec4.setIndicator("Other");

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);
        tabHost.addTab(spec4);

    }





}