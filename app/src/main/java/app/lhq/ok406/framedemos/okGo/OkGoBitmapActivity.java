package app.lhq.ok406.framedemos.okGo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.okGo
 * 文件名：OkGoBitmapActivity
 * 创建者：lhq
 * 创建时间：2017/12/22 0022 15:22
 * 描述： TODO
 */

public class OkGoBitmapActivity extends Activity {

    @BindView(R.id.btn_post_bitmap)
    Button btnPostBitmap;
    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_go_bitmap_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_post_bitmap)
    public void onViewClicked() {

    }
}
