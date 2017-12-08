package com.glen.innovationcourse;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by heman on 17/10/18.
 */

public class TeacherAdapter extends ArrayAdapter<Teacher> {
    public TeacherAdapter(Context context,int resource,List<Teacher> objects){
        super(context,resource,objects);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent){

        // 获取老师的数据
        final Teacher teacher = getItem(position);

        // 创建布局
        View oneTeacherView = LayoutInflater.from(getContext()).inflate(R.layout.teacher_item,parent,false);

        // 获取布局中的ImageView和TextView
        ImageView imageView = oneTeacherView.findViewById(R.id.teacher_small_imageView);
        TextView textView = oneTeacherView.findViewById(R.id.teacher_name_textView);

        // 根据老师数据设置ImageView和TextView的展现
        imageView.setImageResource(teacher.getImageId());
        textView.setText(teacher.getName());

        oneTeacherView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //这里进行跳转

                //  初始化一个准备跳转到TeacherDetailActivity的Intent
                Intent intent = new Intent(getContext(),TeacherDetailActivity.class);

                intent.putExtra("teacher_image",teacher.getImageId());
                intent.putExtra("teacher_desc",teacher.getDesc());

                //  初始化一个准备跳转到TeacherDetailActivity的Intent
                getContext().startActivity(intent);
            }
        });

        return oneTeacherView;
    }

}
