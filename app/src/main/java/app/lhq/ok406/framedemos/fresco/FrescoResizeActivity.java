package app.lhq.ok406.framedemos.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoResizeActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.sdv_fresco_resize)
    SimpleDraweeView sdvFrescoResize;
    @BindView(R.id.bt_fresco_resize)
    Button btFrescoResize;
    @BindView(R.id.bt_fresco_rotate)
    Button btFrescoRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_resize);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("图片旋转与缩放");
    }

    @OnClick({R.id.bt_fresco_resize, R.id.bt_fresco_rotate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //图片缩放
            case R.id.bt_fresco_resize:

                int width = 50;
                int height = 50;

                Uri uri = Uri.parse("https://wx3.sinaimg.cn/mw690/802e31b8ly1fmm1qaajtaj202s028q2y.jpg");

                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setResizeOptions(new ResizeOptions(width, height)).build();

                PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setOldController(sdvFrescoResize.getController())
                        .setImageRequest(request)
                        .build();

                sdvFrescoResize.setController(controller);
                break;

            //图片旋转
            case R.id.bt_fresco_rotate:
                Uri uri2 = Uri.parse("https://wx3.sinaimg.cn/mw690/802e31b8ly1fmm1qaajtaj202s028q2y.jpg");

                ImageRequest request1 = ImageRequestBuilder.newBuilderWithSource(uri2)
                        .setAutoRotateEnabled(true).build();

                DraweeController controller1 = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request1)
                        .setOldController(sdvFrescoResize.getController()).build();

                sdvFrescoResize.setController(controller1);
                break;
        }
    }
}
