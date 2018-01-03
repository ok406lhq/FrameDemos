package app.lhq.ok406.framedemos.fresco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoActivity extends Activity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_fresco_spimg)
    Button btFrescoSpimg;
    @BindView(R.id.bt_fresco_crop)
    Button btFrescoCrop;
    @BindView(R.id.bt_fresco_circleAndCorner)
    Button btFrescoCircleAndCorner;
    @BindView(R.id.bt_fresco_jpeg)
    Button btFrescoJpeg;
    @BindView(R.id.bt_fresco_gif)
    Button btFrescoGif;
    @BindView(R.id.bt_fresco_multi)
    Button btFrescoMulti;
    @BindView(R.id.bt_fresco_listener)
    Button btFrescoListener;
    @BindView(R.id.bt_fresco_resize)
    Button btFrescoResize;
    @BindView(R.id.bt_fresco_modifyImg)
    Button btFrescoModifyImg;
    @BindView(R.id.bt_fresco_autoSizeImg)
    Button btFrescoAutoSizeImg;
    @BindView(R.id.activity_fresco)
    LinearLayout activityFresco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("Fresco");
    }

    @OnClick({R.id.bt_fresco_spimg, R.id.bt_fresco_crop, R.id.bt_fresco_circleAndCorner, R.id.bt_fresco_jpeg, R.id.bt_fresco_gif, R.id.bt_fresco_multi, R.id.bt_fresco_listener, R.id.bt_fresco_resize, R.id.bt_fresco_modifyImg, R.id.bt_fresco_autoSizeImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //带进度条的图片加载
            case R.id.bt_fresco_spimg:
                startActivity(new Intent(FrescoActivity.this, FrescoSpimgActivity.class));
                break;

            //图片的不同裁剪
            case R.id.bt_fresco_crop:
                startActivity(new Intent(FrescoActivity.this, FrescoCropActivity.class));
                break;

            //圆形和圆角的裁剪
            case R.id.bt_fresco_circleAndCorner:
                startActivity(new Intent(FrescoActivity.this, FrescoCircleAndCornerActivity.class));
                break;

            //渐进式展示图片
            case R.id.bt_fresco_jpeg:
                startActivity(new Intent(FrescoActivity.this, FrescoJpegActivity.class));
                break;

            //GIF动画展示
            case R.id.bt_fresco_gif:
                startActivity(new Intent(FrescoActivity.this, FrescoGifAcitivity.class));
                break;

            //多图请求和图片复用
            case R.id.bt_fresco_multi:
                startActivity(new Intent(FrescoActivity.this, FrescoMultiActivity.class));
                break;

            //图片加载监听
            case R.id.bt_fresco_listener:
                startActivity(new Intent(FrescoActivity.this, FrescoListenerActivity.class));
                break;

            //图片修改和旋转
            case R.id.bt_fresco_resize:
                startActivity(new Intent(FrescoActivity.this, FrescoResizeActivity.class));
                break;

            //修改图片
            case R.id.bt_fresco_modifyImg:
                startActivity(new Intent(FrescoActivity.this, FrescoModifyActivity.class));
                break;

            //动态展示图片
            case R.id.bt_fresco_autoSizeImg:
                startActivity(new Intent(FrescoActivity.this, FrescoAutoSizeActivity.class));
                break;
        }

    }
}
