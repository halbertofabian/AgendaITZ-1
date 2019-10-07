package com.example.agendaitz.ui.places;

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
import com.example.agendaitz.ui.activities.ActivitiesDialog;

public class PlacesFragment extends Fragment {

    private PlacesViewModel placesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        placesViewModel =
                ViewModelProviders.of(this).get(PlacesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_places, container, false);
        final TextView textView = root.findViewById(R.id.text_places);

        Button addPlace = root.findViewById(R.id.buttonAddPlace);
        addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        placesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    public void openDialog(){
        PlacesDialog placesDialog = new PlacesDialog();
        placesDialog.show(getActivity().getSupportFragmentManager(), "Inserta Lugar");
    }
}