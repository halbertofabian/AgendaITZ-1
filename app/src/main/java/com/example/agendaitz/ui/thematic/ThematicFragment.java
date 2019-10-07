package com.example.agendaitz.ui.thematic;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.agendaitz.R;
import com.example.agendaitz.ui.places.PlacesDialog;

public class ThematicFragment extends Fragment {

    private ThematicViewModel thematicViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        thematicViewModel =
                ViewModelProviders.of(this).get(ThematicViewModel.class);
        View thematicView = inflater.inflate(R.layout.fragment_thematic, container, false);
        final TextView textView = thematicView.findViewById(R.id.text_thematic);

        Button addThematic = thematicView.findViewById(R.id.button_addThematic);
        addThematic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        thematicViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return thematicView;
    }

    public void openDialog(){
        ThematicDialog thematicDialog = new ThematicDialog();
        thematicDialog.show(getActivity().getSupportFragmentManager(), "Inserta Lugar");
    }
}
