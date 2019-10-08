package com.example.agendaitz.ui.guests;

import android.animation.Animator;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GuestsFragment extends Fragment {

    private GuestsViewModel guestsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        guestsViewModel =
                ViewModelProviders.of(this).get(GuestsViewModel.class);
        View guestsView = inflater.inflate(R.layout.fragment_guests, container, false);
        final TextView textView = guestsView.findViewById(R.id.text_guests);

        final FloatingActionButton fabAddGuest = guestsView.findViewById(R.id.fabAddGuest);

        fabAddGuest.setScaleX(0);
        fabAddGuest.setScaleY(0);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            final Interpolator interpolador = AnimationUtils.loadInterpolator(getContext(),
                    android.R.interpolator.fast_out_slow_in);

            fabAddGuest.animate()
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

        fabAddGuest.setOnClickListener(new View.OnClickListener() {
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
        return guestsView;
    }

    private void openDialog(){
        GuestsDialog guestsDialog = new GuestsDialog();
        guestsDialog.show(getChildFragmentManager(), null);
    }
}