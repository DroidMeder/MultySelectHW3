package kg.geekteck.multyselecthw3

import android.view.LayoutInflater
import com.example.baselesson.base.BaseActivity
import com.example.baselesson.base.BaseViewModel
import kg.geekteck.multyselecthw3.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>() {
    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }
}