package com.example.checker.slr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignInActivity extends ActionBarActivity {

    EditText user_name , password ;
    String User_name , Password ;

    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        user_name = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);

        Button sign_in = (Button) findViewById(R.id.sign_in);

        sign_in.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                User_name = user_name.getText().toString();
                Password = password.getText().toString();

                if(User_name.equals("c") && Password.equals("c")){
                    Toast.makeText(getBaseContext() , "Successfully SignIn" ,  Toast.LENGTH_LONG).show();

                    Intent myIntent = new Intent(SignInActivity.this,CheckerActivity.class);
                    startActivity(myIntent);
                    finish();
                }else{
                    Toast.makeText(getBaseContext(), "Invalied Login ", Toast.LENGTH_LONG).show();
                    user_name.setText("");
                    password.setText("");
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_in, menu);
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
