package com.aa.androidannotations.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.aa.androidannotations.base.RecyclerViewAdapterBase;
import com.aa.androidannotations.base.ViewWrapper;
import com.aa.androidannotations.model.Person;
import com.aa.androidannotations.view.PersonItemView;
import com.aa.androidannotations.view.PersonItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by 6193 on 2016/4/20.
 */
@EBean
public class PersonAdapter extends RecyclerViewAdapterBase<Person, PersonItemView> {

    @RootContext
    Context context;

    @Override
    protected PersonItemView onCreateItemView(ViewGroup parent, int viewType) {
        return PersonItemView_.build(context);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<PersonItemView> viewHolder, int position) {
        PersonItemView view = viewHolder.getView();
        Person person = items.get(position);

        view.bind(person);
    }

}
