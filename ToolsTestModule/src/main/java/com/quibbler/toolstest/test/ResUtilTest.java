package com.quibbler.toolstest.test;

import android.content.Context;
import android.util.Log;

import com.quibbler.androidtools.AndroidTools;
import com.quibbler.androidtools.resource.ResourceUtilKt;
import com.quibbler.toolstest.R;

public class ResUtilTest {

    public static void test(Context context) {
        int id = ResourceUtilKt.getDrawableResIdByName("ic_launcher_background");
        Log.d(AndroidTools.TAG, "id1 " + id);

        id = ResourceUtilKt.getResIdByName("ic_launcher_background", "drawable", context.getPackageName());
        Log.d(AndroidTools.TAG, "id2 " + id);

        id = ResourceUtilKt.getStringResIdByName("hello_world");
        Log.d(AndroidTools.TAG, "str " + context.getString(id));

        id = ResourceUtilKt.getColorResIdByName("black");
        Log.d(AndroidTools.TAG, "color " + id + "\t " + R.color.black);

    }

}
