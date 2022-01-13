package com.innerchic.mapper.oldbase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:贾恒飞
 * Timer:2019/8/23 13:44
 * Model:caps2
 * PackageName:com.tencent.books.adapter.base
 * Node:适配器
 * <p>
 * T:数据类型
 * H:ViewHolder
 */
public abstract class RecyclerAdapter<T, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter {
    private int count = 1;

    private Context context;
    protected List<T> ts = null;

    protected T getBean(int pos) {
        if (ts == null) return null;
        if (pos >= ts.size()) return null;
        return ts.get(pos);
    }

    private GridLayoutManager gridLayoutManager;

    public GridLayoutManager getLayoutManager() {
        if (gridLayoutManager == null) {
            gridLayoutManager = new GridLayoutManager(context, count);
        }
        return gridLayoutManager;
    }

    private LinearLayoutManager linearLayoutManager;

    public LinearLayoutManager getLinearLayoutManager() {
        if (linearLayoutManager == null) {
            linearLayoutManager = new LinearLayoutManager(context);
        }
        return linearLayoutManager;
    }

    public Context getContext() {
        return context;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private OnItemClickMonitor<T> clickMonitor;

    public OnItemClickMonitor<T> getClickMonitor() {
        if (clickMonitor == null) return (pos, view, data, type) -> {
        };
        return clickMonitor;
    }

    public void setClickMonitor(OnItemClickMonitor<T> clickMonitor) {
        this.clickMonitor = clickMonitor;
    }

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    public RecyclerAdapter(Context context, OnItemClickMonitor<T> clickMonitor) {
        this.context = context;
        this.clickMonitor = clickMonitor;
    }

    public RecyclerAdapter(int count, Context context) {
        this.count = count;
        this.context = context;
    }

    public void bind(List<T> list) {
        if (list == null) return;
        try {
            if (this.ts != null) {
                this.ts.clear();
                this.ts = null;
            }
            this.ts = list;
            this.notifyItemRangeInserted(0, this.ts.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(List<T> list) {
        if (list == null) return;
        try {
            if (this.ts == null) this.ts = new ArrayList<>();
            int startIndex = getItemCount();
            this.ts.addAll(list);
            this.notifyItemInserted(this.ts.size() - 1);
            gridLayoutManager.scrollToPosition(startIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean hasParent() {
        return false;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view;
        if (hasParent()) {
            view = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(i), null);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(i), parent, false);
        }
        return getViewHolder(view, i);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemCount() != 0) {
            bindViewHolder((H) viewHolder, ts.get(i), i);
        }
    }

    @Override
    public int getItemCount() {
        return ts == null ? 0 : ts.size();
    }

    protected abstract H getViewHolder(View view, int viewType);

    protected abstract @LayoutRes
    int getLayoutRes(int viewType);

    protected abstract void bindViewHolder(H holder, T bean, int position);


    //监听
    private View.OnLongClickListener longClickListener;
    private View.OnClickListener clickListener;

    public View.OnLongClickListener getLongClickListener() {
        return longClickListener;
    }

    public void setLongClickListener(View.OnLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    public View.OnClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
