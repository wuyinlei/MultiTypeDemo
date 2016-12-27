package com.renren.multitypedemo;

import me.drakeet.multitype.GlobalMultiTypePool;

/**
 * Created by Administrator on 2016/12/27.
 */

public class MultiTypeInstaller {

    static void start() {
        GlobalMultiTypePool.register(Category.class, new CategoryItemViewProvider());
    }
}
