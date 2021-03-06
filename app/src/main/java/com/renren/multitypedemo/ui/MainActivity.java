package com.renren.multitypedemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.renren.multitypedemo.url.HttpUrlController;
import com.renren.multitypedemo.R;
import com.renren.multitypedemo.adapter.SceneAdapter;
import com.renren.multitypedemo.adapter.TripAdapter;
import com.renren.multitypedemo.adapter.UserAdapter;
import com.renren.multitypedemo.bean.Items;
import com.renren.multitypedemo.bean.Items.DataEntity.PlacesEntity;
import com.renren.multitypedemo.bean.Items.DataEntity.TripsEntity;
import com.renren.multitypedemo.bean.Items.DataEntity.UsersEntity;
import com.renren.multitypedemo.bean.Category;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;
import me.drakeet.multitype.MultiTypeAsserts;
import okhttp3.Call;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private List<Object> items = new ArrayList<>();
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
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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
                                Category category = new Category(getResources().getString(R.string.city_name));
                                items.add(category);
                                for (int i = 0; i < mPlacesBeen.size(); i++) {
                                    items.add(mPlacesBeen.get(i));
                                }

                            }

                            mTripsBeen = data.data.trips;
                            if (mTripsBeen.size() > 0) {
                                Category category = new Category(getResources().getString(R.string.place_id));
                                items.add(category);
                                for (int i = 0; i < mTripsBeen.size(); i++) {  //还有这个地方要一个一个添加,要不然就会出现错误
                                    items.add(mTripsBeen.get(i));
                                }

                            }
                            mUsersBeen = data.data.users;
                            if (mUsersBeen.size() > 0) {
                                Category category = new Category(getResources().getString(R.string.mianyou));
                                items.add(category);
                                for (int i = 0; i < mUsersBeen.size(); i++) {
                                    items.add(mUsersBeen.get(i));
                                }

                            }

                            mMultiTypeAdapter = new MultiTypeAdapter(items);
                            mMultiTypeAdapter.applyGlobalMultiTypePool();
                            mMultiTypeAdapter.register(Items.DataEntity.PlacesEntity.class,new SceneAdapter());
                            mMultiTypeAdapter.register(Items.DataEntity.TripsEntity.class,new TripAdapter());
                            mMultiTypeAdapter.register(Items.DataEntity.UsersEntity.class,new UserAdapter());
                            //这里必须要注册一下,要不然会报错
                            MultiTypeAsserts.assertAllRegistered(mMultiTypeAdapter,items);
                            mRecyclerView.setAdapter(mMultiTypeAdapter);

                        }

                    }
                });
    }
}
