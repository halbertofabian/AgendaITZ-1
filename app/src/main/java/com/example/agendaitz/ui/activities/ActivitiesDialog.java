package com.example.agendaitz.ui.activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.agendaitz.R;
import com.example.agendaitz.ui.date.DatePickerFragment;

public class ActivitiesDialog extends AppCompatDialogFragment implements View.OnClickListener {
    private EditText dateIni, dateFin;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
            View activitesView = inflater.inflate(R.layout.activities_dialog, null);
            dateIni = activitesView.findViewById(R.id.editDateIni);
            dateFin = activitesView.findViewById(R.id.editDateFin);
            dateIni.setOnClickListener(this);
            dateFin.setOnClickListener(this);

        builder.setView(activitesView)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            ActivitiesDialogListener listener = (ActivitiesDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "Must Implements DialogActivitiesListeners");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.editDateIni:
                showDateIniPickerDialog();
                break;
            case R.id.editDateFin:
                showDateFinPickerDialog();
                    break;
        }
    }

    private void showDateIniPickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mont, int day){
                // +1 por que el mes enero es 0

                final String selectdDate = day + "/" + (mont + 1) +"/" + year;
                dateIni.setText(selectdDate);
            }
        });
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }

    private void showDateFinPickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mont, int day){
                // +1 por que el mes enero es 0

                final String selectdDate = day + "/" + (mont + 1) +"/" + year;
                dateFin.setText(selectdDate);
            }
        });
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onStart() {
        super.onStart();
        ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#314DFF"));
        ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#8430FF"));
    }

    public interface ActivitiesDialogListener{

    }
}
