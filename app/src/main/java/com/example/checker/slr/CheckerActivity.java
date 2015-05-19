package com.example.checker.slr;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class CheckerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checker);

        Button validate_ticket = (Button) findViewById(R.id.validate_ticket);

        validate_ticket.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CheckerActivity.this, ValidateTicketActivity.class);
                startActivity(myIntent);

            }
        });

        Button check_reservation = (Button) findViewById(R.id.check_reservation);

        check_reservation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CheckerActivity.this,CheckReservationActivity.class);
                startActivity(myIntent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_checker, menu);
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

    class t extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... params) {

            return null;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    /** A basic Camera preview class */
    public static class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
        private SurfaceHolder mHolder;
        private Camera mCamera;
        private Camera.PreviewCallback previewCallback;
        private Camera.AutoFocusCallback autoFocusCallback;

        public CameraPreview(Context context, Camera camera,
                             Camera.PreviewCallback previewCb,
                             Camera.AutoFocusCallback autoFocusCb) {
            super(context);
            mCamera = camera;
            previewCallback = previewCb;
            autoFocusCallback = autoFocusCb;

            /*
             * Set camera to continuous focus if supported, otherwise use
             * software auto-focus. Only works for API level >=9.
             */
            /*
            Camera.Parameters parameters = camera.getParameters();
            for (String f : parameters.getSupportedFocusModes()) {
                if (f == Parameters.FOCUS_MODE_CONTINUOUS_PICTURE) {
                    mCamera.setFocusMode(Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
                    autoFocusCallback = null;
                    break;
                }
            }
            */

            // Install a SurfaceHolder.Callback so we get notified when the
            // underlying surface is created and destroyed.
            mHolder = getHolder();
            mHolder.addCallback(this);

            // deprecated setting, but required on Android versions prior to 3.0
            mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }

        public void surfaceCreated(SurfaceHolder holder) {
            // The Surface has been created, now tell the camera where to draw the preview.
            try {
                mCamera.setPreviewDisplay(holder);
            } catch (IOException e) {
                Log.d("DBG", "Error setting camera preview: " + e.getMessage());
            }
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            // Camera preview released in activity
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            /*
             * If your preview can change or rotate, take care of those events here.
             * Make sure to stop the preview before resizing or reformatting it.
             */
            if (mHolder.getSurface() == null){
                // preview surface does not exist
                return;
            }

            // stop preview before making changes
            try {
                mCamera.stopPreview();
            } catch (Exception e){
                // ignore: tried to stop a non-existent preview
            }

            try {
                // Hard code camera surface rotation 90 degs to match Activity view in portrait
                mCamera.setDisplayOrientation(90);

                mCamera.setPreviewDisplay(mHolder);
                mCamera.setPreviewCallback(previewCallback);
                mCamera.startPreview();
                mCamera.autoFocus(autoFocusCallback);
            } catch (Exception e){
                Log.d("DBG", "Error starting camera preview: " + e.getMessage());
            }
        }
    }
}
