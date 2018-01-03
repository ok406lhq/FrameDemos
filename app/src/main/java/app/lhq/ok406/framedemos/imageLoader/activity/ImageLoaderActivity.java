package app.lhq.ok406.framedemos.imageLoader.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageLoaderActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_imageloader_listview)
    Button btImageloaderListview;
    @BindView(R.id.bt_imageloader_gridview)
    Button btImageloaderGridview;
    @BindView(R.id.bt_imageloader_viewpager)
    Button btImageloaderViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("ImageLoader");
    }

    @OnClick({R.id.bt_imageloader_listview, R.id.bt_imageloader_gridview, R.id.bt_imageloader_viewpager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //在listView中展示图片
            case R.id.bt_imageloader_listview:
                startActivity(new Intent(ImageLoaderActivity.this, ImageLoaderListViewActivity.class));
                break;
            case R.id.bt_imageloader_gridview:
                startActivity(new Intent(ImageLoaderActivity.this, ImageLoaderGridViewActivity.class));
                break;
            case R.id.bt_imageloader_viewpager:
                startActivity(new Intent(ImageLoaderActivity.this, ImageLoaderViewPagerActivity.class));
                break;
        }
    }
}
