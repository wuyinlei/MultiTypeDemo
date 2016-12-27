package com.renren.multitypedemo;

/**
 * Created by Administrator on 2016/12/27.
 */

public class HttpUrlController {

    //基准url
    private static final String BASE_URL = "http://api.breadtrip.com/";

    //http://api.breadtrip.com/v2/search/?key=上海&start=0&count=20&data_type=

    public static final String getSearchTripResult(String key) {
        return BASE_URL + "v2/search/?key=" + key;
    }

}
