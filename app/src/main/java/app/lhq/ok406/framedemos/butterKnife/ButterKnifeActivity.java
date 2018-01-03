package app.lhq.ok406.framedemos.butterKnife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import app.lhq.ok406.framedemos.R;
import butterknife.OnClick;

// butterknife
public class ButterKnifeActivity extends Activity {

    @butterknife.BindView(R.id.tv_butterknife)
    TextView tvButterknife;
    @butterknife.BindView(R.id.cb_butterknife)
    CheckBox cbButterknife;
    @butterknife.BindView(R.id.bt_butterknife)
    Button btButterknife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bk);
        butterknife.ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvButterknife.setText("我好喜欢butterknife");
    }

    @OnClick(R.id.cb_butterknife)
    void cbButterknife(View view){
        Toast.makeText(ButterKnifeActivity.this, "点击了checkbox", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.bt_butterknife)
    void btButterknife(View view){
        Toast.makeText(ButterKnifeActivity.this, "点击了button", Toast.LENGTH_SHORT).show();
    }
}

