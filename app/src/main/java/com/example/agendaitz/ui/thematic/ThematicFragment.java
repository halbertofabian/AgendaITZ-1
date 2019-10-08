package com.example.agendaitz.ui.thematic;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.animation.Animator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.agendaitz.R;
import com.example.agendaitz.ui.places.PlacesDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ThematicFragment extends Fragment {

    private ThematicViewModel thematicViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        thematicViewModel =
                ViewModelProviders.of(this).get(ThematicViewModel.class);
        View thematicView = inflater.inflate(R.layout.fragment_thematic, container, false);
        final TextView textView = thematicView.findViewById(R.id.text_thematic);

        final FloatingActionButton fabAddThematic = thematicView.findViewById(R.id.fabAddThematic);

        fabAddThematic.setScaleX(0);
        fabAddThematic.setScaleY(0);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            final Interpolator interpolador = AnimationUtils.loadInterpolator(getContext(),
                    android.R.interpolator.fast_out_slow_in);

            fabAddThematic.animate()
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

        fabAddThematic.setOnClickListener(new View.OnClickListener() {
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

    private void openDialog(){
        ThematicDialog thematicDialog = new ThematicDialog();
        thematicDialog.show(getChildFragmentManager(), "Inserta Lugar");
    }
}
