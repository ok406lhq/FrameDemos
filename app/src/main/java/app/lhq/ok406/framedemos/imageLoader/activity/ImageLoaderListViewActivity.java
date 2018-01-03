package app.lhq.ok406.framedemos.imageLoader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import app.lhq.ok406.framedemos.R;
import app.lhq.ok406.framedemos.imageLoader.adapter.ImageLoaderListViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageLoaderListViewActivity extends Activity {

    @BindView(R.id.lv_imageloader)
    ListView lvImageloader;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader_list_view);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("ImageLoader应用在ListView中");

        ImageLoaderListViewAdapter adapter = new  ImageLoaderListViewAdapter(this);
        lvImageloader.setAdapter(adapter);
    }
}
