package com.example.satyanishanth.politics;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class postadapter extends RecyclerView.Adapter<post> {
    Context context;

    public postadapter(Context context)
    {
        this.context=context;
    }
    @NonNull
    @Override
    public post onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context c = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(c);
        View view = inflater.inflate(R.layout.recycleelement,viewGroup,false);
        post newpost =new post(view);
        return  newpost;
    }

    @Override
    public void onBindViewHolder(@NonNull post post, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
