package com.example.andres.clasetres;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     LinearLayout contentLayout;
      int contador = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        contentLayout = (LinearLayout)findViewById(R.id.content_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton button1 = (FloatingActionButton) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show(); */

                    Context c=MainActivity.this ;
                    TextView tvv=new TextView(c);
                    tvv.setText("Campo: "+contador);
                    Button boton = new Button(c);
                 boton.setText("Mostrar");
                EditText text = new EditText(c);
                text.setId(Integer.valueOf(contador));
                boton.setTag(contador);
                contentLayout.addView(tvv);
                contentLayout.addView(text);
                contentLayout.addView(boton);
                contador = contador+1 ;
                boton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String id = v.getTag().toString();
                                String texto = ((EditText)findViewById(Integer.valueOf(id))).getText().toString();
                                Log.d("Mensaje:",texto);

                            }
                        });



            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
