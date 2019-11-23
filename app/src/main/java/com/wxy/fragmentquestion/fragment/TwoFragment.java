package com.wxy.fragmentquestion.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wxy.fragmentquestion.R;
import com.wxy.fragmentquestion.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TwoFragment extends BaseFragment {


    @OnClick({R.id.tv_two, R.id.tv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_two:
                Navigation.findNavController(getView()).navigate(R.id.action_fragment_two_to_fragment_three);
                break;
            case R.id.tv_back:
                Navigation.findNavController(getView()).navigateUp();
                break;
        }
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        OneFragmentArgs oneFragmentArgs = OneFragmentArgs.fromBundle(getArguments());
        Toast.makeText(getActivity(), oneFragmentArgs.getDaTa(), Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_two;
    }
}
