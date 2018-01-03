/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package app.lhq.ok406.framedemos.android_pulltorefresh;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.Arrays;
import java.util.LinkedList;

import app.lhq.ok406.framedemos.R;

public final class PullToRefreshGridActivity extends Activity {

    static final int MENU_SET_MODE = 0;

    private LinkedList<String> mListItems;
    private PullToRefreshGridView mPullRefreshGridView;
    private GridView mGridView;
    private ArrayAdapter<String> mAdapter;


    private String[] mStrings = {"Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler"};

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptr_grid);

        mPullRefreshGridView = (PullToRefreshGridView) findViewById(R.id.pull_refresh_grid);
        mGridView = mPullRefreshGridView.getRefreshableView();

        // 实现改接口可以同时实现上拉下滑刷新的效果
        mPullRefreshGridView.setOnRefreshListener(new OnRefreshListener2<GridView>() {

            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                Toast.makeText(PullToRefreshGridActivity.this, "下滑!", Toast.LENGTH_SHORT).show();
                new GetDataTask().execute();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                Toast.makeText(PullToRefreshGridActivity.this, "上拉!", Toast.LENGTH_SHORT).show();
                new GetDataTask().execute();
            }

        });

        mListItems = new LinkedList<String>();

        TextView tv = new TextView(this);
        tv.setGravity(Gravity.CENTER);
        tv.setText("还没看到内容吧, 上拉/下滑试试，可以添加条目的喔~");
        mPullRefreshGridView.setEmptyView(tv);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mListItems);
        mGridView.setAdapter(mAdapter);
    }

    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return mStrings;
        }

        @Override
        protected void onPostExecute(String[] result) {
            mListItems.addFirst("Added after refresh...");
            mListItems.addAll(Arrays.asList(result));
            mAdapter.notifyDataSetChanged();

            // Call onRefreshComplete when the list has been refreshed.
            mPullRefreshGridView.onRefreshComplete();

            super.onPostExecute(result);
        }
    }

}
