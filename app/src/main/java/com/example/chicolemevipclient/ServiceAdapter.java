package com.example.chicolemevipclient;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> implements Filterable {

    public static final String TAG = "Service Adapter";

    private View.OnClickListener mOnClickListener;
    private View.OnLongClickListener mOnLongClickListener;
    private Context mContext;
    private List<Servico> mServicoList;
    private List<Servico> mServicoListFull;
    private TextView mTextViewTotalPrice;

    public ServiceAdapter(Context mContext, List<Servico> mServicoList, TextView mTextViewTotalPrice) {
        this.mContext = mContext;
        this.mServicoList = mServicoList;
        this.mTextViewTotalPrice = mTextViewTotalPrice;
    }

    public String setPriceColor(double vRating){
        if (vRating < 3){
            return "#BF0404";
        } else{
            return "#000000";
        }
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public ServiceAdapter.ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdapter.ServiceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
