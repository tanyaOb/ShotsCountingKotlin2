package com.example.tanya.shotscountingkotlin2

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.toast


/**
 * Created by Tanya on 05.07.2017.
 */

class DrawBitmap : View {


    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        var image: Bitmap
        val opt = BitmapFactory.Options()
        opt.inMutable = true
        image = BitmapFactory.decodeResource(resources, R.drawable.image, opt)
        mutableImage = Bitmap.createScaledBitmap(image, image.width/2, image.height/2, false)
        draw_canvas = Canvas(mutableImage)
        c = context
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.WHITE)
        canvas.drawBitmap(mutableImage, 0f, 0f, null)
    }

    fun drawPointOnCanvas(p_x: Int, p_y: Int) {
        val paint = Paint()
        paint.color = Color.BLACK
        var point_x = (((mutableImage.width/2)-2) + p_x).toFloat() //// center of coordinates: x = 187; y =182. Make center of coordinates: x = 185
        var point_y = (((mutableImage.height/2)+3) - p_y).toFloat() //make center of coordinates: y =185
        draw_canvas.drawCircle(point_x, point_y, 5f, paint)
        c.toast("Point_x: "+p_x + " Point_y: " + p_y)
    }

    companion object {
        lateinit var draw_canvas: Canvas
        lateinit var c: Context
        lateinit var mutableImage: Bitmap
    }
}
