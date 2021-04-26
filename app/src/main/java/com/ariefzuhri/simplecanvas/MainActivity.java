package com.ariefzuhri.simplecanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.my_imageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(Color.WHITE);
        mPaintText.setTextSize(27);
    }

    public void drawSomething(View view) {
        // Background
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(Color.CYAN);

        // Dinding
        mPaint.setColor(ContextCompat.getColor(this, R.color.brown));
        Rect mRect = new Rect();
        mRect.set(300, 600, 700, 900);
        mCanvas.drawRect(mRect, mPaint);

        // Pintu
        mPaint.setColor(ContextCompat.getColor(this, R.color.brown_light));
        mRect.set(350, 700, 500, 900);
        mCanvas.drawRect(mRect, mPaint);

        // Atap
        mPaint.setColor(ContextCompat.getColor(this, R.color.red));
        Path path = new Path();
        path.moveTo(500, 400); // Atas
        path.lineTo(275, 625); // Bawah kiri
        path.lineTo(725, 625); // Bawah kanan
        path.lineTo(500, 400); // Balik ke atas
        path.close();
        mCanvas.drawPath(path, mPaint);

        // Cerobong asap
        mPaint.setColor(ContextCompat.getColor(this, R.color.brown));
        mRect.set(600, 450, 675, 575);
        mCanvas.drawRect(mRect, mPaint);

        // Jendela
        mPaint.setColor(Color.LTGRAY);
        mCanvas.drawCircle(600, 750, 50, mPaint);

        // Nama
        mCanvas.drawText("Arief Zuhri", 363, 770, mPaintText);

        view.invalidate();
    }

    /*public void drawSomething(View view) {
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(Color.GREEN);
        mCanvas.drawText("HELLO WORLD", 50, 50, mPaintText);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(5);
        mCanvas.drawLine(100, 100, 300, 200, mPaint);

        mPaint.setColor(Color.RED);
        Rect mRect = new Rect();
        mRect.set(100, 200, 500, 400);
        mCanvas.drawRect(mRect, mPaint);

        mPaint.setColor(Color.YELLOW);
        mCanvas.drawCircle(200, 500, 100, mPaint);

        Path path = new Path();
        path.moveTo(100, 600);
        path.lineTo(300, 750);
        path.lineTo(500, 650);
        path.lineTo(700, 800);
        mPaint.setColor(Color.MAGENTA);
        mCanvas.drawPath(path, mPaint);

        view.invalidate();
    }*/
}