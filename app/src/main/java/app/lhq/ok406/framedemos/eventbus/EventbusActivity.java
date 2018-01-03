package app.lhq.ok406.framedemos.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import app.lhq.ok406.framedemos.R;
import app.lhq.ok406.framedemos.eventbus.event.Eventbus;
import app.lhq.ok406.framedemos.eventbus.event.StickyEventbus;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos
 * 文件名：EventbusActivity
 * 创建者：lhq
 * 创建时间：2017/12/14 0014 19:08
 * 描述： TODO
 */

public class EventbusActivity extends Activity {

    private Button btn3;
    private Button btn4;
    private EditText et2;
    private boolean isFirst = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_eventbus);
        initView();

        initListener();
    }

    private void initListener() {
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.3 发送EventBus消息
                EventBus.getDefault().post(new Eventbus("我是刚过来的-.-"));
                finish();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFirst) {
                    isFirst = false;
                    //2.4注册
                    EventBus.getDefault().register(EventbusActivity.this);
                }
            }
        });
    }

    //2.3接受粘性消息
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void StickyEventbus(StickyEventbus eventbus) {
        et2.setText(eventbus.name);
    }

    private void initView() {
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        et2 = (EditText) findViewById(R.id.et2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //解注册
        EventBus.getDefault().unregister(EventbusActivity.this);
    }
}
