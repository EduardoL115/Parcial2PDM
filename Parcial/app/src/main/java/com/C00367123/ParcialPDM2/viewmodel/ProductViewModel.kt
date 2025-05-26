package com.C00367123.ParcialPDM2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.C00367123.ParcialPDM2.data.Product

class ProductViewModel : ViewModel() {

    private val _products = mutableStateListOf<Product>().apply {
        addAll(dummyProducts)
    }

    val products: List<Product> get() = _products
    var searchQuery = mutableStateOf("")
    var selectedProduct = mutableStateOf<Product?>(null)
    val cartItems: List<Product>
        get() = _products.filter { it.addedToCart }
    fun onSearch(query: String) {
        searchQuery.value = query
    }
    fun getFilteredProducts(): List<Product> {
        val query = searchQuery.value.lowercase()
        return _products.filter {
            it.name.lowercase().contains(query) || it.category.lowercase().contains(query)
        }
    }

    fun selectProduct(product: Product) {
        selectedProduct.value = product
    }

    fun toggleCart(product: Product) {
        val index = _products.indexOfFirst { it.id == product.id }
        if (index != -1) {
            _products[index] = _products[index].copy(addedToCart = !product.addedToCart)
        }
    }
}

private val dummyProducts = listOf(
    Product(
        1,
        "Laptop",
        "Tecnología",
        1200.0,
        "Laptop potente para devs",
        "https://image.made-in-china.com/202f0j00FhIoCZQMEpqi/Factory-Price-1366-768-Resolution-Screen-OEM-Small-Win10-Slim-Mini-14-Inch-Laptops-Computer-Online-Buy-Laptop.webp"
    ),
    Product(
        2,
        "Tablet",
        "Tecnología",
        400.0,
        "Tablet ligera ideal para dibujo o lectura",
        "https://w7.pngwing.com/pngs/767/151/png-transparent-ipad-2-ipad-3-apple-ipad-electronics-gadget-retina-display-thumbnail.png"
    ),
    Product(
        3,
        "Monitor",
        "Tecnología",
        250.0,
        "Monitor 4K de 27 pulgadas",
        "https://media.flixcar.com/webp/synd-asset/Samsung-157862132-latin-24-essential-curved-monitor-with-the-deeply-immersive-viewing-experienc-zoom.png"
    ),
    Product(
        4,
        "Audífonos",
        "Audio",
        50.0,
        "Cancelación de ruido",
        "https://assets2.razerzone.com/images/pnx.assets/eacc83c0643ed2da8c9e98968f8aa215/headset-landingpg-500x500-barracuda-x-chroma.webp"
    ),
    Product(
        5,
        "Bocina Bluetooth",
        "Audio",
        80.0,
        "Sonido potente y portátil",
        "https://www.lacuracaonline.com/media/catalog/product/4/6/462428400013_parlanteac_xkr7izwpbqpakhfq.jpg?optimize=medium&bg-color=255,255,255&fit=bounds&height=700&width=700&canvas=700:700"
    ),
    Product(
        6,
        "Micrófono",
        "Audio",
        120.0,
        "Micrófono condensador para streaming",
        "https://www.jbl.com.au/dw/image/v2/AAUJ_PRD/on/demandware.static/-/Sites-masterCatalog_Harman/default/dw711d1d73/JBL_PARTYBOX_WIRELESS_MIC_HERO_V1_48627_x1.png?sw=537&sfrm=png"
    ),
    Product(
        7,
        "Mouse",
        "Periféricos",
        20.0,
        "Inalámbrico, ergonómico",
        "https://www.pngplay.com/wp-content/uploads/2/Gaming-Pc-Mouse-PNG-Clipart-Background.png"
    ),
    Product(
        8,
        "Teclado Mecánico",
        "Periféricos",
        70.0,
        "Teclado retroiluminado mecánico",
        "https://static.vecteezy.com/system/resources/previews/052/855/199/non_2x/white-rgb-mechanical-gaming-keyboard-with-cable-free-png.png"
    ),
    Product(
        9,
        "Webcam HD",
        "Periféricos",
        45.0,
        "Cámara HD para videollamadas",
        "https://pngimg.com/d/web_camera_PNG7975.png"
    )
)

