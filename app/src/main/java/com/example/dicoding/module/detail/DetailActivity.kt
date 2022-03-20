package com.example.dicoding.module.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.dicoding.R
import com.example.dicoding.databinding.ActivityDetailBinding
import com.example.dicoding.entity.Pokemon
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class DetailActivity: AppCompatActivity(), DetailInterface.View {

    private val presenter = DetailPresenter(this)
    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
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
        binding.toolbar.setOnClickedLeftButton { onBackPressed() }
        binding.toolbar.setOnClickedRightButton { shareReceipt() }
    }

    override fun setData(pokemon: Pokemon) = with(binding) {
        ivImage.setImageResource(pokemon.image)
        tvId.text = pokemon.id
        tvName.text = pokemon.name
        rvType.setDataRecyclerView(pokemon.type)
        tvDescriptions.text = pokemon.descriptions
        tvValueHiddenPower.text = pokemon.abilities.first { it.hidden }.ability
        tvValueCatchRate.text = pokemon.catchRate.rate.toString()
        tvValueSpecies.text = pokemon.species
        tvValueHeight.text = pokemon.height
        tvValueWeight.text = pokemon.weight
        when(pokemon.isAlreadyCatch) {
            true -> ivPokeball.visibility = View.VISIBLE
            else -> ivPokeball.visibility = View.GONE
        }
    }

    @SuppressLint("SetWorldReadable")
    private fun shareReceipt() {
        val bitmap = getBitmapFromView(binding.clDetails)
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
                putExtra(Intent.EXTRA_TEXT, "Congratulation! You Got a New Pokemon!")
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