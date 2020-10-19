package com.ldc.app_bluetooth.action.fragment;

import android.os.Bundle;

import com.ldc.app_base.core.BaseVMFragment;
import com.ldc.app_bluetooth.databinding.FragmentMessageBinding;
import com.ldc.app_bluetooth.vm.MessageVM;


public class MessageFragment extends BaseVMFragment<MessageVM, FragmentMessageBinding> {

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
    protected FragmentMessageBinding initBinding() {
        return FragmentMessageBinding.inflate(getLayoutInflater());
    }
}