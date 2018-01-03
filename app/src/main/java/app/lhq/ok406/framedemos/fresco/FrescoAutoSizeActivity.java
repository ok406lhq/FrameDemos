package app.lhq.ok406.framedemos.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FrescoAutoSizeActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_fresco_loadsmall)
    Button btFrescoLoadsmall;
    @BindView(R.id.ll_fresco)
    LinearLayout llFresco;

    private SimpleDraweeView simpleDraweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_auto_size);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("动态展示图片");
    }

    @OnClick(R.id.bt_fresco_loadsmall)
    public void onViewClicked() {
        simpleDraweeView = new SimpleDraweeView(this);
        simpleDraweeView.setAspectRatio(1.0f);

        final Uri uri = Uri.parse("http://img4q.duitang.com/uploads/item/201304/27/20130427043538_wAfHC.jpeg");

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .build();

        PipelineDraweeController controller = (PipelineDraweeController)
                Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(simpleDraweeView.getController())
                        .build();

        simpleDraweeView.setController(controller);

        llFresco.addView(simpleDraweeView);
    }
}
