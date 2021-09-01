package com.petroll.utils

import android.widget.LinearLayout
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.petroll.R
import com.petroll.dashboard.DashboardActivity
import org.w3c.dom.Text

class IconCircleLayout(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : LinearLayout(context, attrs, defStyleAttr) {

    constructor(context: Context?) : this(context, null, -1) {}
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, -1) {}

//    lateinit var tvMessage: TextView
    lateinit var ivIcon: ImageView
    lateinit var rlBg: RelativeLayout

    private fun init() {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.layout_circle_icon, this)

        ivIcon = view.findViewById(R.id.iv_icons)
        rlBg = view.findViewById(R.id.rl_small_icon)
//        tvMessage =  view.findViewById(R.id.tv_heading)
//        ivService = view.findViewById(R.id.iv_service)
//        llBg = view.findViewById(R.id.ll_bg)
    }

    public fun setImageResource(image: Int, color: ColorStateList) {
        ivIcon.setBackgroundResource(image)
        rlBg.backgroundTintList = color
    }

//    public fun setBackgroundColorTint(color: ColorStateList) {
//        llBg.backgroundTintList = color
//    }
//
//    public fun setImageText(text: String, image: Int) {
//        tvMessage.text = text
//        ivService.setBackgroundResource(image)
//    }
//
//    public fun setSmallCircle() {
//        llBg.background = ContextCompat.getDrawable(context, R.drawable.small_circle)
//    }
//
//    public fun setTextColorLayout(color: ColorStateList) {
//        tvMessage.setTextColor(color)
//    }

    companion object {
        private const val LOW_VALUE = 40
        private const val MEDIUM_VALUE = 70
    }

    init {
        init()
    }
}
