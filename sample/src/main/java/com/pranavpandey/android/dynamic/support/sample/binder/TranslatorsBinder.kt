/*
 * Copyright 2018 Pranav Pandey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pranavpandey.android.dynamic.support.sample.binder

import android.support.annotation.ColorInt
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pranavpandey.android.dynamic.support.recyclerview.adapter.DynamicBinderAdapter
import com.pranavpandey.android.dynamic.support.recyclerview.binder.DynamicRecyclerViewBinder
import com.pranavpandey.android.dynamic.support.sample.R
import com.pranavpandey.android.dynamic.support.theme.DynamicTheme
import com.pranavpandey.android.dynamic.support.utils.DynamicLayoutUtils
import com.pranavpandey.android.dynamic.support.view.DynamicInfoView
import com.pranavpandey.android.dynamic.support.widget.DynamicImageView

/**
 * A recycler view binder to display translators info by using
 * [DynamicRecyclerViewBinder].
 */
class TranslatorsBinder(dynamicBinderAdapter: DynamicBinderAdapter)
    : DynamicRecyclerViewBinder<RecyclerView.ViewHolder>(dynamicBinderAdapter) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_info_translators, parent, false))
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        // Return item count.
        return 1
    }

    /**
     * Holder class to hold view holder item.
     */
    internal class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val dynamicInfoView: DynamicInfoView = view.findViewById(R.id.info_translators)

        init {
            dynamicInfoView.linksView.recyclerViewLayoutManager =
                    DynamicLayoutUtils.getGridLayoutManager(dynamicInfoView.context,
                            DynamicLayoutUtils.getGridCount(dynamicInfoView.context))

            (dynamicInfoView.iconView as DynamicImageView).color =
                    DynamicTheme.getInstance().primaryColor
            if (dynamicInfoView.linksColors != null) {
                @ColorInt val colors = dynamicInfoView.linksColors
                colors?.set(colors.size - 1, DynamicTheme.getInstance().accentColor)
                dynamicInfoView.linksColors = colors
                dynamicInfoView.update()
            }
        }
    }
}
