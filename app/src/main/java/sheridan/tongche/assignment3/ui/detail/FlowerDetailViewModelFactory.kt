package sheridan.tongche.assignment3.ui.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sheridan.tongche.assignment3.domain.Flower
import java.lang.IllegalArgumentException

class FlowerDetailViewModelFactory(
    private val flower: Flower,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlowerDetailViewModel::class.java)) {
            return FlowerDetailViewModel(flower, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}