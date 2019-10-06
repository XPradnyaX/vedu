package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashSet;

import static com.example.myapplication.MainActivity.notes;
import static com.example.myapplication.MainActivity.set;

public class EditNote extends AppCompatActivity {

    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText editText=(EditText) findViewById(R.id.editText);

        Intent i=getIntent();

        noteId= i.getInExtra("noteId", -1){

            String fillerText= notes.get(noteId);
            editText.setText(fillerText);
        }

editText editText =(EditText) findViewById(R.id.editText);

        Intent i=getIntent();

        noteId =i.getIntExtra("noteId",-1);

        if(noteId!=-1)
        {
            String fillerText= notes.get(noteId);
            editText.setText(fillerText);
        }




        FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(){
            Intent mainIntent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainIntent);

        });
getSupportActionBar().setDisplayHomeAsUpEnabled(true);


@Override
public void beforeTextChanged(CharSequence charSequence,int i,int i1,int i2){

        }


        @Override
    public void onTextChanged(CharSequence charSequence,int i,int i1,int i2){

    notes.set(noteId,String.valueOf(charSequence));
    MainActivity.arrayAdapter.notifyDataSetChanged();

            SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);

            if(set==null)
            {
                set=new HashSet<String>();
            }
else
            {
                set.clear();
            }
set.clear();

            set.addAll(notes);
            sharedPreferences.edit()remove("notes").apply();
            sharedPreferences.edit().putStringSet("notes",set).apply();
        }

@Override

        public void afterTextChanged(Editable editable){



        }












    }



















}
