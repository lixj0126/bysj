package com.lixj.bysj.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanjay.selectorphotolibrary.SelectedPhotoActivity;
import com.example.sanjay.selectorphotolibrary.bean.ImgOptions;
import com.example.sanjay.selectorphotolibrary.utils.ImageSchemeUtils;
import com.lixj.bysj.R;
import com.lixj.bysj.adapter.MomentAdapter;
import com.lixj.bysj.bean.Moments;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.newim.BmobIM;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UploadFileListener;

public class MainActivity extends AppCompatActivity {
    private static final String EXTRA_DATA = "extra_data";

    /*
    @Bind(R.id.img)
    ImageView imageView;

    @Bind(R.id.img_tv)
    TextView imgPath;
    */
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    private List<Moments> data = new ArrayList<>();
    MomentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //BmobIM.init(this);
        adapter = new MomentAdapter(this, data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        intiData();
    }

    private void intiData() {
        BmobQuery<Moments> query = new BmobQuery<>();
        query.addWhereContains("whitelist", "s3r7222D");
        query.findObjects(this, new FindListener<Moments>() {
            @Override
            public void onSuccess(List<Moments> list) {
                Toast.makeText(MainActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
                adapter.bindData(list);
            }

            @Override
            public void onError(int i, String s) {
                Toast.makeText(MainActivity.this, "刷新失败：" + s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);

    }

    /**
     * 图片返回结果
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                ArrayList<String> pathList = data.getStringArrayListExtra(EXTRA_DATA);

            }
        }
    }

    /*
    @OnClick(R.id.select_btn)
    public void selectPic() {
        ImgOptions options = new ImgOptions(ImgOptions.MODE_SINGLE, false);
        startActivityForResult(SelectedPhotoActivity.makeIntent(MainActivity.this, options), 0);
    }

    @OnClick(R.id.upload_btn)
    public void upLoad() {
        String picPath = imgPath.getText().toString();
        final BmobFile bmobFile = new BmobFile(new File(picPath));
        bmobFile.uploadblock(this, new UploadFileListener() {

            @Override
            public void onSuccess() {
                //bmobFile.getFileUrl(context)--返回的上传文件的完整地址
                Log.e("11111","上传文件成功:" + bmobFile.getFileUrl(MainActivity.this));
            }

            @Override
            public void onProgress(Integer value) {
                // 返回的上传进度（百分比）
            }

            @Override
            public void onFailure(int code, String msg) {
                Log.e("222222","上传文件失败:" + msg);
            }
        });
    }
    */
}
