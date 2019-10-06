package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    static ArrayList<String> notes =new ArrayList<>();
    static ArrayAdapter arrayAdapter;
    static Set<String> set;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView =(ListView) findViewById(R.id.listView);

        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);

        set=sharedPreferences.getStringSet("notes", null);
        notes.clear();

if(set!=null){
    notes.addAll(set);
}
else
{
    notes.add("Example note");
    set=new HashSet<String>();

}



        notes.add("Example note");

         arrayAdapter = new ArrayAdapter (this,android.R.layout.simple_list_item_1,notes);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){

                Intent intent=new Intent(getApplicationContext(),EditNote.class);
                intent.putExtra("noteId",position);
                startActivity(intent);
            }

                                        });

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        new AlertDialog.Builder(MainActivity.this)
                                                .setIcon(android.R.drawable.ic_dialog_alert);
                                                .setTitle("Are you sure?")
                                                .setMessage("Do you want to delete this item?")
                                                .setNegativeButton("No", null)
                                                .setPositiveButton("Yes", new DialogInterface.onClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialogInterface, int i) {

                                                        notes.remove(i);
                                                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);

                                                        if (set == null) {
                                                            set = new HashSet<String>();
                                                        } else {
                                                            set.clear();
                                                        }

                                                        set.addAll(MainActivity.notes);

                                                        sharedPreferences.edit().remove("notes").apply();
                                                        sharedPreferences.edit().putStringSet("notes", set).apply();
                                                        arrayAdapter.notifyDataSetChanged();

                                                    }
                                                })
                                                .show();

                                }







        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

                FloatingActionButton fab=(floatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.onClickListener(){
            @Override
                    public void onClick(View view){

                notes.add(" ");

                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);

                if(set==null)
                {
                    set=new HashSet<String>();
                }
                else
                {
                    set.clear();
                }

                set.addAll(notes);

                sharedPreferences.edit().remove("notes").apply();
                sharedPreferences.edit().putStringSet("notes",set).apply();
                arrayAdapter.notifyDataSetChanged();





                Intent intent=new Intent(getApplicationContext(),EditNote.class);

                intent.putExtra("noteId",note.size()-1);
                startActivity(intent);
            }
        }


    });
}
