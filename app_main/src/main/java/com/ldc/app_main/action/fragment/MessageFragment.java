package com.ldc.app_main.action.fragment;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.ldc.app_base.core.BaseVMFragment;
import com.ldc.app_main.action.vm.MessageVM;
import com.ldc.app_main.databinding.MainFragmentMessageBinding;


public class MessageFragment extends BaseVMFragment<MessageVM, MainFragmentMessageBinding> {
    private static final String PARAMS1 = "";
    private static final String PARAMS2 = "";

    public static MessageFragment Instance(String p1, String p2) {
        MessageFragment homeFragment = new MessageFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAMS1, p1);
        bundle.putString(PARAMS2, p2);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }


    @Override
    protected MessageVM initViewModel() {
        return ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication()).create(MessageVM.class);
    }


    @Override
    protected MainFragmentMessageBinding initBinding() {
        return MainFragmentMessageBinding.inflate(getLayoutInflater());
    }
}