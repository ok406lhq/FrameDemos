package app.lhq.ok406.framedemos.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoMultiActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.sdv_fresco_multi)
    SimpleDraweeView sdvFrescoMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_multi);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_fresco_multiImg, R.id.bt_fresco_thumbnailImg, R.id.bt_fresco_multiplexImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 先显示低分辨率的图，然后是高分辨率的图
            case R.id.bt_fresco_multiImg:
                //同一张图片，不同品质的两个uri
                Uri lowResUri = Uri.parse("http://img1.gamedog.cn/2012/03/11/19-120311133617-50.jpg");
                Uri highResUri = Uri.parse("http://img5.duitang.com/uploads/item/201312/03/20131203153823_Y4y8F.jpeg");

                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setLowResImageRequest(ImageRequest.fromUri(lowResUri))
                        .setImageRequest(ImageRequest.fromUri(highResUri))
                        .setOldController(sdvFrescoMulti.getController())
                        .build();

                sdvFrescoMulti.setController(controller);
                break;

            // 本地缩略图预览
            case R.id.bt_fresco_thumbnailImg:

                //将本地图片地址转换成Uri
                Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/gakkki.jpg"));
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setLocalThumbnailPreviewsEnabled(true)
                        .build();
                DraweeController controller1 = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(sdvFrescoMulti.getController())
                        .build();
                sdvFrescoMulti.setController(controller1);
                break;

            // 本地图片复用
            case R.id.bt_fresco_multiplexImg:
                //本地图片的复用
                //在请求之前，还会去内存中请求一次图片，没有才会先去本地，最后去网络uri
                //本地准备复用图片的uri  如果本地这个图片不存在，会自动去加载下一个uri

                // 请求加载图片
                Uri uri1 = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/gakkki.jpg"));
                //图片的网络uri
                Uri uri2 = Uri.parse("https://wx3.sinaimg.cn/mw690/ac593e95ly1fmlxrn3gx1j20dw0afjsq.jpg");

                ImageRequest request1 = ImageRequest.fromUri(uri1);
                ImageRequest request2 = ImageRequest.fromUri(uri2);
                ImageRequest[] requests = {request1, request2};

                // 控制加载图片
                DraweeController controller2 = Fresco.newDraweeControllerBuilder()
                        .setFirstAvailableImageRequests(requests)
                        .setOldController(sdvFrescoMulti.getController())
                        .build();

                // 加载图片
                sdvFrescoMulti.setController(controller2);
                break;
        }
    }
}
