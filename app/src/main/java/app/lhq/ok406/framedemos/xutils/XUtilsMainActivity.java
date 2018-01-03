package app.lhq.ok406.framedemos.xutils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;

import app.lhq.ok406.framedemos.R;

@ContentView(R.layout.activity_xutils_main)
public class XUtilsMainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xutils_main);

        x.view().inject(this);
    }

    @Event(value = {R.id.btn_annotation, R.id.btn_net, R.id.btn_image, R.id.btn_image_list})
    private void getEvent(View v) {
        switch (v.getId()) {
            case R.id.btn_annotation:
                Intent intent = new Intent(XUtilsMainActivity.this, FragmentXutilActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_net:
                intent = new Intent(XUtilsMainActivity.this, XUtilsNetActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_image:
                Toast.makeText(XUtilsMainActivity.this, "单张图片被点击了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_image_list:
                Toast.makeText(XUtilsMainActivity.this, "列表图片被点击了", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
