package com.mapfit.realestate.ui.widget

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import com.mapfit.realestate.R

class PriceMarkerBitmapDrawable(
    context: Context,
    price: String,
    active: Boolean
) : BitmapDrawable(
    context.resources,
    createMarkerBitmap(
        context,
        if (active) R.drawable.marker_price_active else R.drawable.marker_price_passive,
        price
    )
) {
    companion object {

        private fun createMarkerBitmap(mContext: Context, resourceId: Int, mText: String): Bitmap? =
            try {
                val resources = mContext.resources
                val scale = resources.displayMetrics.density
                var bitmap = BitmapFactory.decodeResource(resources, resourceId)

                var bitmapConfig: android.graphics.Bitmap.Config? = bitmap.config
                if (bitmapConfig == null) {
                    bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888
                }
                bitmap = bitmap.copy(bitmapConfig, true)

                val canvas = Canvas(bitmap)
                val paint = Paint(Paint.ANTI_ALIAS_FLAG)
                paint.color = Color.WHITE
                paint.textSize = (20f * scale).toInt().toFloat()
                paint.textAlign = Paint.Align.CENTER

                val bounds = Rect()
                paint.getTextBounds(mText, 0, mText.length, bounds)
                val x = bitmap.width / 2
                val y = bitmap.height / 2.5

                canvas.drawText(mText, x.toFloat(), y.toFloat(), paint)

                bitmap
            } catch (e: Exception) {
                null
            }
    }
}