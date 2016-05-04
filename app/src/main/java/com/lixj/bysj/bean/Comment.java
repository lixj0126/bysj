package com.lixj.bysj.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 16-5-4.
 */
public class Comment extends BmobObject {
    private String contents; //评论内容
    private String momentId; //朋友圈ID
    private String whitelist; //白名单
    private String commentToId; //评论对方人的ID
    private String commentToName; //评论对方人的名字
    private String commentFromId; //评论人ID
    private String commentFromName; //评论人名字

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getMomentId() {
        return momentId;
    }

    public void setMomentId(String momentId) {
        this.momentId = momentId;
    }

    public String getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(String whitelist) {
        this.whitelist = whitelist;
    }

    public String getCommentToId() {
        return commentToId;
    }

    public void setCommentToId(String commentToId) {
        this.commentToId = commentToId;
    }

    public String getCommentToName() {
        return commentToName;
    }

    public void setCommentToName(String commentToName) {
        this.commentToName = commentToName;
    }

    public String getCommentFromId() {
        return commentFromId;
    }

    public void setCommentFromId(String commentFromId) {
        this.commentFromId = commentFromId;
    }

    public String getCommentFromName() {
        return commentFromName;
    }

    public void setCommentFromName(String commentFromName) {
        this.commentFromName = commentFromName;
    }
}
