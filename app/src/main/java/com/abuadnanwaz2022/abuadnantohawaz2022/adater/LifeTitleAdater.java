package com.abuadnanwaz2022.abuadnantohawaz2022.adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abuadnanwaz2022.abuadnantohawaz2022.R;
import com.abuadnanwaz2022.abuadnantohawaz2022.model.ClickItem;
import com.abuadnanwaz2022.abuadnantohawaz2022.model.LifeTitle;

import java.util.List;

public class LifeTitleAdater extends RecyclerView.Adapter<LifeTitleAdater.MyViewHolder> {
    Context context;
    List<LifeTitle> lifeTitleList;
    private final ClickItem clickItem;

    public LifeTitleAdater(Context context, List<LifeTitle> lifeTitleList, ClickItem clickItem) {
        this.context = context;
        this.lifeTitleList = lifeTitleList;
        this.clickItem = clickItem;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_title_list, parent, false);
        return new LifeTitleAdater.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        LifeTitle lifeTitle = lifeTitleList.get(position);
        holder.textView.setText(lifeTitle.getTitle());
    }

    @Override
    public int getItemCount() {
        return lifeTitleList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.vtitle_id);
            imageView=itemView.findViewById(R.id.play_video);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(clickItem!=null)
                    {

                        int pos=getAdapterPosition();
                        if (pos!=RecyclerView.NO_POSITION)
                        {
                            clickItem.onItemClick(pos);
                        }
                    }

                }
            });
        }
    }

}
