package com.renren.multitypedemo;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.renren.multitypedemo.Items.DataEntity.TripsEntity;

import me.drakeet.multitype.ItemViewProvider;

import static com.makeramen.RoundedImageView.TAG;


public class TripAdapter extends ItemViewProvider<TripsEntity, TripAdapter.ViewHolder> {
    @NonNull
    @Override
    protected TripAdapter.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.search_trip_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull TripAdapter.ViewHolder holder, @NonNull TripsEntity tripsEntity) {
        holder.setData(tripsEntity,holder.itemView.getContext());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIvImage;
        private TextView mTvTitle,mTvDate,mTvZuji,mTvViewCount,mTvLikedCount,mTvCommentCount;

        public ViewHolder(View view) {
            super(view);

            mIvImage = (ImageView) view.findViewById(R.id.photo);
            mTvTitle = (TextView) view.findViewById(R.id.tv_title);
            mTvDate = (TextView) view.findViewById(R.id.tv_time);
            mTvZuji = (TextView) view.findViewById(R.id.tv_zuji);
            mTvViewCount = (TextView) view.findViewById(R.id.tv_view_count);
            mTvLikedCount = (TextView) view.findViewById(R.id.tv_liked_count);
            mTvCommentCount = (TextView) view.findViewById(R.id.tv_comment_count);
        }

        void setData(final TripsEntity item, Context context){
            Glide.with(context)
                    .load(item.cover_image_default)
                    .asBitmap().into(mIvImage);
            mTvTitle.setText(item.name);
            Log.d(TAG, item.date_added);
            String date = item.date_added;
            //long l = Long.parseLong(date);
            String realDate  = date.substring(0,date.length()-2);

//            SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
//            Long data = Long.parseLong(realDate) * 1000;
//            String format1 = format.format(data);
            mTvDate.setText("2016-12-27");
            mTvZuji.setText(item.waypoints + "");
            mTvViewCount.setText(item.view_count);
            mTvLikedCount.setText(item.liked_count + "");
            mTvCommentCount.setText(item.total_comments_count + "");
        }
    }
}
