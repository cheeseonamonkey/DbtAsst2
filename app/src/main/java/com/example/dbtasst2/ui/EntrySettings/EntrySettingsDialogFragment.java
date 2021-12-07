package com.example.dbtasst2.ui.EntrySettings;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dbtasst2.MainActivity;
import com.example.dbtasst2.databinding.EntrySettingsFragmentBinding;
import com.example.dbtasst2.models.EntrySetting;
import com.example.dbtasst2.ui.adapters.EntrySettingsAdapter;

import java.util.List;

public class EntrySettingsDialogFragment extends DialogFragment
{

    private EntrySettingsViewModel mViewModel;
    EntrySettingsFragmentBinding binding;

    EntrySettingsAdapter entrySettingsAdapter;


    public static EntrySettingsDialogFragment newInstance()
    {
        return new EntrySettingsDialogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment:

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


        binding = EntrySettingsFragmentBinding.inflate(getLayoutInflater(), container,false);

        View view=binding.getRoot();
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        entrySettingsAdapter = new EntrySettingsAdapter(MainActivity.diary.getEntrySettings(), getContext());
        binding.recycEntrySettings.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recycEntrySettings.setAdapter(entrySettingsAdapter);

//=========
//LISTENERS:

        binding.btnEntrySettingsAccept.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {

                    MainActivity.diary.setEntrySettings(entrySettingsAdapter.getEntrySettings());

                    Toast.makeText(getContext(), "Entry settings set!", Toast.LENGTH_SHORT).show();

                }catch(Exception exc)
                {
                    Toast.makeText(getContext(), "error: " + exc.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.btnNewEntrySettings.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });



//=========




        return view;


    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EntrySettingsViewModel.class);
        // TODO: Use the ViewModel
    }

}