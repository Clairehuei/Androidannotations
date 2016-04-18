package com.aa.androidannotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.aa.androidannotations.api.MyRestClient;
import com.aa.androidannotations.model.Err;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.myInput)
    EditText myInput;

    @ViewById(R.id.myTextView)
    TextView textView;

    @RestService
    MyRestClient myRestClient;

    @Click
    void myButton() {
//        String name = myInput.getText().toString();
//        textView.setText("Hello " + name);

        getErrInBackground();
    }

    // Executed in a background thread
    @Background
    void getErrInBackground() {
        Err err = myRestClient.getErr();
        showResult(err);
    }


    // Executed in the ui thread
    @UiThread
    void showResult(Err err) {
        Log.i("==showResult[Errcode]==", err.getErrcode());
        Log.i("==showResult[Errmsg]==", err.getErrmsg());

        textView.setText("Errcode : " + err.getErrcode());
    }


}
