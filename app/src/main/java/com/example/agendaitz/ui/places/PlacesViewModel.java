package com.example.agendaitz.ui.places;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlacesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlacesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Lugares");
    }

    public LiveData<String> getText() {
        return mText;
    }
}