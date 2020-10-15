package com.ldc.app_base.core;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.core
 * 作者: liudi
 * 创建时间: 2020/10/13
 */
public class BaseRVViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> viewSparseArray;

    public static BaseRVViewHolder getInstance(int layoutId, ViewGroup viewGroup, boolean attachToRoot) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, attachToRoot);
        return new BaseRVViewHolder(view);
    }

    private BaseRVViewHolder(@NonNull View itemView) {
        super(itemView);
        viewSparseArray = new SparseArray<>();
    }

    public <T> T findView(int viewId) {
        View view = viewSparseArray.get(viewId);
        if (null == view) {
            view = itemView.findViewById(viewId);
            viewSparseArray.put(viewId, view);
        }
        return (T) view;
    }
}
