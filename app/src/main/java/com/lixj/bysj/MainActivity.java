package com.lixj.bysj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sanjay.selectorphotolibrary.SelectedPhotoActivity;
import com.example.sanjay.selectorphotolibrary.bean.ImgOptions;
import com.example.sanjay.selectorphotolibrary.utils.ImageSchemeUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.newim.BmobIM;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.UploadFileListener;

public class MainActivity extends AppCompatActivity {
    private static final String EXTRA_DATA = "extra_data";

    @Bind(R.id.img)
    ImageView imageView;

    @Bind(R.id.img_tv)
    TextView imgPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        BmobIM.init(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                ArrayList<String> pathList = data.getStringArrayListExtra(EXTRA_DATA);
                for (String path : pathList) {
                    imgPath.setText(path);
                    ImageLoader.getInstance().displayImage(ImageSchemeUtils.autoWrapUrl(path), imageView);
                }
            }
        }
    }

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
}
