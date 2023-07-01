package ru.startandroid.develop.region

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawView(this))
    }

    /*internal inner class DrawView(context: Context): View(context) {

        private var p: Paint = Paint()
        private var rect1: Rect
        private var rect2: Rect
        private var region: Region
        //private lateinit var iterator: RegionIterator
        private var path: Path

        //private var op: Region.Op = Region.Op.UNION
        //private var op: Region.Op = Region.Op.XOR
        //private var op: Region.Op = Region.Op.DIFFERENCE
        //private var op: Region.Op = Region.Op.REVERSE_DIFFERENCE
        //private var op: Region.Op = Region.Op.INTERSECT
        private var op: Region.Op = Region.Op.REPLACE

        init {
            p.strokeWidth = 3f

            rect1 = Rect(200, 200, 400, 400)
            rect2 = Rect(300, 300, 500, 500)

            region = Region()
            region.set(rect1)
            region.op(rect2, op)

            path = region.boundaryPath
        }

        override fun onDraw(canvas: Canvas?) {
            canvas!!.drawARGB(80, 102, 204, 255)

            p.style = Paint.Style.STROKE
            p.color = Color.BLACK
            canvas.drawRect(rect1, p)
            canvas.drawRect(rect2, p)

            p.style = Paint.Style.FILL
            p.color = Color.BLUE
            canvas.drawPath(path, p)
        }
    }*/

    internal inner class DrawView(context: Context): View(context) {
        private var p: Paint = Paint()
        private var region: Region
        private var clipRegion: Region
        private var path: Path
        private var pathDst: Path
        private var rect: Rect

        init {
            p.strokeWidth = 3f
            p.style = Paint.Style.STROKE

            path = Path()
            path.moveTo(100f, 100f)
            path.lineTo(150f, 150f)
            path.lineTo(100f, 200f)
            path.close()

            rect = Rect(100, 100, 150, 150)
            clipRegion = Region(rect)

            region = Region()
            region.setPath(path, clipRegion)
            pathDst = region.boundaryPath
        }

        override fun onDraw(canvas: Canvas?) {
            canvas!!.drawARGB(80, 102, 204, 255)

            p.color = Color.GREEN
            canvas.drawPath(path, p)

            canvas.translate(200f, 0f)

            p.color = Color.BLUE
            canvas.drawPath(pathDst, p)
        }
    }
}