package com.aa.androidannotations.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.aa.androidannotations.api.PersonFinder;
import com.aa.androidannotations.api.impl.InMemoryPersonFinder;
import com.aa.androidannotations.model.Person;
import com.aa.androidannotations.view.PersonItemView;
import com.aa.androidannotations.view.PersonItemView_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

/**
 * Created by 6193 on 2016/4/19.
 */
@EBean
public class PersonListAdapter extends BaseAdapter {

    List<Person> persons;

    @Bean(InMemoryPersonFinder.class)
    PersonFinder personFinder;

    @RootContext
    Context context;

    @AfterInject
    void initAdapter() {
        System.out.println("=====PersonListAdapter=====initAdapter");
        persons = personFinder.findAll();
    }

    @Override
    public int getCount() {
        System.out.println("===getCount===");
        return persons.size();
    }

    @Override
    public Person getItem(int position) {
        System.out.println("===getItem===");
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        System.out.println("===getItemId===");
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("===getView===");
        PersonItemView personItemView;
        if (convertView == null) {
            personItemView = PersonItemView_.build(context);
        } else {
            personItemView = (PersonItemView) convertView;
        }

        personItemView.bind(getItem(position));

        return personItemView;
    }
}
