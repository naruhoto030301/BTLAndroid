package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Definitions;
import com.example.myapplication.R;
import com.example.myapplication.ViewHolders.DefinitionViewHolder;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {
    private Context context;
    private List<Definitions> difinitionsList;

    public DefinitionAdapter(Context context, List<Definitions> definitions) {
        this.context = context;
        this.difinitionsList = definitions;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.definitions_list_items, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        holder.textView_definotion.setText("Definition:" + difinitionsList.get(position).getDefinition());
        holder.textView_example.setText("Example:" + difinitionsList.get(position).getExample());
        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(difinitionsList.get(position).getSynonyms());
        antonyms.append(difinitionsList.get(position).getAntonyms());

        holder.textView_synonyms.setText(synonyms);
        holder.textView_antonyms.setText(antonyms);

        holder.textView_synonyms.setSelected(true);
        holder.textView_antonyms.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return difinitionsList.size();
    }
}
