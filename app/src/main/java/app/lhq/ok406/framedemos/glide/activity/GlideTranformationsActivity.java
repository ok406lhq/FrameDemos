package app.lhq.ok406.framedemos.glide.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import app.lhq.ok406.framedemos.R;
import app.lhq.ok406.framedemos.glide.adapter.GlideTranformationsAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.glide.activity
 * 文件名：GlideTranformationsActivity
 * 创建者：lhq
 * 创建时间：2017/12/15 0015 15:24
 * 描述： TODO
 */

public class GlideTranformationsActivity extends Activity {

    @BindView(R.id.rv_glide_transformations)
    RecyclerView rvGlideTransformations;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_glide_tranformations);
        ButterKnife.bind(this);

        GlideTranformationsAdapter glideRecyclerViewAdapter = new GlideTranformationsAdapter(this);
        rvGlideTransformations.setAdapter(glideRecyclerViewAdapter);
        rvGlideTransformations.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));

    }
}
