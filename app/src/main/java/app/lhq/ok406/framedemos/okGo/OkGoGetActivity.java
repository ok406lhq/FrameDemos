package app.lhq.ok406.framedemos.okGo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OkGoGetActivity extends Activity {

    @BindView(R.id.get)
    Button get;
    @BindView(R.id.post)
    Button post;
    @BindView(R.id.response)
    TextView rs;

    private static String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_go_get);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.get, R.id.post})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.get:
                OkGo.<String>get(url).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        rs.setText(response.body());
                    }
                });
                break;
            case R.id.post:
                OkGo.<String>get(url).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        rs.setText(response.body());
                    }
                });
                break;
        }
    }
}
