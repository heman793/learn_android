package com.glen.contentproviderdemo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * Created by heman on 17/12/5.
 */

public class FirstProvider extends ContentProvider {

    //第一次创建该 ContentProvider 时调用该方法
    @Override
    public boolean onCreate() {
        System.out.println("=== onCreate方法被调用 ===");
        return false;
    }

    //该方法的返回值代表了该 ContentProvider 所提供数据的 MIME 类型
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    //实现查询方法，返回查询得到的Cursor
    @Override
    public Cursor query(Uri uri,  String[] projection,
                        String where,String[] whereArgs,String sortOrder) {
        System.out.println(uri + "=== query方法被调用 ===");
        System.out.println("where参数为：" + where);
        return null;
    }

    //实现插入方法，返回被更新的记录条数
    @Override
    public Uri insert(Uri uri,ContentValues values) {
        System.out.println(uri + "=== insert方法被调用 ===");
        System.out.println("values参数为：" + values);
        return null;
    }

    //实现修改方法，返回被更新的记录条数
    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        System.out.println(uri + "=== update方法被调用 ===");
        System.out.println("where参数为：" + where
                +  ",values参数为："+ values);
        return 3;
    }

    //实现插入方法，返回被删除的记录条数
    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        System.out.println(uri + "=== delete方法被调用 ===");
        System.out.println("where参数为：" + where);
        return 2;
    }
}


