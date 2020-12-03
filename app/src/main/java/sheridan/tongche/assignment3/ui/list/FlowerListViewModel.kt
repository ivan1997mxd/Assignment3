package sheridan.tongche.assignment3.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import sheridan.tongche.assignment3.domain.Flower
import sheridan.tongche.assignment3.network.FlowerDataApi
import sheridan.tongche.assignment3.network.FlowerJson


class FlowerListViewModel : ViewModel() {

    private var flowerListData: LiveData<List<Flower>>? = null

    fun getFlowers(): LiveData<List<Flower>> {
        return flowerListData ?: liveData {
            val catalog = FlowerDataApi.retrofitService.getCatalog()
            val flowers = catalog.flowers.mapIndexed { index, flowerJson ->
                flowerJson.asFlower(index)
            }
            emit(flowers)
        }.also {
            flowerListData = it
        }
    }

    private val _navigationToSelectedFlower = MutableLiveData<Flower>()
    val navigationToSelectedFlower: LiveData<Flower>
        get() = _navigationToSelectedFlower

    fun displayFlowerDetails(flower: Flower) {
        _navigationToSelectedFlower.value = flower
    }

    fun displayFlowerDetailsComplete() {
        _navigationToSelectedFlower.value = null
    }
}

fun FlowerJson.asFlower(index: Int): Flower {
    return Flower(label, text, price, pictures.large, index.toLong())
}