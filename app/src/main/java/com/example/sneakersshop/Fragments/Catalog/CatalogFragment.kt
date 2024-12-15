package com.example.sneakersshop.Fragments.Catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.sneakersshop.Model.DatabaseProvider
import com.example.sneakersshop.Model.Entity.Boot
import com.example.sneakersshop.R
import kotlinx.coroutines.launch

class CatalogFragment : Fragment() {

    private val viewModel: CatalogViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val navController = findNavController()

        lifecycleScope.launch {
            val data = DatabaseProvider.getDatabase(requireContext()).bootDao()
            val boots = data.getAllBoots()
            if (boots.isEmpty()){
                data.insert(Boot(id = 0, name = "Dolce & Gabbana", category = "Кеды с принтом граффити", price = 1251 , priceText = "$1251", drawable = R.drawable.img_boot_image) )
                data.insert(Boot(id = 0, name = "Off-White", category = "Кроссовки Off-Court 3.0", price = 551, priceText = "1 • \$551", drawable = R.drawable.img_boot_image_2) )
                data.insert(Boot(id = 0, name = "Jordan", category = "Кеды с принтом граффити", price = 1251, priceText = "$1251", drawable = R.drawable.img_boot_image_3) )
                data.insert(Boot(id = 0, name = "Jordan", category = "Кеды с принтом граффити", price = 1251, priceText = "$1251", drawable = R.drawable.img_boot_image_4) )
            }
            viewModel.state.value = viewModel.state.value.copy(list = boots)
        }

        return ComposeView(requireContext()).apply {
            setContent {
                CatalogScreen(
                    state = viewModel.state.value,
                    onEvent = { event -> viewModel.dispatch(event, navController, requireContext() ) }
                )
            }
        }
    }
}