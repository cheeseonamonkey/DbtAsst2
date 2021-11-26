package com.example.dbtasst2.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbtasst2.R;
import com.example.dbtasst2.models.Entry;
import com.example.dbtasst2.models.EntryItem;

import java.util.ArrayList;
import java.util.List;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.ViewHolder>
{
    List<Entry> entryList;
    Context context;

    public EntryAdapter(List entryList, Context context)
    {
        this.entryList = entryList;

        entryList = new ArrayList<>();

        context = context;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //inflates layout on a new view
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_tab_card_layout, parent,false);

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


        holder.txtEntryReason.setText(entryList.get(pos).getReason().toString());
        holder.txtEntryTime.setText(entryList.get(pos).getCreationTime().toString());


        //each entry item
        List<EntryItem> entryItems = entryList.get(pos).getItems();

        String entryVals = "";
        for(EntryItem ei : entryItems)
        {
            entryVals += ei.getValue() + "/";
        }

        holder.txtEntryValues.setText(entryVals);

    }




    @Override
    public int getItemCount()
    {
        return entryList.size();
    }


    //view holder
    class ViewHolder extends RecyclerView.ViewHolder
    {
        //takes the container and gets to know all of the child views

        TextView txtEntryReason;
        TextView txtEntryTime;
        
        TextView txtEntryValues;

        LinearLayout linEntryValues;



        public ViewHolder(@NonNull View view)
        {
            super(view);


            this.setIsRecyclable(false);

            txtEntryReason = view.findViewById(R.id.txtEntryReason);
            txtEntryTime = view.findViewById(R.id.txtEntryTime);
            txtEntryValues = view.findViewById(R.id.txtEntryValues);
            
            Button btnViewEntry = view.findViewById(R.id.btnViewEntry);

            linEntryValues = view.findViewById(R.id.linEntryValues);

           // entryValuesSetup();

        }


        public void entryValuesSetup()
        {
            //each entry item
            List<EntryItem> entryItems = entryList.get(getAdapterPosition()).getItems();

            // MainActivity.log.log(Integer.toString( entryItems.size()) );

            txtEntryValues.setText("");

            

        }
    }


}
