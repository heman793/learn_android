package com.glen.uielementdemo;

/**
 * Created by heman on 17/11/16.
 */

public class NBAStar {
    private String name;
    private String motto;
    private int icon;

    public NBAStar(){}

    public NBAStar(String name,String motto,int icon){
        this.name = name;
        this.motto = motto;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

}
