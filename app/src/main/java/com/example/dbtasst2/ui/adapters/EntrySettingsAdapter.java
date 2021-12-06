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
    Context context;

    public EntrySettingsAdapter(List<EntrySetting> entrySettingList, Context context)
    {
        this.entrySettingList = entrySettingList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //inflates layout on a new view
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.entrysettingviewholder, parent,false);

        //turns it to the ViewHolder class we defined at the bottom
        ViewHolder viewHolder = new ViewHolder(listItemView);



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

        if(setting.getType().equals(EntryItem.Type.RATING))
        {
            holder.rdbRating.setChecked(true);
            holder.rdbYesNo.setChecked(false);
        }else if(setting.getType().equals(EntryItem.Type.YESNO))
        {
            holder.rdbRating.setChecked(false);
            holder.rdbYesNo.setChecked(true);
        }



    }

    @Override
    public int getItemCount()
    {
        return entrySettingList.size();
    }


    public List<EntrySetting> getEntrySettings()
    {
        return new ArrayList<>();
    }


    class ViewHolder extends RecyclerView.ViewHolder
    {

        EditText txtEntrySettingName;

        RadioGroup rdbGrpType;
        RadioButton rdbYesNo;
        RadioButton rdbRating;

        ImageButton btnDelete;



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



        }
    }

}
