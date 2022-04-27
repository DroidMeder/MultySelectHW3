package kg.geekteck.multyselecthw3.ui

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.baselesson.base.BaseNavFragment
import com.example.baselesson.base.BaseViewModel
import kg.geekteck.multyselecthw3.R
import kg.geekteck.multyselecthw3.adapters.ListAdapter
import kg.geekteck.multyselecthw3.databinding.FragmentMainBinding
import kg.geekteck.multyselecthw3.interfaces.Click
import kg.geekteck.multyselecthw3.models.Picture

class MainFragment : BaseNavFragment<FragmentMainBinding, BaseViewModel>(), Click{
    private val list = arrayListOf(
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img1),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img2),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img3),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img1),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img2),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img3),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img1),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img2),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img3),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img1),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img2),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img3),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img1),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img2),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img3),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img1),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img2),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img3),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img1),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img2),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img3),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img1),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img2),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img3),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img1),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img2),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img3),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img1),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img2),
        Picture("android.resource://kg.geekteck.multyselecthw3/" +R.drawable.img3)
    )

    private var selectedList = arrayListOf<Picture>()
    override fun inflateViewBinding(inflater: LayoutInflater): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater)
    }

    override fun initView()= with(binding) {
        super.initView()
        mainRec.layoutManager=GridLayoutManager(requireContext(), 3)
        mainRec.adapter=ListAdapter(list, this@MainFragment)
    }

    override fun initListener() {
        super.initListener()
        binding.btnSend.setOnClickListener{
            val list1 = arrayListOf<String>()
            for(element in selectedList){
                list1.add(element.uri)
            }
            val array: Array<String> = list1.toTypedArray()
            navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(array))
        }
    }

    override fun miltyChoice(picture: Picture) {
        println(".......${picture.isSelect}")
        if (selectedList.contains(picture) && !picture.isSelect){
            selectedList.remove(picture)
            mNotification()
        }else {
            selectedList.add(picture)
            mNotification()
        }
    }

    private fun mNotification()= with(binding){
        if (selectedList.size>0){
            cl.visibility = View.VISIBLE
            textView.text = getString(R.string.number_of_chosen_photos, selectedList.size.toString())
        } else {
            cl.visibility = View.GONE
        }
    }
}

