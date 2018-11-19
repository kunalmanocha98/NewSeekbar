package com.agnitio.newseekbar;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.agnitio.newseekbar.tickseekbar.TextPosition;
import com.agnitio.newseekbar.tickseekbar.TickSeekBar;

import java.util.List;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    Context context;
    List<MyModel> list;
    public CustomAdapter(Context context, List<MyModel> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customlayout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TickSeekBar tickSeekBar1 = TickSeekBar
                .with(context)
                .showTickTextsPosition(TextPosition.ABOVE)
                .thumbDrawable(context.getDrawable(R.drawable.seekbar_thumb2))
                .thumbSize(50)
                .tickMarksDrawable(context.getDrawable(R.drawable.lineicon2))
                .tickMarksEndsHide(true)
                .tickMarksSize(16)
                .tickCount(list.get(i).getTickcount())
                .trackBackgroundColor(Color.parseColor("#d0d1d2"))
                .trackProgressColor(Color.parseColor("#ffb43c"))
                .tickTextsColor(Color.parseColor("#000000"))
                .trackRoundedCorners(true)
                .build();
        tickSeekBar1.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT
                ,RelativeLayout.LayoutParams.WRAP_CONTENT));
        tickSeekBar1.setPadding(40,40,40,40);
        tickSeekBar1.customTickTexts(list.get(i).getTicktexts());
        tickSeekBar1.setProgress(list.get(i).getProgress());

        viewHolder.container.addView(tickSeekBar1);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            container=itemView.findViewById(R.id.container_tickseekbar);
        }
    }
}
