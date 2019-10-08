package com.example.agendaitz.ui.activities;

import android.animation.Animator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.agendaitz.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivitiesFragment extends Fragment {

    private ActivitiesViewModel activitiesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        activitiesViewModel =
                ViewModelProviders.of(this).get(ActivitiesViewModel.class);
        View activitiView = inflater.inflate(R.layout.fragment_activities, container, false);
        final TextView textView = activitiView.findViewById(R.id.text_activites);

        final FloatingActionButton fabAddActiviti = activitiView.findViewById(R.id.fabddActiviti);

        fabAddActiviti.setScaleX(0);
        fabAddActiviti.setScaleY(0);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            final Interpolator interpolador = AnimationUtils.loadInterpolator(getContext(),
                    android.R.interpolator.fast_out_slow_in);

            fabAddActiviti.animate()
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

        fabAddActiviti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        activitiesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return activitiView;
    }

    private void openDialog(){
        ActivitiesDialog activitiesDialog = new ActivitiesDialog();
        activitiesDialog.show(getChildFragmentManager(), "Inserta Actividad");
    }
}