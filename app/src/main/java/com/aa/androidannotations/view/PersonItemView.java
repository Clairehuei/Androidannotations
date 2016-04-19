package com.aa.androidannotations.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aa.androidannotations.R;
import com.aa.androidannotations.model.Person;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by 6193 on 2016/4/19.
 */
@EViewGroup(R.layout.person_item)
public class PersonItemView extends LinearLayout {

    @ViewById
    TextView firstNameView;

    @ViewById
    TextView lastNameView;

    public PersonItemView(Context context) {
        super(context);
    }

    public void bind(Person person) {
        firstNameView.setText(person.firstName);
        lastNameView.setText(person.lastName);
    }

}
