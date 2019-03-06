package com.example.mvpdatabinding;

public class MainPresenter {

    public interface View {
        void setModel(MainModel model);
        void message(String message);
    }

    private final View view;

    public MainPresenter(View view) {
        this.view = view;
    }

    public void start() {
        view.setModel(new MainModel("nome inicial", "sobrenome inicial"));
    }

    public void toast(MainModel model){
        view.message(model.getNome() + " - " + model.getSobrenome());
    }

}
