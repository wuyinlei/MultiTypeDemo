package com.renren.multitypedemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.renren.multitypedemo.Items.DataEntity.PlacesEntity;

import me.drakeet.multitype.ItemViewProvider;


public class SceneAdapter extends ItemViewProvider<PlacesEntity,SceneAdapter.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.search_city_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull PlacesEntity placesEntity) {
        holder.setData(placesEntity);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvCityName,mTvName;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvCityName = (TextView) itemView.findViewById(R.id.city_name);
            mTvName = (TextView) itemView.findViewById(R.id.city_name_place);
        }

        void setData(PlacesEntity entity){
            mTvCityName.setText(entity.name);
            mTvName.setText(entity.country.name);
        }
    }
}
