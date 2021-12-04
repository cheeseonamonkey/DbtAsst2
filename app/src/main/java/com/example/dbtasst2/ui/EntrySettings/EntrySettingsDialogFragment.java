package com.example.dbtasst2.ui.EntrySettings;

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
import android.widget.TextView;

import com.example.dbtasst2.MainActivity;
import com.example.dbtasst2.databinding.EntrySettingsFragmentBinding;
import com.example.dbtasst2.models.EntrySetting;

import java.util.List;

public class EntrySettingsDialogFragment extends DialogFragment
{

    private EntrySettingsViewModel mViewModel;
    EntrySettingsFragmentBinding binding;

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

//=========
//LISTENERS:

        LinearLayout linRoot = binding.linEntrySettingsRoot;



//=========

        drawExistingEntrySettings(linRoot, MainActivity.diary.getEntrySettings());


        return view;


    }

    public void drawExistingEntrySettings(LinearLayout linRoot, List<EntrySetting> entrySettings)
    {
        for (int i = 0; i < entrySettings.size() - 1; i++)
        {
            LinearLayout linHolder = new LinearLayout(getContext());

            //linHolder
            LinearLayout.LayoutParams linHolderlayoutParams  = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            linHolder.setOrientation(LinearLayout.HORIZONTAL);

            //  linHolder.setBackgroundColor(Color.BLUE); //color for debug

            linHolder.setLayoutParams(linHolderlayoutParams);


            //txtName
            TextView txtName = new TextView(getContext());

            LinearLayout.LayoutParams txtNamelayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            //txtName.setMinWidth();

            txtName.setTextSize(18f);
            txtName.setText(entrySettings.get(i).getName());

            txtName.setLayoutParams(txtNamelayoutParams);


        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EntrySettingsViewModel.class);
        // TODO: Use the ViewModel
    }

}