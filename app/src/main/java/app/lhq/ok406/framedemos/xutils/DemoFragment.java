package app.lhq.ok406.framedemos.xutils;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import app.lhq.ok406.framedemos.R;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.xutils
 * 文件名：DemoFragment
 * 创建者：lhq
 * 创建时间：2017/12/17 0017 16:53
 * 描述： TODO
 */

@ContentView(R.layout.fragment_demo)
public class DemoFragment extends Fragment {

    @ViewInject(R.id.btn_fragment)
    private Button button;

    @ViewInject(R.id.tv_text)
    private TextView textView;

    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "我是按钮，我在fragment中初始化，并且被点击了",
                        Toast.LENGTH_SHORT).show();
            }
        });

        textView.setText("我在Fragment中被初始化了");
    }
}
