package com.example.checker.slr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CheckReservationActivity extends ActionBarActivity {

    EditText nic ;
    String Nic ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_reservation);

        nic = (EditText) findViewById(R.id.nic);

        Button search = (Button) findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Nic = nic.getText().toString();

                if(Nic.equals("916881215V")){
                    Toast.makeText(getBaseContext() , "Valied NIC number" ,  Toast.LENGTH_LONG).show();

                    Intent myIntent = new Intent(CheckReservationActivity.this,ReservationDetailsActivity.class);
                    startActivity(myIntent);
                    finish();
                }else{
                    Toast.makeText(getBaseContext(), "Invalied NIC number ", Toast.LENGTH_LONG).show();
                    nic.setText("");

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_check_reservation, menu);
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
