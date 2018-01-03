package app.lhq.ok406.framedemos.fresco;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoModifyActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.sdv_fresco_modify)
    SimpleDraweeView sdvFrescoModify;
    @BindView(R.id.bt_fresco_modify)
    Button btFrescoModify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_modify);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("修改图片");
    }

    @OnClick(R.id.bt_fresco_modify)
    public void onViewClicked() {
        Uri uri = Uri.parse("http://c.hiphotos.baidu.com/image/pic/item/962bd40735fae6cd21a519680db30f2442a70fa1.jpg");

        Postprocessor redMeshPostprocessor = new BasePostprocessor() {
            @Override
            public String getName() {
                return "redMeshPostprocessor";
            }

            //绘制红色点状网格
            @Override
            public void process(Bitmap bitmap) {

                for (int x = 0; x < bitmap.getWidth(); x += 2) {

                    for (int y = 0; y < bitmap.getHeight(); y += 2) {
                        bitmap.setPixel(x, y, Color.RED);
                    }
                }
            }
        };

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setPostprocessor(redMeshPostprocessor)
                .build();

        PipelineDraweeController controller = (PipelineDraweeController)
                Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(sdvFrescoModify.getController())
                        .build();

        sdvFrescoModify.setController(controller);
    }
}
