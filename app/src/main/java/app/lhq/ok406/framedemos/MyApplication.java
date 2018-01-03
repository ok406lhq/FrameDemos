package app.lhq.ok406.framedemos;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lzy.okgo.OkGo;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import org.xutils.x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos
 * 文件名：MyApplication
 * 创建者：lhq
 * 创建时间：2017/12/18 0018 13:18
 * 描述： TODO
 */

public class MyApplication extends Application {

    public static List<?> images=new ArrayList<>();
    public static List<String> titles=new ArrayList<>();
    //屏幕的高
    public static int H;

    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.

        Fresco.initialize(this);

        initImageLoader(this);
    }

    private void initImageLoader(Context context) {
        // 初始化参数
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2)               // 线程优先级
                .denyCacheImageMultipleSizesInMemory()                  // 当同一个Uri获取不同大小的图片，缓存到内存时，只缓存一个。默认会缓存多个不同的大小的相同图片
                .discCacheFileNameGenerator(new Md5FileNameGenerator()) // 将保存的时候的URI名称用MD5
                .tasksProcessingOrder(QueueProcessingType.LIFO)         // 设置图片下载和显示的工作队列排序
                .writeDebugLogs()                                       // 打印debug log
                .build();

        // 全局初始化此配置
        ImageLoader.getInstance().init(config);

        //初始化Banner
        initBanner();

        //初始化OkGo
        initOkGo();

    }

    private void initOkGo() {
        OkGo.getInstance().init(this);
    }

    private void initBanner() {
        H=getScreenH(this);
        Fresco.initialize(this);

//        //让软件状态还原的框架
//        Recovery.getInstance()
//                .debug(true)
//                .recoverInBackground(false)
//                .recoverStack(true)
//                .mainPage(MainActivity.class)
//                .init(this);


        String[] urls = getResources().getStringArray(R.array.url4);
        String[] tips = getResources().getStringArray(R.array.title);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        titles= Arrays.asList(tips);
    }


    /**
     * 得到屏幕的高
     * @param aty
     * @return
     */
    public int getScreenH(Context aty) {
        DisplayMetrics dm = aty.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

}
