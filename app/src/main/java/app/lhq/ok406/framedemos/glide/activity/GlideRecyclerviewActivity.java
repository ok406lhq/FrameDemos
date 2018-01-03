package app.lhq.ok406.framedemos.glide.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import app.lhq.ok406.framedemos.R;
import app.lhq.ok406.framedemos.glide.adapter.GlideRecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.glide.activity
 * 文件名：GlideRecyclerviewActivity
 * 创建者：lhq
 * 创建时间：2017/12/15 0015 15:21
 * 描述： TODO
 */

public class GlideRecyclerviewActivity extends Activity {

    @BindView(R.id.rv_glide)
    RecyclerView rvGlide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_glide_recyclerview);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        //初始化RecyclerView
        GlideRecyclerViewAdapter glideRecyclerViewAdapter = new GlideRecyclerViewAdapter(this);
        rvGlide.setAdapter(glideRecyclerViewAdapter);
        rvGlide.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
    }
}
