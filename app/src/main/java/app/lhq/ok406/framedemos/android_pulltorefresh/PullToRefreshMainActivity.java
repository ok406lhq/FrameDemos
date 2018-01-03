package app.lhq.ok406.framedemos.android_pulltorefresh;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.android_pulltorefresh
 * 文件名：PullToRefreshMainActivity
 * 创建者：lhq
 * 创建时间：2017/12/27 0027 16:47
 * 描述： TODO
 */

public class PullToRefreshMainActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.listview)
    Button listview;
    @BindView(R.id.gridview)
    Button gridview;
    @BindView(R.id.fragment)
    Button fragment;
    @BindView(R.id.viewpager)
    Button viewpager;
    @BindView(R.id.viewpager2)
    Button viewpager2;
    @BindView(R.id.webview)
    Button webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulltorefresh_main);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        tvTitle.setText("PullToRefresh");
    }

    @OnClick({R.id.listview, R.id.gridview, R.id.fragment, R.id.viewpager, R.id.viewpager2, R.id.webview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.listview:
                startActivity(new Intent(PullToRefreshMainActivity.this, PullToRefreshListActivity.class));
                break;
            case R.id.gridview:
                startActivity(new Intent(PullToRefreshMainActivity.this, PullToRefreshGridActivity.class));
                break;
            case R.id.fragment:
                startActivity(new Intent(PullToRefreshMainActivity.this, PullToRefreshListFragmentActivity.class));
                break;
            case R.id.viewpager:
                startActivity(new Intent(PullToRefreshMainActivity.this, PullToRefreshListInViewPagerActivity.class));
                break;
            case R.id.viewpager2:
                startActivity(new Intent(PullToRefreshMainActivity.this, PullToRefreshViewPagerActivity.class));
                break;
            case R.id.webview:
                startActivity(new Intent(PullToRefreshMainActivity.this, PullToRefreshWebViewActivity.class));
                break;
        }
    }
}
