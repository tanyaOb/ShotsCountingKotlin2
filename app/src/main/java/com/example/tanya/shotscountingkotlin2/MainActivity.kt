package com.example.tanya.shotscountingkotlin2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    var number_of_points = 0
    var radious = 0.0
    var angle = 0.0
    var point_x = 0
    var point_y = 0
    var list_of_x = intArrayOf(5, -8, 35, -30, -120)
    var list_of_y = intArrayOf(-8, 20, 20, -15, 45)
    lateinit var dbm: DrawBitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dbm = DrawBitmap(this)
        setContentView(R.layout.activity_main)
    }

    fun drawPoint(view: View) {
        if (number_of_points >= list_of_x.size) {
            toast("No more data!")
        } else {
            number_of_points++
            val point_number = findViewById(R.id.point_number) as TextView
            point_number.text = "Point №: " + Integer.toString(number_of_points)
            point_x = list_of_x[number_of_points - 1]
            point_y = list_of_y[number_of_points - 1]
            dbm.drawPointOnCanvas(point_x, point_y)
            radious = Math.sqrt((point_x * point_x + point_y * point_y).toDouble())
            angle = Math.acos(point_x / radious) * 180 / Math.PI
            val r = findViewById(R.id.distance) as TextView
            val a = findViewById(R.id.angle) as TextView
            val circle = findViewById(R.id.circle_number) as TextView
            r.text = "Distance from center: " + radious.toInt().toString()
            a.text = "Angle: " + angle.toInt().toString()
            if (radious >= 0 && radious <= 10) {
                circle.text = "Number of circle: You won!"
            } else if (radious > 10 && radious <= 30) {
                circle.text = "Number of circle: 10!"
            } else if (radious > 30 && radious <= 57) {
                circle.text = "Number of circle: 9!"
            } else if (radious > 57 && radious <= 87) {
                circle.text = "Number of circle: 8!"
            } else if (radious > 87 && radious <= 120) {
                circle.text = "Number of circle: 7!"
            } else if (radious > 120 && radious <= 150) {
                circle.text = "Number of circle: 6!"
            } else if (radious > 150 && radious <= 185) {
                circle.text = "Number of circle: 5!"
            } else {
                circle.text = "Number of circle: You lost!"
            }
        }
    }
}
