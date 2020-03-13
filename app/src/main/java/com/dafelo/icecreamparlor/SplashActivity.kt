package com.dafelo.icecreamparlor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.dafelo.icecreamparlor.di.SplashComponent
import com.dafelo.icecreamparlor.splash.SplashViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var splashComponent: SplashComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        splashComponent = (application as Application).applicationComponent.splashComponent().create()
        splashComponent.inject(this)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)
        setTheme(R.style.AppTheme_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //prefetch products content
        lifecycleScope.launch {
            viewModel.getProducts().observe(this@SplashActivity, Observer {
                launchMainActivity()
            })
        }
    }

    private fun launchMainActivity() {
        val intent = Intent(this, OrderActivity::class.java)
        startActivity(intent)
        finish()
    }

}
