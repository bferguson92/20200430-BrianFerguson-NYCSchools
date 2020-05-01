package com.example.a20200430_brianferguson_nycschools.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20200430_brianferguson_nycschools.R;
import com.example.a20200430_brianferguson_nycschools.model.SchoolResponse;

import java.util.List;

public class SchoolsAdapter extends RecyclerView.Adapter<SchoolsAdapter.CustomViewHolder> {

    private List<SchoolResponse> schools;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(SchoolResponse school);
    }

    public SchoolsAdapter(List<SchoolResponse> schools, OnItemClickListener listener) {
        this.schools = schools;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.school_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.schoolName.setText(schools.get(position).getSchoolName());
        holder.schoolName.setOnClickListener(click -> {
            listener.onItemClick(schools.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView schoolName;

        private CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            schoolName = itemView.findViewById(R.id.school_name);
        }
    }
}
