package com.C00367123.ParcialPDM2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.C00367123.ParcialPDM2.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    private val viewModel = ProductViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(viewModel = viewModel)
        }
    }
}
