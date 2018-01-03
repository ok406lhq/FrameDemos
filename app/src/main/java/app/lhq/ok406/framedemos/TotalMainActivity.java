package app.lhq.ok406.framedemos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.lhq.ok406.framedemos.afinal.AfinalActivity;
import app.lhq.ok406.framedemos.android_pulltorefresh.PullToRefreshMainActivity;
import app.lhq.ok406.framedemos.banner.activity.BannerMainActivity;
import app.lhq.ok406.framedemos.butterKnife.ButterKnifeActivity;
import app.lhq.ok406.framedemos.countdownview.MainActivity;
import app.lhq.ok406.framedemos.fresco.FrescoActivity;
import app.lhq.ok406.framedemos.glide.activity.GlideActivity;
import app.lhq.ok406.framedemos.imageLoader.activity.ImageLoaderActivity;
import app.lhq.ok406.framedemos.jiecaovideoPlayer.activity.JCVMainActivity;
import app.lhq.ok406.framedemos.json.activity.JsonStartActivity;
import app.lhq.ok406.framedemos.okGo.OKGoMainActivity;
import app.lhq.ok406.framedemos.opendanmaku.OpenDanmakuMainActivity;
import app.lhq.ok406.framedemos.picasso.activity.PicassoActivity;
import app.lhq.ok406.framedemos.recyclerview.RecyclerViewActivity;
import app.lhq.ok406.framedemos.universalvideoview.UniversalVideoViewActivity;
import app.lhq.ok406.framedemos.volley.VolleyActivity;
import app.lhq.ok406.framedemos.xutils.XUtilsMainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos
 * 文件名：TotalMainActivity
 * 创建者：lhq
 * 创建时间：2017/12/30 0030 14:07
 * 描述： TODO
 */

public class TotalMainActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_afinal)
    Button btnAfinal;
    @BindView(R.id.btn_pulltorefresh)
    Button btnPulltorefresh;
    @BindView(R.id.btn_banner)
    Button btnBanner;
    @BindView(R.id.btn_butterknife)
    Button btnButterknife;
    @BindView(R.id.btn_countdownview)
    Button btnCountdownview;
    @BindView(R.id.btn_eventbus)
    Button btnEventbus;
    @BindView(R.id.btn_fresco)
    Button btnFresco;
    @BindView(R.id.btn_glide)
    Button btnGlide;
    @BindView(R.id.btn_imageloader)
    Button btnImageloader;
    @BindView(R.id.btn_jiecaovideoplayer)
    Button btnJiecaovideoplayer;
    @BindView(R.id.btn_json)
    Button btnJson;
    @BindView(R.id.btn_okgo)
    Button btnOkgo;
    @BindView(R.id.btn_opendanmaku)
    Button btnOpendanmaku;
    @BindView(R.id.btn_picasso)
    Button btnPicasso;
    @BindView(R.id.btn_recyclerview)
    Button btnRecyclerview;
    @BindView(R.id.btn_universalvideoview)
    Button btnUniversalvideoview;
    @BindView(R.id.btn_volley)
    Button btnVolley;
    @BindView(R.id.btn_xutils)
    Button btnXutils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_main);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("集成框架库");
    }

    @OnClick({R.id.titlebar, R.id.btn_afinal, R.id.btn_pulltorefresh, R.id.btn_banner, R.id.btn_butterknife, R.id.btn_countdownview, R.id.btn_eventbus, R.id.btn_fresco, R.id.btn_glide, R.id.btn_imageloader, R.id.btn_jiecaovideoplayer, R.id.btn_json, R.id.btn_okgo, R.id.btn_opendanmaku, R.id.btn_picasso, R.id.btn_recyclerview, R.id.btn_universalvideoview, R.id.btn_volley, R.id.btn_xutils})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            //Afinal
            case R.id.btn_afinal:
                startActivity(new Intent(TotalMainActivity.this, AfinalActivity.class));
                break;

            //PullToRefresh
            case R.id.btn_pulltorefresh:
                startActivity(new Intent(TotalMainActivity.this, PullToRefreshMainActivity.class));
                break;

            //Banner
            case R.id.btn_banner:
                startActivity(new Intent(TotalMainActivity.this, BannerMainActivity.class));
                break;

            //ButterKnife
            case R.id.btn_butterknife:
                startActivity(new Intent(TotalMainActivity.this, ButterKnifeActivity.class));
                break;

            //CountdownView
            case R.id.btn_countdownview:
                startActivity(new Intent(TotalMainActivity.this, MainActivity.class));
                break;

            //EventBus
            case R.id.btn_eventbus:
                startActivity(new Intent(TotalMainActivity.this, app.lhq.ok406.framedemos.eventbus.MainActivity.class));
                break;

            //Fresco
            case R.id.btn_fresco:
                startActivity(new Intent(TotalMainActivity.this, FrescoActivity.class));
                break;

            //Glide
            case R.id.btn_glide:
                startActivity(new Intent(TotalMainActivity.this, GlideActivity.class));
                break;

            //ImageLoader
            case R.id.btn_imageloader:
                startActivity(new Intent(TotalMainActivity.this, ImageLoaderActivity.class));
                break;

            //JiecaoVideoPlayer
            case R.id.btn_jiecaovideoplayer:
                startActivity(new Intent(TotalMainActivity.this, JCVMainActivity.class));
                break;

            //Json
            case R.id.btn_json:
                startActivity(new Intent(TotalMainActivity.this, JsonStartActivity.class));
                break;

            //OkGo
            case R.id.btn_okgo:
                startActivity(new Intent(TotalMainActivity.this, OKGoMainActivity.class));
                break;

            //OpenDanmaku
            case R.id.btn_opendanmaku:
                startActivity(new Intent(TotalMainActivity.this, OpenDanmakuMainActivity.class));
                break;

            //Picasso
            case R.id.btn_picasso:
                startActivity(new Intent(TotalMainActivity.this, PicassoActivity.class));
                break;

            //RecyclerView
            case R.id.btn_recyclerview:
                startActivity(new Intent(TotalMainActivity.this, RecyclerViewActivity.class));
                break;

            //UniversalvideoView
            case R.id.btn_universalvideoview:
                startActivity(new Intent(TotalMainActivity.this, UniversalVideoViewActivity.class));
                break;

            //Volley
            case R.id.btn_volley:
                startActivity(new Intent(TotalMainActivity.this, VolleyActivity.class));
                break;

            //XUtils3
            case R.id.btn_xutils:
                startActivity(new Intent(TotalMainActivity.this, XUtilsMainActivity.class));
                break;
        }
    }
}
