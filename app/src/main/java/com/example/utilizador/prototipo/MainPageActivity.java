package com.example.utilizador.prototipo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class MainPageActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

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
            // do something here
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
