package app.lhq.ok406.framedemos.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import app.lhq.ok406.framedemos.R;
import app.lhq.ok406.framedemos.eventbus.event.Eventbus;
import app.lhq.ok406.framedemos.eventbus.event.StickyEventbus;

public class MainActivity extends Activity {

    private Button btn1;
    private Button btn2;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus_main);

        initView();
        //1.1 注册
        EventBus.getDefault().register(MainActivity.this);
        initListener();
    }

    private void initListener() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到发送页面
                Intent intent = new Intent(MainActivity.this,EventbusActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //2.1发送粘性消息
                EventBus.getDefault().postSticky(new StickyEventbus("我是粘性消息~"));
                Intent intent = new Intent(MainActivity.this,EventbusActivity.class);
                startActivity(intent);
            }
        });
    }

    //1.4接受消息
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(Eventbus event){
        et.setText(event.name);
    }


    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        et = (EditText) findViewById(R.id.et);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //1.2 解注册
        EventBus.getDefault().unregister(MainActivity.this);
    }
}
