package com.example.agendaitz.ui.persons;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PersonsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Personas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}