package com.example.mvpdatabinding;

import java.util.List;

public class MainBindingAdapter extends BaseBindingAdapter {

    private final List<MainModel> itens;

    public MainBindingAdapter(List<MainModel> itens) {
        this.itens = itens;
    }

    @Override
    public Object getDataAtPosition(int position) {
        return itens.get(position);
    }

    @Override
    public int getLayoutIdForType() {
        return R.layout.main_list_item;
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
