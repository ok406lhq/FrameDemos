package app.lhq.ok406.framedemos.imageLoader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import app.lhq.ok406.framedemos.R;
import app.lhq.ok406.framedemos.imageLoader.adapter.ImageLoaderGridViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageLoaderGridViewActivity extends Activity {

    @BindView(R.id.gv_imageloader_gridview)
    GridView gvImageloader;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader_grid_view);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("ImageLoader应用在GridView中");

        ImageLoaderGridViewAdapter adapter = new ImageLoaderGridViewAdapter(this);
        gvImageloader.setAdapter(adapter);
    }
}
