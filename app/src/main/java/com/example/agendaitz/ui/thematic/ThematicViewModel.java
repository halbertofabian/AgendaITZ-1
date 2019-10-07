package com.example.agendaitz.ui.thematic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ThematicViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ThematicViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("Tematica");
    }

    public LiveData<String> getText(){return mText;}
}
