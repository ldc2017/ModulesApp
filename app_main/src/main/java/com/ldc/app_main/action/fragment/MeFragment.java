package com.ldc.app_main.action.fragment;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.ldc.app_base.core.BaseVMFragment;
import com.ldc.app_main.R;
import com.ldc.app_main.action.vm.MeVM;
import com.ldc.app_main.databinding.FragmentHomeBinding;
import com.ldc.app_main.databinding.FragmentMeBinding;


public class MeFragment extends BaseVMFragment<MeVM, FragmentMeBinding> {
    private static final String PARAMS1 = "";
    private static final String PARAMS2 = "";

    public static MeFragment Instance(String p1, String p2) {
        MeFragment homeFragment = new MeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAMS1, p1);
        bundle.putString(PARAMS2, p2);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }


    @Override
    protected MeVM initViewModel() {
        return ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication()).create(MeVM.class);
    }



    @Override
    protected FragmentMeBinding initBinding() {
        return FragmentMeBinding.inflate(getLayoutInflater());
    }
}