package com.example.anamnese;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private ArrayList<Integer> mNumeros = new ArrayList<>();
    private Context mContext;
    private OnNoteListenner mOneOnNoteListenner;

    public RecyclerViewAdapter(Context context, ArrayList<Integer> numeros, OnNoteListenner onNoteListenner) {
        mNumeros = numeros;
        mContext = context;
        this.mOneOnNoteListenner = onNoteListenner;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(view, mOneOnNoteListenner);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mNumeros.get(position));

        holder.rvText.setText(String.valueOf(mNumeros.get(position)));
    }

    @Override
    public int getItemCount() {
        return mNumeros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView rvText;
        OnNoteListenner onNoteListenner;

        public ViewHolder(View itemView, OnNoteListenner onNoteListenner) {
            super(itemView);
            rvText = itemView.findViewById(R.id.rvText);
            this.onNoteListenner = onNoteListenner;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListenner.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListenner{
        void onNoteClick(int position);
    }
}
