package app.lhq.ok406.framedemos.okGo;

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
 * 包名：app.lhq.ok406.framedemos.okGo
 * 文件名：OKGoMainActivity
 * 创建者：lhq
 * 创建时间：2017/12/22 0022 15:12
 * 描述： TODO
 */

public class OKGoMainActivity extends Activity {

    @BindView(R.id.btn_get_post)
    Button btnGetPost;
    @BindView(R.id.btn_downloadfile)
    Button btnDownloadfile;
    @BindView(R.id.btn_uploadfile)
    Button btnUploadfile;
    @BindView(R.id.btn_post_bitmap)
    Button btnPostBitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_okgo);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_get_post, R.id.btn_downloadfile, R.id.btn_uploadfile, R.id.btn_post_bitmap})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_post:
                startActivity(new Intent(OKGoMainActivity.this,OkGoGetActivity.class));
                break;
            case R.id.btn_downloadfile:
                startActivity(new Intent(OKGoMainActivity.this,OkGoDownloadActivity.class));
                break;
            case R.id.btn_uploadfile:
                startActivity(new Intent(OKGoMainActivity.this,OkGoUploadActivity.class));
                break;
            case R.id.btn_post_bitmap:
                startActivity(new Intent(OKGoMainActivity.this,OkGoBitmapActivity.class));
                break;
        }
    }
}
