package com.innerchic.weqiuqiu.emoji;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.innerchic.weqiuqiu.R;

/*
╔════════════════════════════════════════════╗
║ Author       : 贾恒飞
║ Timer        : 2020/9/18 15:23
║ Model        : community
║ PackageName  : com.community.example.thread.emoji
║ Node         : Emoji适配器对象
╚════════════════════════════════════════════╝
*/
public class EmojiHolder extends RecyclerView.ViewHolder {

    public ImageView imageLy;

    public LinearLayout bgLy;

    public EmojiHolder(@NonNull View itemView) {
        super(itemView);
        bgLy = itemView.findViewById(R.id.bgLy);
        imageLy = itemView.findViewById(R.id.imageLy);
    }

}
