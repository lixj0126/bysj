package com.lixj.bysj.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lixj.bysj.R;
import com.lixj.bysj.bean.Comment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 16-5-4.
 */
public class CommentLayout {
    private TextView textView;
    private Button button;

    private Context context;
    private Comment data;

    public CommentLayout(Context context, Comment data) {
        this.context = context;
        this.data = data;
    }

    public View getCommentLayout() {
        View v = LayoutInflater.from(context).inflate(R.layout.item_moment_comment, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        v.setLayoutParams(params);

        textView = (TextView) v.findViewById(R.id.tv_moment_comment_content);
        textView.setText(data.getContents());

        button = (Button) v.findViewById(R.id.btn_moment_comment_reply);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("回复", "回复");
            }
        });
        return v;
    }
}
