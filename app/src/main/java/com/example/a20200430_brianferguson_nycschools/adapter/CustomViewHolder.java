package com.example.a20200430_brianferguson_nycschools.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20200430_brianferguson_nycschools.R;
import com.example.a20200430_brianferguson_nycschools.model.SchoolResponse;

class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView schoolName;

    CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        schoolName = itemView.findViewById(R.id.school_name);
    }

    void bind(final SchoolResponse school, final SchoolsAdapter.OnItemClickListener listener) {
        itemView.setOnClickListener(click -> {
            listener.onItemClick(school);
        });
    }
}
