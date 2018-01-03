package app.lhq.ok406.framedemos.volley;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import app.lhq.ok406.framedemos.R;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.volley
 * 文件名：VolleyActivity
 * 创建者：lhq
 * 创建时间：2017/12/14 0014 19:55
 * 描述： TODO
 */

public class VolleyActivity extends Activity implements View.OnClickListener {

    private Button bt_volley_get;
    private Button bt_volley_post;
    private Button bt_volley_getjson;
    private Button bt_volley_imagerequest;
    private Button bt_volley_imageloader;
    private Button bt_volley_networkimageview;

    private TextView tv_volley_result;
    private ImageView iv_volley_result;
    private NetworkImageView iv_volley_networkimagview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_volley);
        initView();
    }

    private void initView() {
        bt_volley_get = (Button) findViewById(R.id.bt_volley_get);
        bt_volley_post = (Button) findViewById(R.id.bt_volley_post);
        bt_volley_getjson = (Button) findViewById(R.id.bt_volley_getjson);
        bt_volley_imagerequest = (Button) findViewById(R.id.bt_volley_imagerequest);
        bt_volley_imageloader = (Button) findViewById(R.id.bt_volley_imageloader);
        bt_volley_networkimageview = (Button) findViewById(R.id.bt_volley_networkimageview);

        iv_volley_result = (ImageView) findViewById(R.id.iv_volley_result);
        iv_volley_networkimagview = (NetworkImageView) findViewById(R.id.iv_volley_networkimagview);
        tv_volley_result = (TextView) findViewById(R.id.tv_volley_result);

        bt_volley_get.setOnClickListener(this);
        bt_volley_post.setOnClickListener(this);
        bt_volley_getjson.setOnClickListener(this);
        bt_volley_imagerequest.setOnClickListener(this);
        bt_volley_imageloader.setOnClickListener(this);
        bt_volley_networkimageview.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //get请求
            case R.id.bt_volley_get:

                //1创建一个请求队列
                RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);

                //2创建一个请求
                String url = "http://gank.io/api/search/query/listview/category/Android/count/10/page/1";
                StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tv_volley_result.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tv_volley_result.setText(error.toString());
                    }
                });

                //3将创建的请求添加到请求队列中
                requestQueue.add(stringRequest);

                break;

            //post请求
            case R.id.bt_volley_post:

                //1创建一个请求队列
                RequestQueue requestQueue2 = Volley.newRequestQueue(VolleyActivity.this);

                //2创建一个请求
                String url2 = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                //注意这里的参数不同，第一个参数要传进Request.Method.POST
                StringRequest stringRequest2 = new StringRequest(Request.Method.POST,
                        url2, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tv_volley_result.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tv_volley_result.setText(error.toString());
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> map = new HashMap<String, String>();
                        //map.put("value1","param1");
                        return map;
                    }
                };

                //3将请求添加到请求队列中
                requestQueue2.add(stringRequest2);
                break;

            //获取JSON数据
            case R.id.bt_volley_getjson:
                //1创建一个请求队列
                RequestQueue requestQueue3 = Volley.newRequestQueue(VolleyActivity.this);

                //2创建一个请求
                String url3 = "http://gank.io/api/search/query/listview/category/Android/count/10/page/1";
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url3, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        tv_volley_result.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tv_volley_result.setText(error.toString());
                    }
                });

                //3将请求添加到请求队列
                requestQueue3.add(jsonObjectRequest);
                break;
            case R.id.bt_volley_imagerequest:
                // 1 创建一个请求队列
                RequestQueue requestQueue4 = Volley.newRequestQueue(VolleyActivity.this);

                // 2 创建一个图片的请求
                String imgUrl = "http://7xi8d6.com1.z0.glb.clouddn.com/20171206084331_wylXWG_misafighting_6_12_2017_8_43_16_390.jpeg";
                ImageRequest imageRequest = new ImageRequest(imgUrl, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        iv_volley_result.setVisibility(View.VISIBLE);
                        iv_volley_result.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        iv_volley_result.setImageResource(R.mipmap.ic_launcher_round);
                    }
                });

                // 3 将请求添加到请求队列中
                requestQueue4.add(imageRequest);
                break;

            //ImageLoader加载图片
            case R.id.bt_volley_imageloader:
                //1创建一个请求队列
                RequestQueue requestQueue5 = Volley.newRequestQueue(VolleyActivity.this);

//                ImageLoader imageLoader = new ImageLoader(requestQueue5, new ImageLoader.ImageCache() {
//                    @Override
//                    public Bitmap getBitmap(String url) {
//                        return null;
//                    }
//
//                    @Override
//                    public void putBitmap(String url, Bitmap bitmap) {
//
//                    }
//                });

                //2创建一个ImageLoader
                ImageLoader imageLoader = new ImageLoader(requestQueue5, new BitmapCache());

                //加载图片
                String imgUrl2 = "http://7xi8d6.com1.z0.glb.clouddn.com/20171126223118_jeCYtY_chayexiaoguo_apple_26_11_2017_22_30_59_409.jpeg";
                iv_volley_result.setVisibility(View.VISIBLE);
                ImageLoader.ImageListener listener = imageLoader.getImageListener(iv_volley_result,
                        R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round);
                imageLoader.get(imgUrl2, listener);
                break;

            // networkimageview加载图片
            case R.id.bt_volley_networkimageview:
                iv_volley_result.setVisibility(View.GONE);
                // 创建一个请求队列
                RequestQueue requestQueue6 = Volley.newRequestQueue(VolleyActivity.this);

                // 创建一个Imageloader
                ImageLoader imageLoader2 = new ImageLoader(requestQueue6, new BitmapCache());

                //设置默认和错误时显示的图片
                iv_volley_networkimagview.setDefaultImageResId(R.mipmap.ic_launcher_round);
                iv_volley_networkimagview.setErrorImageResId(R.mipmap.ic_launcher_round);

                //加载图片
                String imgUrl3 = "http://7xi8d6.com1.z0.glb.clouddn.com/20171114101305_NIAzCK_rakukoo_14_11_2017_10_12_58_703.jpeg";
                iv_volley_networkimagview.setVisibility(View.VISIBLE);
                iv_volley_networkimagview.setImageUrl(imgUrl3, imageLoader2);
                break;
        }
    }
}
