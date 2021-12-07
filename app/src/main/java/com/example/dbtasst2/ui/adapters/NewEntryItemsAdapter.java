package com.example.dbtasst2.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbtasst2.R;
import com.example.dbtasst2.models.Entry;
import com.example.dbtasst2.models.EntryItem;
import com.example.dbtasst2.models.EntrySetting;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NewEntryItemsAdapter extends RecyclerView.Adapter<NewEntryItemsAdapter.ViewHolder>
{

    Context context;
    List<EntrySetting> items;
    List<NewEntryItemsAdapter.ViewHolder> holders;

    public NewEntryItemsAdapter(List<EntrySetting> items, Context context)
    {
        this.items = items;
        this.context = context;

        holders = new ArrayList<>();
    }

    public List<EntryItem> getEntryItems()
    {
        List<EntryItem> entryItemListOut = new ArrayList<>();

        for (int i = 0; i < items.size() - 1; i++)
        {
            entryItemListOut.add(holders.get(i).getEntryitem());
        }

        return entryItemListOut;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //inflates layout on a new view
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.entry_item_card, parent,false);

        //turns it to the ViewHolder class we defined at the bottom
        NewEntryItemsAdapter.ViewHolder viewHolder = new NewEntryItemsAdapter.ViewHolder(listItemView);

        holders.add(viewHolder);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        //a parameter is the ViewHolder class that we made below, and has all the fields of the card

        int pos = position;


        //do stuff to holder:

        holder.txtName.setText(items.get(pos).getName());

        List<String> ratingType = new ArrayList<String>();
        ratingType.add("0");
        ratingType.add("1");
        ratingType.add("2");
        ratingType.add("3");
        ratingType.add("4");
        ratingType.add("5");
        List<String> boolType = new ArrayList<String>();
        boolType.add("Yes");
        boolType.add("No");

        ArrayAdapter<String> typeArrayAdapter;

        if(items.get(pos).getType().equals(EntryItem.Type.RATING))
        {
            holder.type = EntryItem.Type.RATING;
            typeArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, ratingType);
        }else
        {
            holder.type = EntryItem.Type.YESNO;
            typeArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, boolType);
        }

        holder.spnValue.setAdapter(typeArrayAdapter);

    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        EntryItem.Type type;
        EntryItem.Value value;

        TextView txtName;
        Spinner spnValue;

        public ViewHolder(@NonNull View view)
        {
            super(view);

            txtName = view.findViewById(R.id.txtEntryItemName);
            spnValue = view.findViewById(R.id.spnEntryItemValue);


        }

        public EntryItem getEntryitem()
        {
            if(type.equals(EntryItem.Type.YESNO))
            {
                if(spnValue.getSelectedItem().toString().toLowerCase(Locale.ROOT) == "yes")
                    value = EntryItem.Value.YES;
                else
                    value = EntryItem.Value.NO;

            }else
            {
                int intVal = Integer.parseInt(spnValue.getSelectedItem().toString());
                switch(intVal)
                {
                    case 0:
                        value = EntryItem.Value._0;
                        break;
                    case 1:
                        value = EntryItem.Value._1;
                        break;
                    case 2:
                        value = EntryItem.Value._2;
                        break;
                    case 3:
                        value = EntryItem.Value._3;
                        break;
                    case 4:
                        value = EntryItem.Value._4;
                        break;
                    case 5:
                        value = EntryItem.Value._5;
                        break;
                    default:
                        value =  EntryItem.Value._5;
                    break;
                }
            }

            EntryItem itemOut = new EntryItem(txtName.getText().toString(), value, type, EntryItem.Section.OTHERS);
            return itemOut;

        }

    }

}
