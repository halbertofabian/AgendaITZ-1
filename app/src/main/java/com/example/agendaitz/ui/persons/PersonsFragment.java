package com.example.agendaitz.ui.persons;

import android.animation.Animator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.agendaitz.R;
import com.example.agendaitz.ui.guests.GuestsDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PersonsFragment extends Fragment {

    private PersonsViewModel personsViewModel;
    private Button addPerson;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        personsViewModel =
                ViewModelProviders.of(this).get(PersonsViewModel.class);
        View personView = inflater.inflate(R.layout.fragment_persons, container, false);
        final TextView textView = personView.findViewById(R.id.text_persons);

        final FloatingActionButton fabAddPerson = personView.findViewById(R.id.fabAddPerson);

        fabAddPerson.setScaleX(0);
        fabAddPerson.setScaleY(0);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            final Interpolator interpolador = AnimationUtils.loadInterpolator(getContext(),
                    android.R.interpolator.fast_out_slow_in);

            fabAddPerson.animate()
                    .scaleX(1)
                    .scaleY(1)
                    .setInterpolator(interpolador)
                    .setDuration(600)
                    .setStartDelay(1000)
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
        }

        fabAddPerson.setOnClickListener(new View.OnClickListener() {
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

    private void openDialog(){
        PersonDialog personDialog = new PersonDialog();
        personDialog.show(getChildFragmentManager(), null);
    }
}