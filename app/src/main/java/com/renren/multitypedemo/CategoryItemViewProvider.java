/*
 * Copyright 2016 drakeet. https://github.com/drakeet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.renren.multitypedemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.renren.multitypedemo.bean.Category;

import me.drakeet.multitype.ItemViewProvider;

/**
 * @author drakeet
 */
public class CategoryItemViewProvider
    extends ItemViewProvider<Category, CategoryItemViewProvider.ViewHolder> {

    @NonNull @Override protected ViewHolder onCreateViewHolder(
        @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_title_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull final ViewHolder holder, @NonNull final Category category) {
        holder.title.setText(category.title);
        holder.mReCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), category.title, Toast.LENGTH_SHORT).show();
            }
        });
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        @NonNull private final TextView title;
        private RelativeLayout mReCategory;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_category);
            mReCategory = (RelativeLayout) itemView.findViewById(R.id.re_category);
        }
    }
}
