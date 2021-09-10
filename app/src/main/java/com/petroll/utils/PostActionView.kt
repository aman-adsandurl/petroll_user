package com.petroll.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import com.petroll.R


class PostActionView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    FrameLayout(context, attrs, defStyleAttr) {

    constructor(context: Context) : this(context, null, -1) {
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, -1) {
        val a = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PostActionView,
            0, 0
        )

        try {
            text = a.getString(R.styleable.PostActionView_text)
            icon = a.getResourceId(R.styleable.PostActionView_icon_drawable, -1)
        } finally {
            a.recycle()
        }
    }


    var text: String? = null
    private var icon: Int = -1
    lateinit var tvText: AppCompatTextView
    lateinit var ivIcon: ImageView

    private fun init() {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.layout_post_action, this)

        tvText = view.findViewById(R.id.text)
        ivIcon = view.findViewById(R.id.icon)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (text == null) {
            tvText.visibility = View.GONE
        } else {
            text?.let {
                tvText.text = it
            }
        }
        if (icon == -1) {
            ivIcon.visibility = View.GONE
        } else {
            val param = ivIcon.layoutParams as MarginLayoutParams
            param.setMargins(0,10,0,10)
            ivIcon.layoutParams = param
            icon.let {
                ivIcon.setBackgroundResource(it)
            }
        }
    }

    init {
        init()
    }
}
