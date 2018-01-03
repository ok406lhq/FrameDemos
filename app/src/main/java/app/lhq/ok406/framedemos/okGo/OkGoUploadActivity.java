package app.lhq.ok406.framedemos.okGo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OkGoUploadActivity extends Activity {

    private static final String TAG = OkGoUploadActivity.class.getSimpleName();
    @BindView(R.id.btn_uploadfile)
    Button btnUploadfile;
    @BindView(R.id.tv_result)
    TextView tvResult;

    private static String Fileurl = "http://server.jeasonlzy.com/OkHttpUtils/upload";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_go_upload);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_uploadfile)
    public void onViewClicked() {
        OkGo.<String>post(Fileurl).tag(this)
                .headers("aaa", "111")
//                .params("bbb", "222")
//                .params("fileKey1" , new File(Environment.getExternalStorageDirectory()+"ddmsrec.mp4"))//
//                .isMultipart(true)
                .upString("这是要上传的文本！")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e(TAG, response.body()+TAG);
                        tvResult.setText(response.body());
                        Toast.makeText(OkGoUploadActivity.this,response.message(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Log.e(TAG, response.body() );
                    }

                });
    }
}
