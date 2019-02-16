package com.example.utilizador.prototipo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        try {
            android.support.v7.app.ActionBar actionBar = this.getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }catch (Exception e){
            Log.e("BACK_ARROW","Error adding back arrow");
        }

        Button mAdd = findViewById(R.id.add_button);
        Spinner mBuildingView = (Spinner) findViewById(R.id.types_spinner);

        mAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AddActivity.this);
                builder.setMessage("Modulo registado com sucesso!")
                        .setCancelable(false)
                        .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent returnIntent = new Intent();
                                setResult(Activity.RESULT_OK,returnIntent);
                                finish();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.building_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBuildingView.setAdapter(adapter);
        mBuildingView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }

        });

    }


    public boolean onOptionsItemSelected(MenuItem item){
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_CANCELED,returnIntent);
        finish();
        return true;
    }

}
