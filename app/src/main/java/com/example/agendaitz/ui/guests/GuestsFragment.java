package com.example.agendaitz.ui.guests;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.agendaitz.MainActivity;
import com.example.agendaitz.R;
import com.example.agendaitz.ui.activities.ActivitiesDialog;

public class GuestsFragment extends Fragment {

    private GuestsViewModel guestsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        guestsViewModel =
                ViewModelProviders.of(this).get(GuestsViewModel.class);
        View addGuests = inflater.inflate(R.layout.fragment_guests, container, false);
        final TextView textView = addGuests.findViewById(R.id.text_guests);

        Button addGuest = addGuests.findViewById(R.id.button_addInvitado);
        addGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        guestsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return addGuests;
    }

    public void openDialog(){
        GuestsDialog guestsDialog = new GuestsDialog();
        guestsDialog.show(getActivity().getSupportFragmentManager(), null);
    }
}