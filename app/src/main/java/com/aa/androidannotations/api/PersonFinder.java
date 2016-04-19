package com.aa.androidannotations.api;

import com.aa.androidannotations.model.Person;

import java.util.List;

/**
 * Created by 6193 on 2016/4/19.
 */
public interface PersonFinder {
    List<Person> findAll();
}
