package com.C00367123.ParcialPDM2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.C00367123.ParcialPDM2.viewmodel.ProductViewModel
import com.C00367123.ParcialPDM2.data.Product

@Composable
fun ProductListScreen(
    viewModel: ProductViewModel,
    onProductClick: (Product) -> Unit,
    navController: NavController
) {
    val searchQuery by remember { viewModel.searchQuery }
    val filteredProducts = viewModel.getFilteredProducts()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(45.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { viewModel.onSearch(it) },
            label = { Text("Buscar producto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { navController.navigate("cart") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            shape = MaterialTheme.shapes.large
        ) {
            Text("🛒 Ver carrito")
        }

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(filteredProducts) { product ->
                ProductCard(product = product, onClick = {
                    viewModel.selectProduct(product)
                    onProductClick(product)
                })
            }
        }
    }
}

@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(4.dp),
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
                Text(text = product.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "${product.category} - $${product.price}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
