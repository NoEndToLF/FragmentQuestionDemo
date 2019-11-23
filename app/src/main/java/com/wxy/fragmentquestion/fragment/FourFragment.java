package com.wxy.fragmentquestion.fragment;

import android.view.View;

import com.wxy.fragmentquestion.R;
import com.wxy.fragmentquestion.base.BaseFragment;

import androidx.navigation.Navigation;
import butterknife.OnClick;

public class FourFragment extends BaseFragment {


    @Override
    public int getLayoutId() {
        return R.layout.fragment_four;
    }


    @OnClick({R.id.tv_four, R.id.tv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_four:
                break;
            case R.id.tv_back:
                //第二个参数意思是fragment_one是否也出栈
                Navigation.findNavController(getView()).popBackStack(R.id.fragment_one,false);
                break;
        }
    }
}
