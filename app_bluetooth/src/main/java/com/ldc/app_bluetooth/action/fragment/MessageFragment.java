package com.ldc.app_bluetooth.action.fragment;

import android.os.Bundle;

import com.ldc.app_base.core.BaseVMFragment;
import com.ldc.app_bluetooth.databinding.BleFragmentMessageBinding;
import com.ldc.app_bluetooth.vm.MessageVM;


public class MessageFragment extends BaseVMFragment<MessageVM, BleFragmentMessageBinding> {

    public static MessageFragment newInstance() {
        Bundle args = new Bundle();
        MessageFragment fragment = new MessageFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected MessageVM initViewModel() {
        return createViewModel(getActivity().getApplication(), MessageVM.class);
    }

    @Override
    protected BleFragmentMessageBinding initBinding() {
        return BleFragmentMessageBinding.inflate(getLayoutInflater());
    }
}