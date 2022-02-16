package com.azhariwaz2022.azharibanglawaz2022.adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhariwaz2022.azharibanglawaz2022.R;
import com.azhariwaz2022.azharibanglawaz2022.model.ClickItem;
import com.azhariwaz2022.azharibanglawaz2022.model.IslamLifeTitle;
import com.azhariwaz2022.azharibanglawaz2022.model.LifeTitle;

import java.util.List;

public class IslamLifeTitleAdapter extends RecyclerView.Adapter<IslamLifeTitleAdapter.MyViewHolder> {
    Context context;
    List<IslamLifeTitle> islamLifeTitleList;
    private final ClickItem clickItem;

    public IslamLifeTitleAdapter(Context context, List<IslamLifeTitle> islamLifeTitleList, ClickItem clickItem) {
        this.context = context;
        this.islamLifeTitleList = islamLifeTitleList;
        this.clickItem = clickItem;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_title_list, parent, false);
        return new IslamLifeTitleAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        IslamLifeTitle islamLifeTitle = islamLifeTitleList.get(position);
        holder.textView.setText(islamLifeTitle.getTitle());
    }

    @Override
    public int getItemCount() {
        return islamLifeTitleList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.vtitle_id);
            imageView = itemView.findViewById(R.id.play_video);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickItem != null) {

                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            clickItem.onItemClick(pos);
                        }
                    }

                }
            });
        }
    }
}
