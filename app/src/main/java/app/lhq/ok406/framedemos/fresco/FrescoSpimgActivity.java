package app.lhq.ok406.framedemos.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.fresco
 * 文件名：FrescoSpimgActivity
 * 创建者：lhq
 * 创建时间：2017/12/19 0019 10:02
 * 描述： TODO
 */

public class FrescoSpimgActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.sdv_fresco)
    SimpleDraweeView sdvFresco;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_frescospimg);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("带进度条的图片");

        // 设置带进度条样式
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder.setProgressBarImage
                (new ProgressBarDrawable()).build();

        sdvFresco.setHierarchy(hierarchy);

        // 加载图片地址
        Uri uri = Uri.parse("https://ws1.sinaimg.cn/large/610dc034ly1fir1jbpod5j20ip0newh3.jpg");

        // 设置显示图片
        sdvFresco.setImageURI(uri);
    }
}
