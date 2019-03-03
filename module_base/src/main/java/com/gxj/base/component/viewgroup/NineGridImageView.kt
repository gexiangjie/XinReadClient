package com.gxj.base.component.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import com.gxj.base.utils.dp2Px
import com.gxj.base.utils.loadImage

/**
 * 九宫格显示图片
 */
class NineGridImageView @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null, defStyle: Int = 0
) : ViewGroup(context, attributeSet, defStyle) {

    private var mChildWidth = 0
    private var mChildHeight = 0
    private var hSpace = context.dp2Px(10)
    private var wSpace = context.dp2Px(10)
    private var mImageList = listOf<String>()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        when(mImageList.size){
            1->{
                mChildWidth = width - paddingLeft - paddingRight
            }
            2,3,4->{
                mChildWidth = (width - paddingLeft - paddingRight) / 2
            }
            else->{
                mChildWidth = (width - paddingLeft - paddingRight) / 3
            }
        }
        mChildHeight = mChildWidth
        val totalHeight =
            (mChildHeight + hSpace) * (childCount / 3 + 1) + paddingTop + paddingBottom
        setMeasuredDimension(width, totalHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for (i in 0 until childCount) {
            var view = this.getChildAt(i) as ImageView
            view.layout(
                (mChildWidth + wSpace) * (i % 3),
                (mChildHeight + wSpace) * (i / 3),
                mChildWidth * (i % 3 + 1),
                mChildHeight * (i / 3 + 1)
            )
        }
    }

    fun addNewView(images: List<String>) {
        mImageList = images
        images.forEach {
            val imageView = ImageView(context)
            loadImage(imageView, it)
            addView(imageView)
        }
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
    }
}