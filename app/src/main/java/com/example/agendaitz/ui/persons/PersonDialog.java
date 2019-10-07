package com.example.agendaitz.ui.persons;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.agendaitz.R;
import com.example.agendaitz.ui.date.DatePickerFragment;

public class PersonDialog extends AppCompatDialogFragment implements View.OnClickListener {

    private EditText personBornDate;
    private PersonDialog.PersonDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View guestView = inflater.inflate(R.layout.person_dialog, null);
        personBornDate = guestView.findViewById(R.id.editPersonBornDate);
        personBornDate.setOnClickListener(this);


        builder.setView(guestView)
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
            listener = (PersonDialog.PersonDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "Must be Implements GuetsDialogListener");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.editPersonBornDate:
                showDatePickerDialog();
                break;
        }
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mont, int day){
                // +1 por que el mes enero es 0

                final String selectdDate = day + "/" + (mont + 1) +"/" + year;
                personBornDate.setText(selectdDate);
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

    public interface PersonDialogListener{

    }
}
