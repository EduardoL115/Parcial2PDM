package com.C00367123.ParcialPDM2

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.C00367123.ParcialPDM2.data.Product
import com.C00367123.ParcialPDM2.ui.*
import com.C00367123.ParcialPDM2.viewmodel.ProductViewModel

@Composable
fun Navigation(viewModel: ProductViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "product_list") {

        composable("product_list") {
            ProductListScreen(
                viewModel = viewModel,
                onProductClick = {
                    navController.navigate("product_detail/${it.id}")
                },
                navController = navController
            )
        }

        composable(
            route = "product_detail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            val product = viewModel.products.find { it.id == productId }
            product?.let {
                ProductDetailScreen(
                    viewModel = viewModel,
                    product = it,
                    onGoBack = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable("cart") {
            CartScreen(viewModel = viewModel)
        }
    }
}
