package com.ldc.app_base.core;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ldc.app_base.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目: BleApp
 * 包名: com.ldc.app_base.core
 * 作者: liudi
 * 创建时间: 2020/10/13
 */
public abstract class BaseRVAdapter<T> extends RecyclerView.Adapter<BaseRVViewHolder> {
    private List<T> mData;
    private static final int EMPTY_CODE = 0x999;
    private int layoutId;

    public BaseRVAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    public void setNewData(List<T> t) {
        if (null == t) return;
        mData = new ArrayList<>(t);
        notifyDataSetChanged();
    }

    public void addData(List<T> t) {
        if (null == t) return;
        if (null == mData) {
            mData = new ArrayList<>(t);
        } else {
            if (!mData.containsAll(t)) {
                mData.addAll(t);
            }
        }
        notifyDataSetChanged();
    }

    public void addData(List<T> t, int position) {
        if (null == t) return;
        if (null == mData) {
            mData = new ArrayList<>(t);
        } else {
            if (!mData.containsAll(t)) {
                mData.addAll(t);
            }
        }
        notifyItemChanged(position, mData);
    }

    @NonNull
    @Override
    public BaseRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (EMPTY_CODE == viewType) {
            return BaseRVViewHolder.getInstance(R.layout.view_empty_layout, parent, false);
        } else {
            return BaseRVViewHolder.getInstance(layoutId, parent, false);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRVViewHolder holder, int position) {
        if (EMPTY_CODE != getItemViewType(position)) {
            T t = mData.get(position);
            if (null == t) return;
            convert(holder, t, position);
        }
    }

    @Override
    public int getItemCount() {
        return null != mData && mData.size() > 0 ? mData.size() : 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (null == mData || mData.isEmpty()) {
            return EMPTY_CODE;
        }
        return super.getItemViewType(position);
    }

    protected abstract void convert(BaseRVViewHolder holder, T t, int position);
}
