package app.lhq.ok406.framedemos.json.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.json.activity
 * 文件名：JsonStartActivity
 * 创建者：lhq
 * 创建时间：2017/12/15 0015 20:58
 * 描述： TODO
 */

public class JsonStartActivity extends Activity {

    @BindView(R.id.bt1)
    Button bt1;
    @BindView(R.id.bt2)
    Button bt2;
    @BindView(R.id.bt3)
    Button bt3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_startjson);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.bt1, R.id.bt2, R.id.bt3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                Intent intent1 = new Intent(this, NativeJsonPraseActivity.class);
                startActivity(intent1);
                break;
            case R.id.bt2:
                Intent intent2 = new Intent(this, GsonActivity.class);
                startActivity(intent2);
                break;
            case R.id.bt3:
                Intent intent3 = new Intent(this, FastJsonActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
