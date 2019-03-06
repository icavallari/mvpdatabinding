package com.example.mvpdatabinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.mvpdatabinding.databinding.MainListItemBinding;

import java.util.List;

public class MainAdapter extends ArrayAdapter<MainModel> {

    private Context context;
    private List<MainModel> itens;

    public MainAdapter(Context context, List<MainModel> itens){
        super(context, R.layout.main_list_item);

        this.context = context;
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public MainModel getItem(int position) {
        return itens.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //LayoutInflater inflater = LayoutInflater.from(context);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        MainListItemBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.main_list_item, null, false);
        binding.setItem(getItem(position)); binding.executePendingBindings();
        return binding.getRoot();
    }

}
