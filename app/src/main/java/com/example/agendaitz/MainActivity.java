package com.example.agendaitz;

import android.os.Bundle;

import com.example.agendaitz.ui.activities.ActivitiesDialog;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.agendaitz.ui.events.EventsDialog;
import com.example.agendaitz.ui.guests.GuestsDialog;
import com.example.agendaitz.ui.persons.PersonDialog;
import com.example.agendaitz.ui.places.PlacesDialog;
import com.example.agendaitz.ui.thematic.ThematicDialog;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity implements ActivitiesDialog.ActivitiesDialogListener,
        EventsDialog.DialogEventsListener, GuestsDialog.GuestsDialogListener, PlacesDialog.PlacesDialogListener,
        PersonDialog.PersonDialogListener, ThematicDialog.ThematicDialogListener {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_activities, R.id.nav_places,
                R.id.nav_guests, R.id.nav_events, R.id.nav_persons,
                R.id.nav_thematic)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void applyTexts(String edit_user) {

    }
}
