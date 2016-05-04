package com.lixj.bysj.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 16-5-4.
 */
public class Reply extends BmobObject {
    private String commentId; // 评论id
    private String contents; // 回复内容
    private String whitelist; //白名单

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(String whitelist) {
        this.whitelist = whitelist;
    }
}
