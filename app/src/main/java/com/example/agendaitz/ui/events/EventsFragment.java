package com.example.agendaitz.ui.events;

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

public class EventsFragment extends Fragment{

    private EventsViewModel eventsViewModel;
    private Button agregarEvent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        eventsViewModel =
                ViewModelProviders.of(this).get(EventsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_events, container, false);
        final TextView textView = root.findViewById(R.id.text_events);

        agregarEvent = root.findViewById(R.id.button_addEvento);
        agregarEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        eventsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    public void openDialog(){
        EventsDialog eventsDialog = new EventsDialog();
        eventsDialog.show((getActivity().getSupportFragmentManager()), "Inserta Evento");
    }
}