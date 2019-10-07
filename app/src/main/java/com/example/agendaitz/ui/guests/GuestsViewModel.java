package com.example.agendaitz.ui.guests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GuestsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GuestsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Invitados");
    }

    public LiveData<String> getText() {
        return mText;
    }
}