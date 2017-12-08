package com.glen.contentproviderdemo1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by heman on 17/12/6.
 */

public class MyPrivoder extends ContentProvider {
    private Context context;
    DBHelper helper = null;
    SQLiteDatabase db = null;

    //设置ContentProvider的唯一标识
    public static final String AUTOHORITY = "com.glen.contentproviderdemo1.MyPrivoder";

    public static final int User_Code = 1;
    public static final int Job_Code = 2;

    //UriMatcher类使用:在ContentProvider 中注册URI
    private static final UriMatcher matcher;
    static {
        /**
         * 初始化
         *  若URI资源路径 = content://com.glen.contentproviderdemo1.MyPrivoder/user ，则返回注册码User_Code
         *  若URI资源路径 = content://com.glen.contentproviderdemo1.MyPrivoder/job ，则返回注册码Job_Code
         */
        matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(AUTOHORITY,"user",User_Code);
        matcher.addURI(AUTOHORITY,"job",Job_Code);
    }

    /**
     * 初始化ContentProvider
     */
    @Override
    public boolean onCreate() {
        context = getContext();
        // 在ContentProvider创建时对数据库进行初始化
        // 运行在主线程，故不能做耗时操作,此处仅作展示
        helper = new DBHelper(getContext());
        db = helper.getWritableDatabase();

        // 初始化两个表的数据(先清空两个表,再各插入两条记录)
        db.execSQL("DELETE FROM user");
        db.execSQL("INSERT INTO user VALUES(1,'Kobe');");
        db.execSQL("INSERT INTO user VALUES(2,'james');");

        db.execSQL("DELETE FROM job");
        db.execSQL("INSERT INTO job VALUES(1,'Android');");
        db.execSQL("INSERT INTO job VALUES(2,'IOS');");

        return true;
    }

    /**
     * 根据URI匹配 URI_CODE，从而匹配ContentProvider中相应的表名
     */
    private String getTableName(Uri uri)
    {
        String tableName = null;
        switch (matcher.match(uri)){
            case User_Code:
                tableName = DBHelper.USER_TABLE_NAME;
                break;
            case Job_Code:
                tableName = DBHelper.JOB_TABLE_NAME;
                break;
        }

        return tableName;
    }

    /**
     * 添加数据
     */
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String table = getTableName(uri);

        //添加数据
        long count = db.insert(table,null,values);
        System.out.println("table name: " + table + ", 插入记录:" + count);

        // 当该URI的ContentProvider数据发生变化时，通知外界（即访问该ContentProvider数据的访问者）
        context.getContentResolver().notifyChange(uri,null);

        // 通过ContentUris类从URL中获取ID
//        long userid = ContentUris.parseId(uri);
//        System.out.println("userID: " + userid);

        return uri;
    }

    /**
     * 查询数据
     */
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        String table = getTableName(uri);

        // 通过ContentUris类从URL中获取ID
//        long userid = ContentUris.parseId(uri);
//        System.out.println(userid);

        // 查询数据
        return db.query(table,projection,selection,selectionArgs,null,null,sortOrder,null);
    }

    //更新数据
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return 0;// 由于不展示,此处不作展开
    }

    //删除数据
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;// 由于不展示,此处不作展开
    }

    @Override
    public String getType(Uri uri) {
        return null;// 由于不展示,此处不作展开
    }
}

