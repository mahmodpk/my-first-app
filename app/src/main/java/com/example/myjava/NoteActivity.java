package com.example.myjava;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class NoteActivity extends AppCompatActivity {

    Toolbar toolbar2;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        navigationView = findViewById(R.id.navigation_view);
        DrawerLayout drawerLayout = findViewById(R.id.drawer);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(NoteActivity.this,drawerLayout,toolbar2,R.string.open,R.string.closee);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.exit_to_app_item:
                        //finishAffinity();
                        AlertDialog.Builder alert= new AlertDialog.Builder(NoteActivity.this);

                        alert.setTitle(getString(R.string.exit_to_app_item));
                        alert.setMessage(getString(R.string.message_text));
                        alert.setIcon(R.drawable.ic_baseline_exit_to_app_24);

                        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishAffinity();
                            }
                        });

                        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        alert.show();

                        break;
                }
                return false;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        
        switch (item.getItemId()) {
            case R.id.hello:
                Intent intent_call = new Intent(Intent.ACTION_VIEW , Uri.parse("tel:09368558019"));
                startActivity(intent_call);
                break;
            case R.id.app:
                Intent intent_message = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:09368558019"));
                startActivity(intent_message);
                break;
            case R.id.download:
            case R.id.search:
                Intent intent_download = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_download);
                break;
            case R.id.exit:
                finish();
                break;
        }
        
        
        return super.onOptionsItemSelected(item);
    }


}