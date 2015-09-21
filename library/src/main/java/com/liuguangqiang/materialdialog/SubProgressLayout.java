/*
 * Copyright 2015 Eric Liu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.liuguangqiang.materialdialog;

import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Eric on 15/8/11.
 */
public class SubProgressLayout extends SubLayout {

    private TextView tvMessage;

    public static void into(LinearLayout root, MaterialDialog.Builder builder) {
        SubProgressLayout layout = new SubProgressLayout(builder, R.layout.sub_progress);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        params.weight = 1;
        if (TextUtils.isEmpty(builder.title)) {
            params.topMargin = builder.context.getResources().getDimensionPixelSize(R.dimen.dialog_margin_small);
            params.bottomMargin = builder.context.getResources().getDimensionPixelSize(R.dimen.dialog_margin_small);
        } else {
            params.topMargin = builder.context.getResources().getDimensionPixelSize(R.dimen.dialog_default_margin_half);
            params.bottomMargin = builder.context.getResources().getDimensionPixelSize(R.dimen.dialog_default_margin_half);
        }

        root.addView(layout.getView(), params);
    }

    public SubProgressLayout(MaterialDialog.Builder builder, @LayoutRes int resId) {
        super(builder, resId);
    }

    @Override
    public void initViews(View view) {
        tvMessage = findById(R.id.tv_message);
        tvMessage.setText(builder.message);

        if (builder.messageColor != 0) {
            tvMessage.setTextColor(builder.messageColor);
        }

        if (builder.contentFont != null) {
            tvMessage.setTypeface(builder.contentFont);
        }
    }

}
