package app.lhq.ok406.framedemos.banner.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import app.lhq.ok406.framedemos.MyApplication;
import app.lhq.ok406.framedemos.R;
import app.lhq.ok406.framedemos.banner.loader.GlideImageLoader;

public class CustomBannerActivity extends AppCompatActivity {
    Banner banner1,banner2,banner3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_banner);
        banner1 = (Banner) findViewById(R.id.banner1);
        banner2 = (Banner) findViewById(R.id.banner2);
        banner3 = (Banner) findViewById(R.id.banner3);

        banner1.setImages(MyApplication.images)
                .setImageLoader(new GlideImageLoader())
                .start();

        banner2.setImages(MyApplication.images)
                .setImageLoader(new GlideImageLoader())
                .start();

        banner3.setImages(MyApplication.images)
                .setBannerTitles(MyApplication.titles)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImageLoader(new GlideImageLoader())
                .start();
    }
}
