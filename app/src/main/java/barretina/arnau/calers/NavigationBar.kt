package barretina.arnau.calers

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import barretina.arnau.calers.databinding.NavigationBarBinding

class NavigationBar @kotlin.jvm.JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding: NavigationBarBinding =
        NavigationBarBinding.inflate(LayoutInflater.from(context), this, true)

    private var listener: NavigationBarListener? = null

    init {
        initListeners()
    }

    fun setListener(listener: NavigationBarListener) {
        this.listener = listener
    }

    fun getListener(): NavigationBarListener? {
        return listener
    }

    private fun initListeners() {
        binding.btnBack.setOnClickListener {
            listener?.backButtonPressed()
        }

        binding.btnSettings.setOnClickListener {
            listener?.settingsButtonPressed()
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun toggleBackButton(isBack: Boolean) {
        if (isBack) {
            binding.btnBack.background = resources.getDrawable(R.drawable.btn_back, null)
        } else {
            binding.btnBack.background = resources.getDrawable(R.drawable.btn_close, null)
        }
    }

    fun toggleSettingsButton(isEnabled: Boolean) {
        binding.btnSettings.isEnabled = isEnabled
    }

    interface NavigationBarListener {

        fun backButtonPressed()

        fun settingsButtonPressed()
    }
}
