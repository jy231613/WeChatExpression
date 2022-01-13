package com.innerchic.weqiuqiu.emoji;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.innerchic.mapper.oldbase.RecyclerAdapter;
import com.innerchic.weqiuqiu.R;

import java.io.IOException;
import java.io.InputStream;

/*
╔════════════════════════════════════════════╗
║ Author       : 贾恒飞
║ Timer        : 2020/9/18 15:22
║ Model        : community
║ PackageName  : com.community.example.thread.emoji
║ Node         : Emoji适配器
╚════════════════════════════════════════════╝
*/public class EmojiAdapter extends RecyclerAdapter<Expression, EmojiHolder> {

    public EmojiAdapter(Context context) {
        super(context);
        assets = getContext().getAssets();
    }

    @Override
    protected EmojiHolder getViewHolder(View view, int viewType) {
        return new EmojiHolder(view);
    }

    @Override
    protected int getLayoutRes(int viewType) {
        return R.layout.adapter_emoji;
    }

    private AssetManager assets;

    @Override
    protected void bindViewHolder(EmojiHolder holder, Expression bean, int position) {
        try {
            InputStream ims = getContext().getAssets().open("expression/" + bean.getPath());
            Drawable d = Drawable.createFromStream(ims, null);
            holder.imageLy.setImageDrawable(d);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        holder.bgLy.setOnClickListener(v -> getClickMonitor().onClick(position, v, bean, 0));

        holder.bgLy.setOnLongClickListener(v -> {
            getClickMonitor().onClick(position, v, bean, 1);
            return false;
        });
    }

}
