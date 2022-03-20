package com.example.dicoding.customview

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.dicoding.R
import com.example.dicoding.databinding.CustomToolbarBinding

class CustomToolbar(
    context: Context,
    attributeSet: AttributeSet? = null,
) : ConstraintLayout(context, attributeSet) {

    private val binding: CustomToolbarBinding = CustomToolbarBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    init {
        attributeSet?.let {
            context.theme.obtainStyledAttributes(
                it, R.styleable.CustomToolbar, 0, 0
            ).apply {
                try {
                    title = getString(R.styleable.CustomToolbar_custom_text)
                    customLeftButton = getDrawable(R.styleable.CustomToolbar_custom_left_icon)
                    customRightButton = getDrawable(R.styleable.CustomToolbar_custom_right_icon)
                } finally {
                    recycle()
                }
            }
        }
    }

    var title: String? = ""
        set(value) = with(binding) {
            field = value
            tvTitle.text = value
            invalidate()
            requestLayout()
        }

    var customRightButton: Drawable? = null
        set(value) = with(binding) {
            field = value
            when(value) {
                null -> ibAbout.visibility = View.GONE
                else -> ibAbout.background = value
            }
            invalidate()
            requestLayout()
        }

    var customLeftButton: Drawable? = null
        set(value) = with(binding) {
            field = value
            ibBack.background =
                (value ?: AppCompatResources.getDrawable(context, R.drawable.ic_toolbar_back))
            invalidate()
            requestLayout()
        }

    fun setOnClickedRightButton(
        onClicked: () -> Unit,
    ) {
        binding.ibAbout.setOnClickListener {
            onClicked.invoke()
        }
    }

    fun setOnClickedLeftButton(
        onClicked: () -> Unit,
    ) {
        binding.ibBack.setOnClickListener {
            onClicked.invoke()
        }
    }
}