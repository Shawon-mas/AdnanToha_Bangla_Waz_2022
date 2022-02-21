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
import com.abuadnanwaz2022.abuadnantohawaz2022.model.WazTitle;

import java.util.List;

public class WazTitleAdapter extends RecyclerView.Adapter<WazTitleAdapter.MyViewHolder> {
    Context context;
    List<WazTitle> wazTitleList;
    private final ClickItem clickItem;

    public WazTitleAdapter(Context context, List<WazTitle> wazTitleList, ClickItem clickItem) {
        this.context = context;
        this.wazTitleList = wazTitleList;
        this.clickItem = clickItem;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_title_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        WazTitle wazTitle = wazTitleList.get(position);
        holder.textView.setText(wazTitle.getTitle());
    }

    @Override
    public int getItemCount() {
        return wazTitleList.size();
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
