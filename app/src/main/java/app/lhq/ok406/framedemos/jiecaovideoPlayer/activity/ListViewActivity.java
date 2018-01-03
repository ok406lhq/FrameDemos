package app.lhq.ok406.framedemos.jiecaovideoPlayer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListViewActivity extends AppCompatActivity {

    @BindView(R.id.normal_list)
    Button normalList;
    @BindView(R.id.viewpayer_list)
    Button viewpayerList;
    @BindView(R.id.multi_holder_list)
    Button multiHolderList;
    @BindView(R.id.recyleview)
    Button recyleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.normal_list, R.id.viewpayer_list, R.id.multi_holder_list, R.id.recyleview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.normal_list:
                startActivity(new Intent(ListViewActivity.this, ListViewNormalActivity.class));
                break;
            case R.id.viewpayer_list:
                startActivity(new Intent(ListViewActivity.this, ListViewViewpagerActivity.class));
                break;
            case R.id.multi_holder_list:
                startActivity(new Intent(ListViewActivity.this, ListViewMultiHolderActivity.class));
                break;
            case R.id.recyleview:
                startActivity(new Intent(ListViewActivity.this, RecyclerViewNormalActivity.class));
                break;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
