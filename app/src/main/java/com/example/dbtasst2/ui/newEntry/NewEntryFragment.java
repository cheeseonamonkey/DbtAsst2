package com.example.dbtasst2.ui.newEntry;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TabHost;

import com.example.dbtasst2.MainActivity;
import com.example.dbtasst2.databinding.NewEntryFragmentBinding;
import com.example.dbtasst2.models.Entry;
import com.example.dbtasst2.models.EntryItem;

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

        List<Entry.Reason> reasons = new ArrayList<Entry.Reason>();

        reasons.add(Entry.Reason.MORNING);
        reasons.add(Entry.Reason.MIDDAY);
        reasons.add(Entry.Reason.EVENING);
        reasons.add(Entry.Reason.NIGHTTIME);
        reasons.add(Entry.Reason.OTHER);

        ArrayAdapter<Entry.Reason> reasonArrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, reasons);
        binding.spnReason.setAdapter(reasonArrayAdapter);





//=========
//LISTENERS:

    binding.btnNewEntryNext1.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            binding.tabHostNewEntry.setCurrentTab(1);
        }
    });

        binding.btnNewEntryNext2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                binding.tabHostNewEntry.setCurrentTab(2);
            }
        });

        binding.btnNewEntryNext3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                binding.tabHostNewEntry.setCurrentTab(3);
            }
        });


        binding.btnNewEntryOkay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {


                Entry.Reason reason;

                String strReason = binding.spnReason.getSelectedItem().toString();
                switch(strReason)
                {
                    case "MORNING": reason = Entry.Reason.MORNING;
                        break;
                    case "MIDDAY": reason = Entry.Reason.MIDDAY;
                        break;
                    case "EVENING": reason = Entry.Reason.EVENING;
                        break;
                    case "NIGHTTIME": reason = Entry.Reason.NIGHTTIME;
                        break;
                    case "OTHER": reason = Entry.Reason.OTHER;
                        break;
                    default: reason = Entry.Reason.OTHER;
                        break;
                }


                int kms = Integer.parseInt(binding.spnKms.getSelectedItem().toString());
                int quit = Integer.parseInt(binding.spnQuitTherapy.getSelectedItem().toString());
                int hms = Integer.parseInt(binding.spnHms.getSelectedItem().toString());

                int emoMisery = Integer.parseInt(binding.spnEmotionalMisery.getSelectedItem().toString());
                int physMisery = Integer.parseInt(binding.spnPhysicalMisery.getSelectedItem().toString());

                int anger = Integer.parseInt(binding.spnAnger.getSelectedItem().toString());
                int worry = Integer.parseInt(binding.spnWorry.getSelectedItem().toString());
                int shame = Integer.parseInt(binding.spnShame.getSelectedItem().toString());
                int sad = Integer.parseInt(binding.spnSadness.getSelectedItem().toString());
                int happy = Integer.parseInt(binding.spnHappiness.getSelectedItem().toString());

                //todo:
                //custom and boolean entryItems


                MainActivity.diary.getCurrentWeek().getToday().addEntry(reason)
                        .addItem("Kill myself", kms, EntryItem.Section.HIGHEST_URGE_TO)
                        .addItem("Quit therapy", quit, EntryItem.Section.HIGHEST_URGE_TO)
                        .addItem("Hurt myself", hms, EntryItem.Section.HIGHEST_URGE_TO)

                        .addItem("Emotional misery", emoMisery, EntryItem.Section.HIGHEST_RATING)
                        .addItem("Physical misery", physMisery, EntryItem.Section.HIGHEST_RATING)

                        .addItem("Anger", anger, EntryItem.Section.EMOTIONS)
                        .addItem("Worry", worry, EntryItem.Section.EMOTIONS)
                        .addItem("Shame", shame, EntryItem.Section.EMOTIONS)
                        .addItem("Sadness", sad, EntryItem.Section.EMOTIONS)
                        .addItem("Happiness", happy, EntryItem.Section.EMOTIONS);

                        //todo: custom and bool
                        //=======================================================================
                        //=======================================================================



               // MainActivity.log.log("creating entry on " + MainActivity.diary.getCurrentWeek().getToday().getDate().toString(), "entry");



                //close the dialog
                dismiss();

            }
        });


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