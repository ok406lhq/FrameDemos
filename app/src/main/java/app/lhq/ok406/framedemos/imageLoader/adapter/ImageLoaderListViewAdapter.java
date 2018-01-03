package app.lhq.ok406.framedemos.imageLoader.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import app.lhq.ok406.framedemos.R;
import app.lhq.ok406.framedemos.imageLoader.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.imageLoader
 * 文件名：ImageLoaderListViewAdapter
 * 创建者：lhq
 * 创建时间：2017/12/19 0019 16:56
 * 描述： TODO
 */

public class ImageLoaderListViewAdapter extends BaseAdapter {
    private Context mContext;
    private final ImageLoader imageLoader;
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showStubImage(R.drawable.mask_starfish)          // 设置图片下载期间显示的图片
            .showImageForEmptyUri(R.drawable.mask_starfish)  // 设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.drawable.mask_starfish)       // 设置图片加载或解码过程中发生错误显示的图片
            .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中
            .cacheOnDisk(true)                          // 设置下载的图片是否缓存在SD卡中
            .displayer(new RoundedBitmapDisplayer(20))  // 设置成圆角图片
            .build();                                   // 创建配置过得DisplayImageOption对象;

    public ImageLoaderListViewAdapter(Context context) {
        mContext = context;
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public int getCount() {
        return Constants.IMAGES.length;
    }

    @Override
    public Object getItem(int position) {
        return Constants.IMAGES[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_imageloader_listview, null);

            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //获取当前item数据

        //显示数据
        viewHolder.tvImageloaderName.setText("item" + (position + 1));

        /**
         * 显示图片
         * 参数1：图片url
         * 参数2：显示图片的控件
         * 参数3：显示图片的设置
         * 参数4：监听器
         */
        imageLoader.displayImage(Constants.IMAGES[position], viewHolder.ivImageloaderListview, options);

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv_imageloader_listview)
        ImageView ivImageloaderListview;
        @BindView(R.id.tv_imageloader_name)
        TextView tvImageloaderName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
