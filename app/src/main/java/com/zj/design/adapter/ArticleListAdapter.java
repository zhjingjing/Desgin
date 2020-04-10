package com.zj.design.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zj.design.R;
import com.zj.design.entity.ArticleEntity;
import com.zj.design.listener.OnItemClickListener;

import java.util.List;

/**
 * create by zj on 2020/4/10
 */
public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleHolder> {

    private Context context;
    private List<ArticleEntity> list;

    public ArticleListAdapter(Context context,List<ArticleEntity> list) {
        this.context = context;
        this.list=list;

    }

    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_article,viewGroup,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.itemClick(i);
                }
            }
        });
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder articleHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ArticleHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView tvTitle;
        TextView tvContent;
        public ArticleHolder(@NonNull View itemView) {
            super(itemView);
            avatar=itemView.findViewById(R.id.iv_avatar);
        }
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
