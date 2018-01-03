package app.lhq.ok406.framedemos.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoCircleAndCornerActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.sdv_fresco_circleandcorner)
    SimpleDraweeView sdvFrescoCircleandcorner;
    @BindView(R.id.bt_fresco_circle)
    Button btFrescoCircle;
    @BindView(R.id.bt_fresco_corner)
    Button btFrescoCorner;
    private GenericDraweeHierarchyBuilder builder;
    private Uri uri;
    private RoundingParams parames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_circle_and_corner);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("圆形和圆角剪裁");

        uri = Uri.parse("http://img4q.duitang.com/uploads/item/201304/27/20130427043538_wAfHC.jpeg");
        builder = new GenericDraweeHierarchyBuilder(getResources());

    }

    @OnClick({R.id.bt_fresco_circle, R.id.bt_fresco_corner})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            // 设置圆形图片
            case R.id.bt_fresco_circle:
                // 设置圆形图片
                parames = RoundingParams.asCircle();
                GenericDraweeHierarchy hierarchy = builder.setRoundingParams(parames).build();
                sdvFrescoCircleandcorner.setHierarchy(hierarchy);

                sdvFrescoCircleandcorner.setImageURI(uri);
                break;

            //设置圆角图片
            case R.id.bt_fresco_corner:

                parames = RoundingParams.fromCornersRadius(50f);
                parames.setOverlayColor(getResources().getColor(android.R.color.holo_red_light));//覆盖层
                parames.setBorder(getResources().getColor(android.R.color.holo_blue_light), 5);//边框

                sdvFrescoCircleandcorner.setHierarchy(builder.setRoundingParams(parames).build());

                // 加载图片
                sdvFrescoCircleandcorner.setImageURI(uri);

                break;
        }
    }
}
