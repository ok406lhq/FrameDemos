package app.lhq.ok406.framedemos.glide.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;

import java.io.File;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.glide.activity
 * 文件名：GlideBaseActivity
 * 创建者：lhq
 * 创建时间：2017/12/15 0015 10:21
 * 描述： TODO
 */

public class GlideBaseActivity extends Activity {

    @BindView(R.id.iv_2)
    ImageView iv2;
    @BindView(R.id.iv_3)
    ImageView iv3;
    @BindView(R.id.iv_4)
    ImageView iv4;
    @BindView(R.id.iv_5)
    ImageView iv5;
    @BindView(R.id.iv_6)
    ImageView iv6;
    @BindView(R.id.iv_7)
    ImageView iv7;
    @BindView(R.id.iv_8)
    ImageView iv8;
    @BindView(R.id.iv_9)
    ImageView iv9;
    @BindView(R.id.iv_1)
    ImageView iv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        //1加载网络图片
        Glide.with(this).load("https://ws1.sinaimg.cn/large/610dc034ly1fir1jbpod5j20ip0newh3.jpg")
                .into(iv1);

        //2加载资源图片
        Glide.with(this).load(R.mipmap.miguli).into(iv2);

        //3加载本地图片
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/gakki.jpg";
        Log.i("LogAboutStorageDirector", Environment.getExternalStorageDirectory().getAbsolutePath());
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        Glide.with(this).load(uri).into(iv3);

        //4加载网络gif
        String gifUrl = "https://wx2.sinaimg.cn/mw690/b04ba951gy1fmdzhk3scvg20ci069x6p.gif";
        Glide.with(this).load(gifUrl).placeholder(R.mipmap.ic_launcher).into(iv4);

        //5加载资源gif
        Glide.with(this).load(R.mipmap.gakki).asGif().placeholder(R.mipmap.ic_launcher).into(iv5);

        //6加载本地gif
        String gifPath = Environment.getExternalStorageDirectory() + "/nv.gif";
        File gifFile = new File(gifPath);
        Glide.with(this).load(gifFile).placeholder(R.mipmap.ic_launcher).into(iv6);

        //7加载本地小视频和快照
        String videoPath = Environment.getExternalStorageDirectory() + "/ddmerec.mp4";
        File videoFile = new File(videoPath);
        Glide.with(this).load(Uri.fromFile(videoFile)).placeholder(R.mipmap.ic_launcher).into(iv7);

        //8设置缩略图比例,然后，先加载缩略图，再加载原图
        String urlPath="/storage/emulated/0/gakkki.jpg";
        Glide.with(this).load(new File(urlPath)).thumbnail(0.1f).
                centerCrop().placeholder(R.mipmap.ic_launcher).into(iv8);

        //9先建立一个缩略图对象，然后，先加载缩略图，再加载原图
        DrawableRequestBuilder thumbnailRequest=  Glide.with(this).load(new File(urlPath));
        Glide.with(this).load(Uri.fromFile(videoFile)).thumbnail(thumbnailRequest).
                centerCrop().placeholder(R.mipmap.ic_launcher).into(iv9);
    }
}
