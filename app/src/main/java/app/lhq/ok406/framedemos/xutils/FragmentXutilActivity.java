package app.lhq.ok406.framedemos.xutils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import app.lhq.ok406.framedemos.R;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.xutils
 * 文件名：FragmentXutilActivity
 * 创建者：lhq
 * 创建时间：2017/12/17 0017 16:46
 * 描述： TODO
 */

@ContentView(R.layout.activity_xutils3_fragment)
public class FragmentXutilActivity extends FragmentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);
        //1.得到FragmentManger
        FragmentManager fm = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction tt = fm.beginTransaction();
        //3.替换Fragment
        tt.replace(R.id.fl_content, new DemoFragment());
        //4.提交
        tt.commit();
    }
}
