package com.example.dbtasst2.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbtasst2.R;
import com.example.dbtasst2.models.Entry;
import com.example.dbtasst2.models.EntryItem;
import com.example.dbtasst2.models.EntrySetting;

import java.util.ArrayList;
import java.util.List;


public class EntrySettingsAdapter extends RecyclerView.Adapter<EntrySettingsAdapter.ViewHolder>
{

    List<EntrySetting> entrySettingList;
    List<ViewHolder> holders;
    Context context;

    public EntrySettingsAdapter(List<EntrySetting> entrySettingList, Context context)
    {
        this.entrySettingList = entrySettingList;
        this.context = context;

        holders = new ArrayList<>();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //inflates layout on a new view
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.entrysettingviewholder, parent,false);

        //turns it to the ViewHolder class we defined at the bottom
        ViewHolder viewHolder = new ViewHolder(listItemView);

        holders.add(viewHolder);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
//a parameter is the ViewHolder class that we made below, and has all the fields of the card

        int pos = position;


        //do stuff to holder:

        EntrySetting setting = entrySettingList.get(pos);

        holder.txtEntrySettingName.setText(setting.getName());


        if(setting.getType().toString() == EntryItem.Type.RATING.toString())
        {
            holder.rdbGrpType.clearCheck();
            holder.rdbGrpType.check(R.id.rdbEntrySettingNumericalRating);
        }else if(setting.getType().toString() == EntryItem.Type.YESNO.toString())
        {
            holder.rdbGrpType.clearCheck();
            holder.rdbGrpType.check(R.id.rdbEntrySettingYesNo);
        }



    }

    @Override
    public int getItemCount()
    {
        return entrySettingList.size();
    }


    public List<EntrySetting> getEntrySettings()
    {
        List<EntrySetting> entrySettings = new ArrayList<>();

        int count = this.getItemCount();

        for (int i = 0; i < count - 1; i++)
        {
            entrySettings.add(holders.get(i).getNewEntrySetting());
        }

        return entrySettings;
    }


    class ViewHolder extends RecyclerView.ViewHolder
    {

        EditText txtEntrySettingName;

        RadioGroup rdbGrpType;
        RadioButton rdbYesNo;
        RadioButton rdbRating;

        ImageButton btnDelete;


        public EntrySetting getNewEntrySetting()
        {
            String name = txtEntrySettingName.getText().toString();

            EntryItem.Type type = EntryItem.Type.RATING;

            if(rdbYesNo.isChecked())
                type = EntryItem.Type.YESNO;
            else if(rdbRating.isChecked())
                type = EntryItem.Type.RATING;

            return new EntrySetting(name, type);
        }

        public ViewHolder(@NonNull View view)
        {
            super(view);



            this.setIsRecyclable(false);

            txtEntrySettingName = view.findViewById(R.id.txtEntrySettingName);

            rdbGrpType = view.findViewById(R.id.rdbGrpEntrySettingsTypeGroup);
            rdbYesNo = view.findViewById(R.id.rdbEntrySettingYesNo);
            rdbRating = view.findViewById(R.id.rdbEntrySettingNumericalRating);

            btnDelete = view.findViewById(R.id.btnEntrySettingDelete);


            //listeners:
            btnDelete.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {

                }
            });


        }
    }

}
