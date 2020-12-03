package sheridan.tongche.assignment3.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import sheridan.tongche.assignment3.databinding.FragmentFlowerListBinding

class FlowerListFragment : Fragment() {

        private val viewModel: FlowerListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFlowerListBinding.inflate(inflater)
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerView.addItemDecoration(divider)
        val adapter = FlowerListAdapter(FlowerListAdapter.OnClickListener {
            viewModel.displayFlowerDetails(it)
        })
        binding.recyclerView.adapter = adapter

        viewModel.getFlowers().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.navigationToSelectedFlower.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(FlowerListFragmentDirections.actionShowDetail(it))
                viewModel.displayFlowerDetailsComplete()
            }
        })


        return binding.root
    }


}