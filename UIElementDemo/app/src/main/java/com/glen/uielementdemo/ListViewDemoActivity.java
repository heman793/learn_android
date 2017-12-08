package com.glen.uielementdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class ListViewDemoActivity extends AppCompatActivity {

    private List<NBAStar> data = null;
    private Context context;
    private NBAStarAdapter adapter = null;
    private ListView list_nabStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        context = ListViewDemoActivity.this;
        list_nabStar = (ListView) findViewById(R.id.list_nbastars);

        //动态加载顶部View和底部View
        final LayoutInflater inflater = LayoutInflater.from(this);
        View headView = inflater.inflate(R.layout.view_header,null,false);
        View footerView = inflater.inflate(R.layout.view_footer,null,false);

        data = new LinkedList<NBAStar>();
        data.add(new NBAStar("Kobe","To bo No.1!",R.drawable.kobe));
        data.add(new NBAStar("T-Mac","I have a dream",R.drawable.tmac));
        data.add(new NBAStar("Aiverson","Never Give Up",R.drawable.iverson));
        data.add(new NBAStar("Jordan","No.1",R.drawable.jordan));
        data.add(new NBAStar("James","why not No.1",R.drawable.james));
        adapter = new NBAStarAdapter((LinkedList<NBAStar>)data,context);

        //添加表头和表尾
        list_nabStar.addHeaderView(headView);
        list_nabStar.addFooterView(footerView);

        list_nabStar.setAdapter(adapter);
    }

}
