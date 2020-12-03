package sheridan.tongche.assignment3.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import sheridan.tongche.assignment3.databinding.FragmentFlowerDetailBinding


class FlowerDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentFlowerDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val flowers = FlowerDetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = FlowerDetailViewModelFactory(flowers, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(FlowerDetailViewModel::class.java)

        return binding.root
    }
}
