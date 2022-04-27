package kg.geekteck.multyselecthw3.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.example.baselesson.base.BaseNavFragment
import com.example.baselesson.base.BaseViewModel
import kg.geekteck.multyselecthw3.adapters.SelectedListAdapter
import kg.geekteck.multyselecthw3.databinding.FragmentDetailBinding

class DetailFragment : BaseNavFragment<FragmentDetailBinding, BaseViewModel>() {
    private lateinit var args: DetailFragmentArgs
    private var list = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args=DetailFragmentArgs.fromBundle(requireArguments())
    }
    override fun inflateViewBinding(inflater: LayoutInflater): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater)
    }

    override fun initView()= with(binding){
        super.initView()
        detailRec.layoutManager=GridLayoutManager(requireContext(), 3)
        fillList()
        detailRec.adapter= SelectedListAdapter(list)
    }

    private fun fillList() {
        args.na?.toCollection(list)
    }
}