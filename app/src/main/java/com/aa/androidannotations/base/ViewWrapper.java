package com.aa.androidannotations.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 6193 on 2016/4/20.
 */
public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public ViewWrapper(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }

}