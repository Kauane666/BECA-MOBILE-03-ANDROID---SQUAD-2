package com.example.becamobile03android_squad2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.layout_tela_inicial.*
import java.util.Observer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.layout_tela_inicial)
        val viewModel: CoinViewModel by viewModels()
        viewModel.init()
        viewModel.listCoin.observe(this, Observer {
            setAdapeter(it)
        }

        )
    }

    private fun setAdapeter(coin: List<Coin>?) {
        moeda.layoutManager = GridLayoutManager(this@MainActivity, 1)
        moeda.adapter = coin?.let { CoinAdapter(coin, this) }
    }
}