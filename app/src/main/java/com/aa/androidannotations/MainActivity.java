package com.aa.androidannotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aa.androidannotations.adapter.PersonListAdapter;
import com.aa.androidannotations.api.MyRestClient;
import com.aa.androidannotations.model.Err;
import com.aa.androidannotations.model.Person;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.Trace;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;



@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    ListView personList;

    @Bean
    PersonListAdapter adapter;

    @AfterViews
    void bindAdapter() {
        System.out.println("===bindAdapter===");
        personList.setAdapter(adapter);
    }

    @ItemClick
    void personListItemClicked(Person person) {
        Toast.makeText(this, person.firstName + " " + person.lastName, Toast.LENGTH_SHORT).show();
    }


//==================================以下為rest api test========================================
//    @ViewById(R.id.myInput)
//    EditText myInput;
//
//    @ViewById(R.id.myTextView)
//    TextView textView;
//
//    @RestService
//    MyRestClient myRestClient;
//
//    //可省略onCreate
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        System.out.println("MainActivity");
//    }
//
//
//    @Click
//    void myButton() {
//        getErrInBackground();
//    }
//
//    // Executed in a background thread
//    @Trace(tag="CustomTag", level=Log.WARN)
//    @Background
//    void getErrInBackground() {
//        Err err = myRestClient.getErr();
//        showResult(err);
//    }
//
//
//    // Executed in the ui thread
//    @Trace(tag="CustomTag", level=Log.WARN)
//    @UiThread
//    void showResult(Err err) {
//        Log.i("==showResult[Errcode]==", err.getErrcode());
//        Log.i("==showResult[Errmsg]==", err.getErrmsg());
//
//        textView.setText("Errcode : " + err.getErrcode());
//    }


}
