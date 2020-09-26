package com.example.aisingioro_core.delegates;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public abstract class BaseDelegate extends SwipeBackFragment {
    public abstract Object setLayout();
    public abstract void onBindView(@Nullable Bundle savedInstanceState, View rootView);

    @SuppressWarnings("SpellCheckingInspection")
    private Unbinder _unbinder = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;
        if(setLayout() instanceof Integer){
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        }else if(setLayout() instanceof View){
            rootView = (View) setLayout();
        }
        if(rootView != null){
            _unbinder = ButterKnife.bind(this, rootView);
            onBindView(savedInstanceState, rootView);
        }


        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(_unbinder != null){
            //解除绑定
            _unbinder.unbind();
        }

    }
}
