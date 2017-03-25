package com.cgwx.yyfwptz.lixiang.leifent01;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener{

    private final Handler mHideHandler = new Handler();
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private PageFragment fragment1, fragment2, fragment3, fragment4, fragment5;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        radioGroup = (RadioGroup) findViewById(R.id.rg_tab_bar);
        radioGroup.setOnCheckedChangeListener(this);
        radioButton = (RadioButton) findViewById(R.id.rb_home);
        radioButton.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        FragmentTransaction fTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (checkedId) {
            case R.id.rb_home:
                if (fragment1 == null) {
                    fragment1 = new PageFragment();
                    fTransaction.add(R.id.ly_content, fragment1);
                } else {
                    fTransaction.show(fragment1);
                }
                break;
            case R.id.rb_detect:
                if (fragment2 == null) {
                    fragment2 = new PageFragment();
                    fTransaction.add(R.id.ly_content, fragment2);
                } else {
                    fTransaction.show(fragment2);
                }
                break;
//            case R.id.rb_record:
//                if (fragment3 == null) {
//                    fragment3 = new PageFragment();
//                    fTransaction.add(R.id.ly_content, fragment3);
//                } else {
//                    fTransaction.show(fragment3);
//                }
//                break;
            case R.id.rb_private:
                if (fragment4 == null) {
                    fragment4 = new PageFragment();
                    fTransaction.add(R.id.ly_content, fragment4);
                } else {
                    fTransaction.show(fragment4);
                }
                break;
            case R.id.rb_more:
                if (fragment5 == null) {
                    fragment5 = new PageFragment();
                    fTransaction.add(R.id.ly_content, fragment5);
                } else {
                    fTransaction.show(fragment5);
                }
                break;
        }
        fTransaction.commit();
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fragment1 != null) fragmentTransaction.hide(fragment1);
        if (fragment2 != null) fragmentTransaction.hide(fragment2);
//        if (fragment3 != null) fragmentTransaction.hide(fragment3);
        if (fragment4 != null) fragmentTransaction.hide(fragment4);
        if (fragment5 != null) fragmentTransaction.hide(fragment5);

    }
}
