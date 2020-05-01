package com.example.a20200430_brianferguson_nycschools.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20200430_brianferguson_nycschools.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView schoolName;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        schoolName = itemView.findViewById(R.id.school_name);
    }
}
