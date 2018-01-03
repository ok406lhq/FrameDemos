package app.lhq.ok406.framedemos.okGo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okserver.OkDownload;
import com.lzy.okserver.download.DownloadListener;
import com.lzy.okserver.download.DownloadTask;
import com.lzy.okserver.task.XExecutor;

import java.io.File;

import app.lhq.ok406.framedemos.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名：FrameDemos
 * 包名：app.lhq.ok406.framedemos.okGo
 * 文件名：OkGoDownloadActivity
 * 创建者：lhq
 * 创建时间：2017/12/22 0022 15:26
 * 描述： TODO
 */

public class OkGoDownloadActivity extends Activity implements XExecutor.OnAllTaskEndListener{

    private static final String TAG = OKGoMainActivity.class.getSimpleName();
    @BindView(R.id.btn_downloadfile)
    Button btnDownloadfile;

    private static String Fileurl = "http://vfx.mtime.cn/Video/2016/09/15/mp4/160915092608935956_480.mp4";
    @BindView(R.id.pb_download)
    ProgressBar pbDownload;
    private OkDownload okDownload;
    private DownloadTask task;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_go_download_activity);
        ButterKnife.bind(this);

        okDownload = OkDownload.getInstance();
        String path = Environment.getExternalStorageDirectory().getPath()+"/lsq/";

        okDownload.setFolder(path);                     //设置全局下载目录
        okDownload.getThreadPool().setCorePoolSize(3);  //设置同时下载数量
        okDownload.addOnAllTaskEndListener(this);       //设置所有任务监听

    }

    @OnClick(R.id.btn_downloadfile)
    public void onViewClicked() {
    /**
     *  OkGo实现的简单文件下载功能
     */
        OkGo.<File>get(Fileurl).tag(this).execute(new FileCallback() {
            @Override
            public void onSuccess(Response<File> response) {
                Log.e(TAG, "onSuccess! ");

            }

            @Override
            public void downloadProgress(Progress progress) {
                pbDownload.setMax(100);
                pbDownload.setProgress((int) (progress.fraction * 100));
//                Log.e("TAG", "onLoading=="+progress.fraction+"/"+1);
                Log.e(TAG, progress.filePath +progress.fileName );
            }
        });
        /**
         * OkServer里面提供的两个核心功能之一
         * OkDownload<好吧我放弃了，Crush了>
         */
//        GetRequest<File> request = OkGo.<File>get(Fileurl);
//
//        task = OkDownload.request("taskTag",request).register(new MyDownloadListener());
//
//        task.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        task.pause();
    }

    @Override
    public void onAllTaskEnd() {
        Log.e(TAG, "所有任务下载完成!" );
    }

    //为了防止内存泄露，需要在OnDestroy中把监听移除
    @Override
    protected void onDestroy() {
        super.onDestroy();
        okDownload.removeOnAllTaskEndListener(this);
    }

    private class MyDownloadListener extends DownloadListener {
        public MyDownloadListener() {
            super("Test-Download");
        }

        @Override
            public void onStart(Progress progress) {
                Log.e(TAG, "onStart: " );
            }

            @Override
            public void onProgress(Progress progress) {
//                pbDownload.setMax(10000);
//                pbDownload.setProgress((int) (progress.fraction * 10000));
                Log.e(TAG, (progress.fraction*100)/100 +" %" );
            }

            @Override
            public void onError(Progress progress) {
                Log.e(TAG, "onError: " );
            }

            @Override
            public void onFinish(File file, Progress progress) {
                Log.e(TAG, "File saved at:"+progress.filePath +progress.fileName);
            }

            @Override
            public void onRemove(Progress progress) {
                Log.e(TAG, "onRemove: " );
            }
        }
    }
