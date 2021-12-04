package com.example.dbtasst2;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dbtasst2.databinding.SettingsFragmentBinding;
import com.example.dbtasst2.ui.EntrySettings.EntrySettingsDialogFragment;
import com.example.dbtasst2.ui.newEntry.NewEntryFragment;

public class SettingsFragment extends Fragment
{


   private SettingsViewModel mViewModel;

   SettingsFragmentBinding binding;

    public static SettingsFragment newInstance()
    {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment:
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        binding = SettingsFragmentBinding.inflate(getLayoutInflater(), container,false);

        View view=binding.getRoot();
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//=========
//LISTENERS:

        binding.btnSampleData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                MainActivity.diary.setSampleData();

                Toast.makeText(getContext(), "sample data set", Toast.LENGTH_SHORT).show();
            }
        });


        binding.btnSetEntriesSettings.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // entry settings
                EntrySettingsDialogFragment entrySettingsDialog = EntrySettingsDialogFragment.newInstance();
                entrySettingsDialog.show(getChildFragmentManager(), "newEntryFragment");
            }
        });
//=========



return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        // TODO: Use the ViewModel
    }

}