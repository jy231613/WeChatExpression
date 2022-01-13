package com.innerchic.weqiuqiu.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.innerchic.weqiuqiu.R;

import java.util.ArrayList;
import java.util.List;

/*
╔════════════════════════════════════════════╗
║ Author       : 贾恒飞
║ Timer        : 2020/9/18 15:11
║ Model        : community
║ PackageName  : com.community.example.thread.emoji
║ Node         : 表情库
╚════════════════════════════════════════════╝
*/public class EmojiView extends FrameLayout {

    public EmojiView(@NonNull Context context) {
        super(context);
        init(context);
    }


    public EmojiView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private LinearLayout bgLy;

    private RecyclerView recyclerLy;

    //监听
    private OnClickEmojiListener emojiListener;

    public void setEmojiListener(OnClickEmojiListener emojiListener) {
        this.emojiListener = emojiListener;
    }

    private int columns = 8;

    public void setColumns(int columns) {
        this.columns = columns;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), columns);
        recyclerLy.setLayoutManager(gridLayoutManager);
    }

    /**
     * 初始化
     */
    private void init(Context context) {
        View root = LayoutInflater.from(context).inflate(R.layout.view_emoji_layout, this);

        recyclerLy = root.findViewById(R.id.recyclerLy);
        bgLy = root.findViewById(R.id.bgLy);

        List<Expression> adapterData = new ArrayList<>();

        //渲染列表
        EmojiAdapter adapter = new EmojiAdapter(getContext());
        adapter.bind(adapterData);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), columns);
        recyclerLy.setLayoutManager(gridLayoutManager);
        recyclerLy.setAdapter(adapter);
        adapterData.addAll(Expression.ExpressionData.data);
        adapter.notifyDataSetChanged();

        //设置监听
        adapter.setClickMonitor((pos, view, data, type) -> {
            if (emojiListener != null) {
                if (type == 0) {
                    emojiListener.onClick(data, pos);
                } else {
                    emojiListener.onLongClick(data, pos);
                }
            }
        });
    }

}
