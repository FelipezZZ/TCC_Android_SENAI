package com.example.anamnese;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.AdapterView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Integer> mViewColors;
    private List<String> mAnimals;
    private LayoutInflater mInflater;
    private AdapterView.OnItemClickListener mClickListener

    MyRecyclerViewAdapter(Context context, List<Integer> colors, List<String> animals) {
        this.mInflater = LayoutInflater.from(context);
        this.mViewColors = colors;
        this.mAnimals = animals;
    }

}
