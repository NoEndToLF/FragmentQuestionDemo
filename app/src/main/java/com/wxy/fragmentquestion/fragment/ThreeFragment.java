package com.wxy.fragmentquestion.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.wxy.fragmentquestion.R;
import com.wxy.fragmentquestion.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.OnClick;

public class ThreeFragment extends BaseFragment {


    @OnClick({R.id.tv_three, R.id.tv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_three:
                Navigation.findNavController(getView()).navigate(R.id.action_fragment_three_to_fragment_four);
                break;
            case R.id.tv_back:
                Navigation.findNavController(getView()).navigateUp();
                break;
        }
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_three;
    }

}
