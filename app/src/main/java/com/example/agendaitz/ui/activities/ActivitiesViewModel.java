package com.example.agendaitz.ui.activities;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ActivitiesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ActivitiesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Actividades");
    }

    public LiveData<String> getText() {
        return mText;
    }
}