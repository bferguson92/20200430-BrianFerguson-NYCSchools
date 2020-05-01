package com.example.a20200430_brianferguson_nycschools.adapter;

import android.view.View;

public class CustomViewHolderFactory {

    private View itemView;

    public CustomViewHolderFactory(View itemView){
        this.itemView = itemView;
    }

    public CustomViewHolder createViewHolder(){
        return new CustomViewHolder(itemView);
    }
}
