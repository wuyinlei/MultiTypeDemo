package com.renren.multitypedemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.renren.multitypedemo.R;
import com.renren.multitypedemo.bean.Items.DataEntity.UsersEntity;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by Administrator on 2016/12/27.
 */

public class UserAdapter extends ItemViewProvider<UsersEntity,UserAdapter.ViewHolder>{


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.search_mianyou_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull UsersEntity usersEntity) {
        holder.setData(usersEntity,holder.itemView.getContext());
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mIvUser;
        private TextView mTvName;
        private RelativeLayout mReUser;

        public ViewHolder(View itemView) {
            super(itemView);
            mIvUser = (ImageView) itemView.findViewById(R.id.img_avator);
            mTvName = (TextView) itemView.findViewById(R.id.tv_user_name);
            mReUser = (RelativeLayout) itemView.findViewById(R.id.re_user);
        }


        void setData(final UsersEntity entity, final Context context){
            Glide.with(context)
                    .load(entity.avatar_l)
                    .asBitmap()
                    .into(mIvUser);
            mTvName.setText(entity.name);
            mReUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, entity.name, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
