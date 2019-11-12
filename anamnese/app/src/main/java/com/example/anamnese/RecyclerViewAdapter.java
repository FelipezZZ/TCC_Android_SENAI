package com.example.anamnese;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private ArrayList<String> mNumeros = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> numeros) {
        mNumeros = numeros;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mNumeros.get(position));

        holder.rvButton.setText(mNumeros.get(position));

    }

    @Override
    public int getItemCount() {
        return mNumeros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        Button rvButton;

        public ViewHolder(View itemView) {
            super(itemView);
            rvButton = itemView.findViewById(R.id.rvButton);
        }
    }
}
