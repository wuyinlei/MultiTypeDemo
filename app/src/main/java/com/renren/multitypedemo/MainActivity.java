package com.renren.multitypedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpHeaders;
import com.renren.multitypedemo.Items.DataEntity.PlacesEntity;
import com.renren.multitypedemo.Items.DataEntity.TripsEntity;
import com.renren.multitypedemo.Items.DataEntity.UsersEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import me.drakeet.multitype.MultiTypeAdapter;
import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private List<Object> items;
    private MultiTypeAdapter mMultiTypeAdapter;
    private RecyclerView mRecyclerView;
    private Category mCategory;
    private List<TripsEntity> mTripsBeen = new ArrayList<>();
    private List<PlacesEntity> mPlacesBeen = new ArrayList<>();
    private List<UsersEntity> mUsersBeen = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkGo.get(HttpUrlController.getSearchTripResult(getResources().getString(R.string.beijing)))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Items data = new
                                Gson().fromJson(s,
                                new TypeToken<Items>() {
                                }.getType());
                        if (data != null) {
                            mPlacesBeen = data.data.places;
                            if (mPlacesBeen.size() > 0) {
                                Category mCategory = new Category(getResources().getString(R.string.city_name));
                                items.add(mCategory);
                                items.add(mPlacesBeen);
                            }

                            mTripsBeen = data.data.trips;
                            if (mTripsBeen.size() > 0) {
                                Category mCategory = new Category(getResources().getString(R.string.place_id));
                                items.add(mCategory);
                                items.add(mPlacesBeen);
                            }
                            mUsersBeen = data.data.users;
                            if (mUsersBeen.size() > 0) {
                                Category mCategory = new Category(getResources().getString(R.string.mianyou));
                                items.add(mCategory);
                                items.add(mPlacesBeen);
                            }
                        }

                    }
                });
    }
}
