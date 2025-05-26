package com.C00367123.ParcialPDM2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.C00367123.ParcialPDM2.viewmodel.ProductViewModel
import com.C00367123.ParcialPDM2.data.Product

@Composable
fun ProductDetailScreen(viewModel: ProductViewModel, product: Product, onGoBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(45.dp))
        Image(
            painter = rememberAsyncImagePainter(product.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp)
        )

        Text(product.name, style = MaterialTheme.typography.titleLarge)
        Text(product.category, style = MaterialTheme.typography.labelMedium)
        Text("$${product.price}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(product.description, style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            viewModel.toggleCart(product)
            onGoBack()
        }) {
            Text(if (product.addedToCart) "Quitar del carrito" else "Agregar al carrito")
        }
    }
}
