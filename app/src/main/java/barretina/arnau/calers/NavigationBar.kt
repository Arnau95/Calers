package barretina.arnau.calers

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

    interface NavigationBarListener {

        fun backButtonPressed()

        fun settingsButtonPressed()
    }
}
