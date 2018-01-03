package app.lhq.ok406.framedemos.banner.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.youth.banner.Banner;
import com.youth.banner.transformer.AccordionTransformer;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;
import com.youth.banner.transformer.CubeInTransformer;
import com.youth.banner.transformer.CubeOutTransformer;
import com.youth.banner.transformer.DefaultTransformer;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.transformer.FlipHorizontalTransformer;
import com.youth.banner.transformer.FlipVerticalTransformer;
import com.youth.banner.transformer.ForegroundToBackgroundTransformer;
import com.youth.banner.transformer.RotateDownTransformer;
import com.youth.banner.transformer.RotateUpTransformer;
import com.youth.banner.transformer.ScaleInOutTransformer;
import com.youth.banner.transformer.StackTransformer;
import com.youth.banner.transformer.TabletTransformer;
import com.youth.banner.transformer.ZoomInTransformer;
import com.youth.banner.transformer.ZoomOutSlideTransformer;
import com.youth.banner.transformer.ZoomOutTranformer;

import java.util.ArrayList;
import java.util.List;

import app.lhq.ok406.framedemos.MyApplication;
import app.lhq.ok406.framedemos.R;
import app.lhq.ok406.framedemos.banner.adapter.SampleAdapter;
import app.lhq.ok406.framedemos.banner.loader.GlideImageLoader;

public class BannerAnimationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Banner banner;
    //动画集合
    List<Class<? extends ViewPager.PageTransformer>> transformers=new ArrayList<>();
    public void initData(){
        transformers.add(DefaultTransformer.class);
        transformers.add(AccordionTransformer.class);
        transformers.add(BackgroundToForegroundTransformer.class);
        transformers.add(ForegroundToBackgroundTransformer.class);
        transformers.add(CubeInTransformer.class);
        transformers.add(CubeOutTransformer.class);
        transformers.add(DepthPageTransformer.class);
        transformers.add(FlipHorizontalTransformer.class);
        transformers.add(FlipVerticalTransformer.class);
        transformers.add(RotateDownTransformer.class);
        transformers.add(RotateUpTransformer.class);
        transformers.add(ScaleInOutTransformer.class);
        transformers.add(StackTransformer.class);
        transformers.add(TabletTransformer.class);
        transformers.add(ZoomInTransformer.class);
        transformers.add(ZoomOutTranformer.class);
        transformers.add(ZoomOutSlideTransformer.class);
    }
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_animation);
        initData();
        banner = (Banner) findViewById(R.id.banner);
        ListView listView= (ListView) findViewById(R.id.list);
        String[] data=getResources().getStringArray(R.array.anim);
        //设置适配器
        listView.setAdapter(new SampleAdapter(this,data));
        listView.setOnItemClickListener(this);

        //Banner加载数据
        banner.setImages(MyApplication.images)
                .setImageLoader(new GlideImageLoader())
                .start();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //设置不同动画
        banner.setBannerAnimation(transformers.get(position));
//        banner.setBannerAnimation(AccordionTransformer.class);
    }
}
