package com.lixj.bysj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lixj.bysj.R;
import com.lixj.bysj.bean.Comment;
import com.lixj.bysj.bean.Moments;
import com.lixj.bysj.view.CommentLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 16-5-4.
 */
public class MomentHolder extends RecyclerView.ViewHolder {

    private Context mContext;

    @Bind(R.id.tv_moment_content)
    TextView contentTv;
    @Bind(R.id.ll_moment_commnet)
    LinearLayout linearLayout;

    public MomentHolder(Context context, ViewGroup root, int layoutRes) {
        super(LayoutInflater.from(context).inflate(layoutRes, root, false));
        this.mContext=context;
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Moments data) {
        contentTv.setText(data.getContents());
        queryComments(data);
    }

    /**
     * 评论
     */
    @OnClick(R.id.btn_moment_comment)
    public void comment() {
        Toast.makeText(mContext, "评论", Toast.LENGTH_SHORT).show();
    }

    /**
     * 查询评论
     */
    private void queryComments(Moments data) {
        Log.e("数据", data.getObjectId());
        BmobQuery<Comment> query = new BmobQuery<>();
        query.addWhereContains("whitelist", "s3r7222D");
        query.addWhereEqualTo("momentId", data.getObjectId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date date = null;

        try {
            date = sdf.parse(data.getCreatedAt());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        query.addWhereGreaterThanOrEqualTo("createdAt", new BmobDate(date));
        query.findObjects(mContext, new FindListener<Comment>() {
            @Override
            public void onSuccess(List<Comment> list) {
                Log.e("成功----", list.size()+"");
                for (int i = 0; i < list.size(); i++) {
                    View v = new CommentLayout(mContext, list.get(i)).getCommentLayout();
                    linearLayout.addView(v);
                }
            }

            @Override
            public void onError(int i, String s) {
                Log.e("评论错误", s);
            }
        });

    }
}
