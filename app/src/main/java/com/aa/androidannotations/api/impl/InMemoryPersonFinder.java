package com.aa.androidannotations.api.impl;

import com.aa.androidannotations.api.PersonFinder;
import com.aa.androidannotations.model.Person;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 6193 on 2016/4/19.
 */
@EBean
public class InMemoryPersonFinder implements PersonFinder{
    @Override
    public List<Person> findAll() {
        System.out.println("=====InMemoryPersonFinder=====");
        List<Person> p = new ArrayList<>();
        p.add(new Person("Allen", "Lai"));
        p.add(new Person("Jimmy", "Chou"));
        p.add(new Person("Jerry", "Song"));
        p.add(new Person("Hiro", "Shio"));
        p.add(new Person("William", "Zeng"));


        return p;
    }
}
