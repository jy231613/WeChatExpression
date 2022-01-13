package com.innerchic.weqiuqiu.emoji;

/*
╔════════════════════════════════════════════╗
║ Author       : 贾恒飞
║ Timer        : 2020/9/18 15:42
║ Model        : community
║ PackageName  : com.community.example.thread.emoji
║ Node         : 点击表情之后的监听
╚════════════════════════════════════════════╝
*/
public interface OnClickEmojiListener {

    void onClick(Expression expression, int pos);

    void onLongClick(Expression expression, int pos);
}
