package com.azhariwaz2022.azharibanglawaz2022.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.azhariwaz2022.azharibanglawaz2022.R;
import com.azhariwaz2022.azharibanglawaz2022.adater.LifeTitleAdater;
import com.azhariwaz2022.azharibanglawaz2022.adater.WazTitleAdapter;
import com.azhariwaz2022.azharibanglawaz2022.model.ClickItem;
import com.azhariwaz2022.azharibanglawaz2022.model.LifeTitle;
import com.azhariwaz2022.azharibanglawaz2022.model.WazTitle;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class LifeActivity extends AppCompatActivity implements ClickItem {
    RecyclerView recyclerView;
    List<LifeTitle> lifeTitleList_lf;
    LifeTitleAdater adapter;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer youTubePlayer;
    private String currentVideoId;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference mRef=db.collection("LifeList");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        initViews();
        recyclerviewImplement();
    }

    private void recyclerviewImplement() {
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter=new LifeTitleAdater(LifeActivity.this,lifeTitleList_lf,this);
        recyclerView.setAdapter(adapter);
        mRef.orderBy("id", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.d("Firestore error", error.getMessage());
                    return;
                }
                for (DocumentChange documentChange : value.getDocumentChanges()) {
                    if (documentChange.getType() == DocumentChange.Type.ADDED) {
                        lifeTitleList_lf.add(documentChange.getDocument().toObject(LifeTitle.class));
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void initViews() {
        recyclerView=findViewById(R.id.life_recycler);
        youTubePlayerView=findViewById(R.id.youtube_player_view_life);
        lifeTitleList_lf=new ArrayList<LifeTitle>();
    }

    @Override
    public void onItemClick(int position) {
        cueVideo(lifeTitleList_lf.get(position).getVideoId());

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer initializedYouTubePlayer) {
                youTubePlayer = initializedYouTubePlayer;
                youTubePlayer.cueVideo(currentVideoId, 0);

            }
        });
        //
        Toasty.info(getApplicationContext(),"Please wait...Loading Video",Toasty.LENGTH_LONG,true).show();

    }

    void cueVideo(String videoId) {
        currentVideoId = videoId;

        if(youTubePlayer == null)
            return;

        youTubePlayer.cueVideo(videoId, 0);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        youTubePlayerView.release();
    }

}