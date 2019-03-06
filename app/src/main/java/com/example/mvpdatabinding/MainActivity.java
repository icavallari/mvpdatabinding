package com.example.mvpdatabinding;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mvpdatabinding.databinding.MainActivityBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.View{

    private Toast toast;
    private MainPresenter presenter;
    private MainActivityBinding binding;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main_activity);

        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        presenter = new MainPresenter(this);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        binding.setPresenter(presenter);
        presenter.start();

        //listView = findViewById(R.id.listView);
        //listView.setAdapter(new MainAdapter(this, getItens()));

        RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MainBindingAdapter(getItens()));

        LinearLayoutManager ls = new LinearLayoutManager(this);
        ls.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(ls);
    }

    @Override
    public void setModel(MainModel model) {
        binding.setModel(model);
    }

    @Override
    public void message(String message) {
        toast.setText(message);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        binding.unbind();
        super.onDestroy();
    }

    private List<MainModel> getItens(){
        return Arrays.asList(new MainModel("rodrigo", "cavallari"),
                new MainModel("andre", "luis cavallari"),
                new MainModel("ivanilda", "aparecida cavallari"),
                new MainModel("luiz", "antonio"),
                new MainModel("andressa", "reis"),
                new MainModel("Milena", "Faria"),
                new MainModel("Magine", "regiane"));
    }

}
