package com.example.agendaitz.ui.persons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.agendaitz.R;
import com.example.agendaitz.ui.guests.GuestsDialog;

public class PersonsFragment extends Fragment {

    private PersonsViewModel personsViewModel;
    private Button addPerson;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        personsViewModel =
                ViewModelProviders.of(this).get(PersonsViewModel.class);
        View personView = inflater.inflate(R.layout.fragment_persons, container, false);
        final TextView textView = personView.findViewById(R.id.text_persons);

        addPerson = personView.findViewById(R.id.button_addPerson);
        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        personsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return personView;
    }

    public void openDialog(){
        PersonDialog personDialog = new PersonDialog();
        personDialog.show(getActivity().getSupportFragmentManager(), null);
    }
}