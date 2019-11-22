package com.wxy.fragmentquestion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wxy.fragmentquestion.fragment.FourFragment;
import com.wxy.fragmentquestion.fragment.OneFragment;
import com.wxy.fragmentquestion.fragment.ThreeFragment;
import com.wxy.fragmentquestion.fragment.TwoFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NormalMainActivity extends AppCompatActivity {
    @BindView(R.id.linear_fragment_content)
    LinearLayout linearFragmentContent;
    @BindView(R.id.btn_one)
    TextView btnOne;
    @BindView(R.id.btn_two)
    TextView btnTwo;
    @BindView(R.id.btn_three)
    TextView btnThree;
    @BindView(R.id.btn_four)
    TextView btnFour;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;
    private Fragment currentFragment=new Fragment();
    private String fragmentTag=currentFragment.getClass().getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normalmain);
        Log.e("Activity ","onCreate");
        ButterKnife.bind(this);
        initFragment();
        showFragment(oneFragment);
    }
    private void initFragment() {
        oneFragment=(OneFragment)getSupportFragmentManager().findFragmentByTag(OneFragment.class.getName());
        if (oneFragment==null){
            oneFragment=new OneFragment();
        }
        twoFragment=(TwoFragment)getSupportFragmentManager().findFragmentByTag(TwoFragment.class.getName());
        if (twoFragment==null){
            twoFragment=new TwoFragment();
        }
        threeFragment=(ThreeFragment)getSupportFragmentManager().findFragmentByTag(ThreeFragment.class.getName());
        if (threeFragment==null){
            threeFragment=new ThreeFragment();
        }
        fourFragment=(FourFragment)getSupportFragmentManager().findFragmentByTag(FourFragment.class.getName());
        if (fourFragment==null){
            fourFragment=new FourFragment();
        }
    }
@Override
protected void onDestroy() {
    Log.e("Activity ","onDestroy");
    super.onDestroy();
}
    private void showFragment(Fragment fragment) {
        if (currentFragment!=fragment){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.setCustomAnimations(R.anim.right_in,R.anim.left_out,R.anim.right_out,R.anim.left_in);
                transaction.setCustomAnimations(R.anim.right_in,R.anim.right_out,R.anim.left_in,R.anim.left_out);
            transaction.hide(currentFragment);//  不是则隐藏
            currentFragment=fragment;
            transaction.addToBackStack(currentFragment.getClass().getName());
            if (!fragment.isAdded()){
                transaction.add(R.id.linear_fragment_content,fragment,fragment.getClass().getName()).show(fragment).commit();
            }else {
                transaction.show(fragment).commit();
            }
        }
    }

    @OnClick({R.id.btn_jump,R.id.btn_back_fragment,R.id.btn_one, R.id.btn_two, R.id.btn_three, R.id.btn_four})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back_fragment:
                if (getSupportFragmentManager().getBackStackEntryCount()>1){
                getSupportFragmentManager().popBackStack();
                }else {
                    Toast.makeText(this, "回退完了", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_jump:
                startActivity(new Intent(this,SecondActivity.class));
                break;
            case R.id.btn_one:
                btnOne.setTextColor(getResources().getColor(R.color.colorAccent));
                btnTwo.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnThree.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnFour.setTextColor(getResources().getColor(R.color.colorPrimary));
                showFragment(oneFragment);
                btnOne.setText("one");
                break;
            case R.id.btn_two:
                btnOne.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnTwo.setTextColor(getResources().getColor(R.color.colorAccent));
                btnThree.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnFour.setTextColor(getResources().getColor(R.color.colorPrimary));
                showFragment(twoFragment);
                btnTwo.setText("two");
                break;
            case R.id.btn_three:
                btnOne.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnTwo.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnThree.setTextColor(getResources().getColor(R.color.colorAccent));
                btnFour.setTextColor(getResources().getColor(R.color.colorPrimary));
                showFragment(threeFragment);
                btnThree.setText("three");
                break;
            case R.id.btn_four:
                btnOne.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnTwo.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnThree.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnFour.setTextColor(getResources().getColor(R.color.colorAccent));
                showFragment(fourFragment);
                btnFour.setText("four");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1)
            finish();
        else
            getSupportFragmentManager().popBackStack();

    }
}
