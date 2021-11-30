package com.example.dbtasst2.ui.newEntry;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

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

    private NewEntryViewModel mViewModel;
    NewEntryFragmentBinding binding;

    public static NewEntryFragment newInstance()
    {
        return new NewEntryFragment();
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

        List<LinearLayout> tabList = new ArrayList<>();

        tabList.add((LinearLayout) binding.tabcontent.getChildAt(0));
        tabList.add((LinearLayout) binding.tabcontent.getChildAt(1));
        tabList.add((LinearLayout) binding.tabcontent.getChildAt(2));
        tabList.add((LinearLayout) binding.tabcontent.getChildAt(3));

        TabHost.TabSpec spec1 = tabHost.newTabSpec("HighestUrgeTo");
        spec1.setContent( binding.newEntrytab1.getId() );
        spec1

    }





}