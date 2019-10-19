package com.mydesign.caller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.mydesign.R;
import com.mydesign.base.BaseActivity;
import com.mydesign.base.BaseNavigator;
import com.mydesign.databinding.ActivityCallerBinding;
import com.mydesign.utils.Utils;
import com.mydesign.utils.network.RetrofitResponseUtil;

import java.util.*;

public class CallerActivity extends BaseActivity<ActivityCallerBinding, CallerViewModel> implements CallerNavigator {


    private static final String TAG = "callActTAG";
    private Context mContext;

    @Override
    public void onError(String message) {
        Utils.getInstance().showMessage(mContext, message);
    }

    @Override
    public void onNoInternet() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_caller;
    }

    @Override
    public Class getViewModel() {
        return CallerViewModel.class;
    }

    @Override
    public BaseNavigator getNavigatorReference() {
        return CallerActivity.this;
    }

    @Override
    public void onBinding() {
        mContext = this;
        mBinding.setViewModel(mViewModel);

        mBinding.btnClick.setOnClickListener(v->{
            mViewModel.getPosCharacter();
            mViewModel.getCharacterArray();
            mViewModel.getUniqueCharCount();
        });

        mViewModel.getGetResData().observe(this, msg -> {
                    String ch = String.valueOf(msg.charAt(9));
                    mBinding.tvOneContent.setText(ch);
        });

        mViewModel.getArrRes().observe(this,resArr->{
            String res = RetrofitResponseUtil.getGSONString(resArr);
            mBinding.tvTwoContent.setText(res);
        });

        mViewModel.getUniqueWordCounter().observe(this,count -> mBinding.tvThreeContent.setText(String.valueOf(count)));


    }

    @Override
    public void onDecline() {

    }

    @Override
    public void onConnect() {

    }


}
