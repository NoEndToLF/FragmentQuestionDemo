package com.wxy.fragmentquestion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.util.Log;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        //因为是replace的话，系统会存NavHostFragment，导致回收AppCompatActivity后再进行Replace会重新覆盖，恢复到初始状态
        if (savedInstanceState==null){
        NavHostFragment navHostFragment= new NavHostFragment();
            navHostFragment.setGraph(R.navigation.navi_graph_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_parent,navHostFragment)
                .setPrimaryNavigationFragment(navHostFragment)//让fragment处理返回事件
                .commit();
        }


    }
}
