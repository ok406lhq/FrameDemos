package app.lhq.ok406.framedemos.imageLoader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import app.lhq.ok406.framedemos.R;
import app.lhq.ok406.framedemos.imageLoader.adapter.ImageLoaderViewPagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageLoaderViewPagerActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.vp_imageloader_viewpager)
    ViewPager vpImageloaderViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader_view_pager);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("ImageLoader应用在ViewPager中");

        ImageLoaderViewPagerAdapter adapter = new ImageLoaderViewPagerAdapter(this);
        vpImageloaderViewpager.setAdapter(adapter);
    }
}
