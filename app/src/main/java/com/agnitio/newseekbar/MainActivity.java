package com.agnitio.newseekbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.agnitio.newseekbar.tickseekbar.TextPosition;
import com.agnitio.newseekbar.tickseekbar.TickSeekBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private TickSeekBar tickSeekBar;
    RecyclerView recycler;
    List<MyModel> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler=findViewById(R.id.recycler_view);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        for (int i=2;i<=10;i++){
            MyModel md=new MyModel();
            String[] arrayitems=new String[i];
            for (int j=0;j<arrayitems.length;j++){
                arrayitems[j]=""+(j+1);
            }
            md.setTicktexts(arrayitems);
            md.setTickcount(i);
            int min = 1;
            int max = i;
            int random = new Random().nextInt((max - min) + 1) + min;
            md.setProgress(""+random);
            list.add(md);
        }
        CustomAdapter adapter= new CustomAdapter(this,list);
        recycler.setAdapter(adapter);
//        RelativeLayout rl = findViewById(R.id.container);
//        TickSeekBar tickSeekBar1 = TickSeekBar
//                .with(this)
//                .showTickTextsPosition(TextPosition.ABOVE)
//                .thumbDrawable(getDrawable(R.drawable.seekbar_thumb2))
//                .thumbSize(50)
//                .tickMarksDrawable(getDrawable(R.drawable.lineicon2))
//                .tickMarksEndsHide(true)
//                .tickMarksSize(16)
//                .tickCount(5)
//                .trackBackgroundColor(Color.parseColor("#d0d1d2"))
//                .trackProgressColor(Color.parseColor("#ffb43c"))
//                .trackRoundedCorners(true)
//                .build();
//        tickSeekBar1.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT
//                ,RelativeLayout.LayoutParams.WRAP_CONTENT));
//        tickSeekBar1.setPadding(10,40,10,20);
//        rl.addView(tickSeekBar1);
//        tickSeekBar1.customTickTexts(new String[]{"1","2","3","4","5"});
//        tickSeekBar1.setProgress("3");
    }
}
