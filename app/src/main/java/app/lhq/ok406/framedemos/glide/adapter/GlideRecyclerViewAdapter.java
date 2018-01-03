package app.lhq.ok406.framedemos.glide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.glide.adapter
 * 文件名：GlideRecyclerViewAdapter
 * 创建者：lhq
 * 创建时间：2017/12/15 0015 16:02
 * 描述： TODO
 */

public class GlideRecyclerViewAdapter extends RecyclerView.Adapter<GlideRecyclerViewAdapter.ViewHolder> {
    private Context mContext;

    String[] mDatas = new String[]{
            "https://ws1.sinaimg.cn/large/610dc034ly1fhj53yz5aoj21hc0xcn41.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fhhz28n9vyj20u00u00w9.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fhgsi7mqa9j20ku0kuh1r.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fhfmsbxvllj20u00u0q80.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fhegpeu0h5j20u011iae5.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fhb0t7ob2mj20u011itd9.jpg",
            "https://ws1.sinaimg.cn/large/610dc034gy1fh9utulf4kj20u011itbo.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fh8ox6bmjlj20u00u0mz7.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fh7hwi9lhzj20u011hqa9.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fgllsthvu1j20u011in1p.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fgj7jho031j20u011itci.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fgepc1lpvfj20u011i0wv.jpg",
            "https://ws1.sinaimg.cn/large/610dc034ly1fgbbp94y9zj20u011idkf.jpg"
    };

    public GlideRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_glide_recyclerview, null);
        return new ViewHolder(itemView);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_glide_recyclerview)
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 获取当前item数据
        // 显示数据
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, mContext.getResources().getDisplayMetrics());
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200f, mContext.getResources().getDisplayMetrics());

        Glide.with(mContext)
                .load(mDatas[position])
                .placeholder(R.mipmap.ic_launcher) //占位图
                .error(R.mipmap.ic_launcher)  //出错的占位图
                .override(width, height) //图片显示的分辨率 ，像素值 可以转化为DP再设置
                .animate(R.anim.glide_anim)
                .centerCrop()
                .fitCenter()
                .into(holder.image);
    }


    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.length;
    }
}
