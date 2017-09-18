package com.airzj.mobilesafe.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.airzj.mobilesafe.R;

public class HomeActivity extends AppCompatActivity {
    private GridView mGridview;
    private String[]  mTitleStr;
    private int[] mDrawableIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initUI();

        initData();
    }

    private void initData() {
        //准备9张图片，9组字符串，作为九宫格的数据来源
        mTitleStr = new String[]{
                "手机防盗","通信卫士","软件管理",
                "进程管理","流量控制","手机杀毒",
                "缓存清理","高级工具","设置中心"
        };

        mDrawableIds = new int[]{
                R.drawable.home_safe,R.drawable.home_callmsgsafe,R.drawable.home_apps,
                R.drawable.home_taskmanager, R.drawable.home_netmanager,R.drawable.home_trojan,
                R.drawable.home_sysoptimize,R.drawable.home_tools,R.drawable.home_settings
        };

        //九宫格控件设置数据适配器
        mGridview.setAdapter(new MyAdapter());

        //设置九宫格单个条目点击事件
        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //点中列表条目索引为i
                switch (i){
                    case 0:
                        break;
                    case 8:
                        break;
                    default:


                        break;
                }
            }
        });

    }

    private void initUI() {
        mGridview = (GridView) findViewById(R.id.gv_home);
    }


    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            //返回条目的总数
            return mTitleStr.length;
        }

        @Override
        public Object getItem(int i) {
            return mTitleStr[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View mview = View.inflate(getApplicationContext(),R.layout.gridview_item,null);

            TextView textview = (TextView)mview.findViewById(R.id.tv_title);
            ImageView imageview = (ImageView)mview.findViewById(R.id.iv_icon);

            textview.setText(mTitleStr[i]);
            imageview.setBackgroundResource(mDrawableIds[i]);
            return mview;
        }
    }
}
