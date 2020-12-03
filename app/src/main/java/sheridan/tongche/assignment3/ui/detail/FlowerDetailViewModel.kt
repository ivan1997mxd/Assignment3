package sheridan.tongche.assignment3.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import sheridan.tongche.assignment3.domain.Flower

class FlowerDetailViewModel(
    flowers: Flower,
    app: Application
) : AndroidViewModel(app) {

    // The internal MutableLiveData for the selected property
    private val _selectedProperty = MutableLiveData<Flower>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<Flower>
        get() = _selectedProperty

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedProperty.value = flowers
    }

    val imgUrl =
        "http://tetervak.dev.fast.sheridanc.on.ca/Examples/jQuery/Flowers3/images/flowers/" + flowers.picture

}