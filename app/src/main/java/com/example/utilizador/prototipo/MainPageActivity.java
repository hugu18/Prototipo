package com.example.utilizador.prototipo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainPageActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private boolean clicked = false;
    View mOriginal;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        ImageView mFirstImage = findViewById(R.id.firstMode);
        ImageView mSecondImage = findViewById(R.id.secondMode);
        ImageView mThirdImage = findViewById(R.id.thirdMode);
        ImageView mFourthImage = findViewById(R.id.fourthMode);
        ImageView mNewMode = findViewById(R.id.newMode);

        ImageView mModeOption1 = findViewById(R.id.option1);

        mModeOption1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showMenu(v);
            }
        });

        mFirstImage.setImageResource(R.drawable.parafusos);
        mSecondImage.setImageResource(R.drawable.battery);
        mThirdImage.setImageResource(R.drawable.placarede);
        mFourthImage.setImageResource(R.drawable.circuitos);
        mNewMode.setImageResource(R.drawable.processador);

    }


    public void showMenu(View v)
    {
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);// to implement on click event on items of menu
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.modemenu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {
        clicked = !clicked;
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if(clicked) {
            bar.setCustomView(R.layout.actionbar_view);


            EditText search = (EditText) bar.getCustomView().findViewById(
                    R.id.searchfield);
            search.setOnEditorActionListener(new TextView.OnEditorActionListener() {

                @Override
                public boolean onEditorAction(TextView v, int actionId,
                                              KeyEvent event) {
                    findViewById(R.id.mode2).setVisibility(View.GONE);
                    findViewById(R.id.mode3).setVisibility(View.GONE);
                    findViewById(R.id.mode4).setVisibility(View.GONE);
                    return false;
                }
            });
            search.requestFocus();
            // Show soft keyboard for the user to enter the value.
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
            bar.setDisplayShowCustomEnabled(true);

        }else{
            findViewById(R.id.mode2).setVisibility(View.VISIBLE);
            findViewById(R.id.mode3).setVisibility(View.VISIBLE);
            findViewById(R.id.mode4).setVisibility(View.VISIBLE);
            bar.setDisplayShowCustomEnabled(false);
        }

        }else if(id == R.id.add){
            Intent intent = new Intent(MainPageActivity.this, AddActivity.class);
            startActivityForResult(intent,1);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1 ) {
            if(resultCode == Activity.RESULT_OK){
                View v = findViewById(R.id.newLayout);
                v.setVisibility(View.VISIBLE);
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
