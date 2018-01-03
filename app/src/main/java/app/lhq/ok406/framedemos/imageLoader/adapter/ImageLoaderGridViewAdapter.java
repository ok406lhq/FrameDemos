package app.lhq.ok406.framedemos.imageLoader.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import app.lhq.ok406.framedemos.R;
import app.lhq.ok406.framedemos.imageLoader.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.imageLoader.adapter
 * 文件名：ImageLoaderGridViewAdapter
 * 创建者：lhq
 * 创建时间：2017/12/19 0019 19:17
 * 描述： TODO
 */

public class ImageLoaderGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private final ImageLoader imageLoader;
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showStubImage(R.drawable.mask_starfish)          // 设置图片下载期间显示的图片
            .showImageForEmptyUri(R.drawable.mask_starfish)  // 设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.drawable.mask_starfish)       // 设置图片加载或解码过程中发生错误显示的图片
            .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中
            .cacheOnDisk(true)                          // 设置下载的图片是否缓存在SD卡中
            .bitmapConfig(Bitmap.Config.RGB_565)        // 设置图片的解码类型
            .build();


    public ImageLoaderGridViewAdapter(Context context) {
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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_imageloader_gridview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //显示图片
        imageLoader.displayImage(Constants.IMAGES[position], holder.ivImageloaderGridview, options, null);

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.iv_imageloader_gridview)
        ImageView ivImageloaderGridview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
