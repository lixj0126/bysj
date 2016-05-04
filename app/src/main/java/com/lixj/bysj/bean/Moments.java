package com.lixj.bysj.bean;

import cn.bmob.v3.BmobObject;

/**
 * 朋友圈
 * Created by Administrator on 16-5-4.
 */
public class Moments extends BmobObject {
    private String whitelist; //白名单
    private String imgs; //图片，多张以逗号隔开
    private String contents; //文本内容
    private String username; //发表人
    private String userId;  //发表人id

    public String getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(String whitelist) {
        this.whitelist = whitelist;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
