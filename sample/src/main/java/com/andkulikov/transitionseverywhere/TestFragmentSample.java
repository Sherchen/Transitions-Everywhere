package com.andkulikov.transitionseverywhere;

import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.transitionseverywhere.ArcMotion;
import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.PatternPathMotion;
import com.transitionseverywhere.Scene;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.Visibility;
import com.transitionseverywhere.extra.TranslationTransition;

/**
 * <pre>
 *     author : Sherchen
 *     e-mail : ncuboy_045wsq@qq.com
 *     time   : 2017/5/24
 *     desc   : xxxx描述
 *     version: 1.0
 * </pre>
 */

public class TestFragmentSample extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        final ViewGroup sceneRoot = (ViewGroup) view.findViewById(R.id.transitions_container);
        final ImageView imageView = (ImageView) view.findViewById(R.id.iv_test);
        imageView.setTranslationX(-200f);
        imageView.setTranslationY(-500f);
        sceneRoot.postDelayed(new Runnable() {
            @Override
            public void run() {
                TransitionManager.beginDelayedTransition(sceneRoot, new TranslationTransition().setPathMotion(new ArcMotion()).setDuration(1000));
                imageView.setTranslationX(0);
                imageView.setTranslationY(0);
            }
        }, 20);

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageView.setTranslationX(-200f);
//                imageView.setTranslationY(-500f);
//                TransitionManager.beginDelayedTransition(sceneRoot, new TranslationTransition().setPathMotion(new ArcMotion()).setDuration(500));
//                imageView.setTranslationX(0);
//                imageView.setTranslationY(0);
//            }
//        });

        imageView.performClick();
        return view;
    }
}
