package app.lhq.ok406.framedemos.picasso.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import app.lhq.ok406.framedemos.R;
import app.lhq.ok406.framedemos.picasso.adapter.PicassoListviewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PicassoListviewActivity extends Activity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.lv_picasso)
    ListView lvPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_picasso_listview);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        // 标题
        tvTitle.setText("Picasso在listview中使用");

        // 初始化listview
        PicassoListviewAdapter picassoListviewAdapter = new PicassoListviewAdapter(this);

        lvPicasso.setAdapter(picassoListviewAdapter);
    }
}
