package com.C00367123.ParcialPDM2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.C00367123.ParcialPDM2.viewmodel.ProductViewModel

@Composable
fun CartScreen(viewModel: ProductViewModel) {
    val cartItems = viewModel.cartItems

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(45.dp))

        Text(
            "Carrito de Compras",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (cartItems.isEmpty()) {
            Text("El carrito está vacío.")
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(cartItems) { product ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(product.imageUrl),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(64.dp)
                                    .padding(end = 16.dp)
                            )
                            Column {
                                Text(product.name, style = MaterialTheme.typography.titleMedium)
                                Text("$${product.price}", style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                }
            }
        }
    }
}
