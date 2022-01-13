package com.innerchic.mapper.oldbase;

import android.view.View;

/**
 * Author:贾恒飞
 * Timer:2019/8/23 13:33
 * Model:caps2
 * PackageName:com.tencent.books.adapter.inter
 * Node:Item点击监听
 */
public interface OnItemClickMonitor<T> {
    void onClick(int pos, View view, T data, int type);
}
