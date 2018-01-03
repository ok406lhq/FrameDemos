package app.lhq.ok406.framedemos.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoJpegActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.sdv_fresco_jpeg)
    SimpleDraweeView sdvFrescoJpeg;
    @BindView(R.id.sdv_fresco_askImg)
    Button sdvFrescoAskImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_jpeg);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("渐进式展示图片");
    }

    @OnClick(R.id.sdv_fresco_askImg)
    public void onViewClicked() {
        // 加载质量配置
        ProgressiveJpegConfig jpegConfig = new ProgressiveJpegConfig() {
            @Override
            public int getNextScanNumberToDecode(int scanNumber) {
                return scanNumber + 2;
            }

            @Override
            public QualityInfo getQualityInfo(int scanNumber) {
                boolean isGoodEnough = (scanNumber >= 5);

                return ImmutableQualityInfo.of(scanNumber, isGoodEnough, false);
            }
        };

        ImagePipelineConfig.newBuilder(this).setProgressiveJpegConfig(jpegConfig).build();
        // 获取图片URL
        Uri uri = Uri.parse("http://cdn.duitang.com/uploads/item/201303/12/20130312021353_45Qix.jpeg");

        // 获取图片请求
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri).setProgressiveRenderingEnabled(true).build();

        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setTapToRetryEnabled(true)
                .setOldController(sdvFrescoJpeg.getController())//使用oldController可以节省不必要的内存分配
                .build();

        // 设置加载的控制
        sdvFrescoJpeg.setController(draweeController);
    }
}
