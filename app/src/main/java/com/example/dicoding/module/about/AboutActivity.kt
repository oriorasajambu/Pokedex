package com.example.dicoding.module.about

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.dicoding.R
import com.example.dicoding.databinding.ActivityAboutBinding
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class AboutActivity: AppCompatActivity(), AboutInterface.View {

    private val presenter = AboutPresenter(this)
    private val binding: ActivityAboutBinding by lazy {
        ActivityAboutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.onCreate(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }

    override fun setToolbar() {
        binding.toolbar.apply {
            setOnClickedLeftButton { onBackPressed() }
            setOnClickedRightButton { shareReceipt() }
        }
    }

    @SuppressLint("SetWorldReadable")
    private fun shareReceipt() {
        val bitmap = getBitmapFromView(binding.customShareAboutMe.root)
        generateImageReceipt(bitmap)
    }

    private fun getBitmapFromView(view: View): Bitmap {
        val bitmap = Bitmap.createBitmap(
            view.width,
            view.height,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        val drawable = view.background
        if (drawable != null) drawable.draw(canvas) else canvas.drawColor(getColor(R.color.white))
        view.draw(canvas)
        return bitmap
    }

    @SuppressLint("SetWorldReadable")
    private fun generateImageReceipt(bitmap: Bitmap) {
        try {
            val file = File(externalCacheDir, "receipt.png")
            val fileOutput = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutput)
            fileOutput.flush()
            fileOutput.close()
            file.setReadable(true, false)
            Intent(Intent.ACTION_SEND).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                putExtra(Intent.EXTRA_TEXT, "Halo haluuu salam kenal yaaak wkwkwk")
                putExtra(
                    Intent.EXTRA_STREAM,
                    FileProvider.getUriForFile(
                        applicationContext,
                        applicationContext.packageName + ".provider",
                        file
                    )
                )
                type = "*/*"
            }.also { startActivity(Intent.createChooser(it, "Share With")) }

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}