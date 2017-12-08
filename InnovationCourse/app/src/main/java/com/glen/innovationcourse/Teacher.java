package com.glen.innovationcourse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heman on 17/10/18.
 */


public class Teacher {
    private String name;
    private int imageId;
    private String desc;

    public Teacher(String name,int imageId,String desc){
        this.name = name;
        this.imageId = imageId;
        this.desc = desc;
    }

    public static List<Teacher> getAllTeachers(){
        List<Teacher> teachers = new ArrayList<Teacher>();

        Teacher kobe = new Teacher("Kobe",R.drawable.kobe,"科比·布莱恩特（Kobe Bryant），" +
                "1978年8月23日出生于美国宾夕法尼亚州费城，前美国职业篮球运动员，司职得分后卫/小前锋（锋卫摇摆人)");
        Teacher t_mac = new Teacher("T-mac",R.drawable.tmac,"特雷西·麦克格雷迪（Tracy McGrady），" +
                "1979年5月24日出生于美国佛罗里达州巴托，前美国职业篮球运动员，司职得分后卫/小前锋。");
        Teacher iverson = new Teacher("Iversion",R.drawable.iverson,"阿伦·艾弗森（Allen Iverson），" +
                "1975年6月7日出生于美国弗吉尼亚州汉普顿，前知名美国职业篮球运动员，司职后卫。");

        teachers.add(kobe);
        teachers.add(t_mac);
        teachers.add(iverson);

        return teachers;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
