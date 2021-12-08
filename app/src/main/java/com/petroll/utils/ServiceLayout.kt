package com.petroll.utils

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.petroll.R

class ServiceLayout(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    LinearLayout(context, attrs, defStyleAttr) {

    constructor(context: Context?) : this(context, null, -1)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, -1)

    lateinit var tvMessage: TextView
    lateinit var ivService: ImageView
    lateinit var llBg: LinearLayout

    private fun init() {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.layout_service, this)

        tvMessage = view.findViewById(R.id.tv_heading)
        ivService = view.findViewById(R.id.iv_service)
        llBg = view.findViewById(R.id.ll_bg)
    }

    fun setSize(width: Int, height: Int) {
        llBg.layoutParams = LayoutParams(
            width, height
        )
    }

    fun setBackgroundColorTint(color: ColorStateList) {
        llBg.backgroundTintList = color
    }

    fun setImageText(text: String, image: Int = 0) {
        tvMessage.text = text

        if (image != 0) {
            ivService.setBackgroundResource(image)
        } else {
            ivService.layoutParams = LayoutParams(
                0, 0
            )
        }
    }

    fun setSmallTextSize(dimension: Int, size: Float) {
        tvMessage.setTextSize(dimension, size)
    }

    fun setSmallCircle() {
        val layoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT,
        )

        layoutParams.setMargins(0, 10, 0, 0)
        tvMessage.layoutParams = layoutParams
        llBg.background = ContextCompat.getDrawable(context, R.drawable.small_circle)
    }

    fun setTextColorLayout(color: ColorStateList) {
        tvMessage.setTextColor(color)
    }

    companion object {
        private const val LOW_VALUE = 40
        private const val MEDIUM_VALUE = 70
    }

    init {
        init()
    }
}
