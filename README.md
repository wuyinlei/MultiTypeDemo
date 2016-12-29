# MultiTypeDemo
尝试多type类型
###开源交流MyHearts
群号：136471108   群号：136471108    群号：136471108    
###多类型type
也许大家第一眼遇到这样的时候，首先想到的解决方案是使用三个RecyclerView来实现，毕竟是三种type，第二种方案就是根据判断不同的类型来加载不同的布局，并去设置数据。这里用了一个开源库，地址:https://github.com/drakeet/MultiType，采用的思想也是不同的type显示不同的布局，但是却是很大的解耦。自己想添加什么type就添加什么type。对于不同的type，只需要写好自己的adapter就行。其他的无需开发者自己去设计。
#####看下以下实现的结果吧。（图片震慑）

![](http://ww4.sinaimg.cn/mw690/006jcGvzgw1fb6ia9shn3j30u01hc7l5.jpg)

![](http://ww2.sinaimg.cn/mw690/006jcGvzgw1fb6il3tfvtj30u01hc7hi.jpg)
```
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
                            //标记分割
                                Category category = new Category(getResources().getString(R.string.place_id));
                                items.add(category);
                                //添加该标记下的item
                                for (int i = 0; i < mTripsBeen.size(); i++) {
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
```
具体的还是看代码吧。代码里面写的还是比较清晰的。如果不太懂，也可以进行交流，或者看下官方文档怎么使用这个开源库。

