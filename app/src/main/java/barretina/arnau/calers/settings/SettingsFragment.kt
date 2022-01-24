package barretina.arnau.calers.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import barretina.arnau.calers.MainActivity
import barretina.arnau.calers.R
import barretina.arnau.calers.databinding.FragmentSettingsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SettingsFragment : BottomSheetDialogFragment(), SettingsContract.View {

    private var binding: FragmentSettingsBinding? = null

    private lateinit var presenter: SettingsContract.Presenter

    private var isLanguageSelectorInit: Boolean = false
    private var isThemeSelectorInit: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(
            STYLE_NO_TITLE,
            R.style.BottomSheetDialog
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        presenter = SettingsPresenter(requireContext())
        presenter.attachView(this)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun refreshLanguagesSelector(selected: String?, list: ArrayList<String>) {
        refreshSelector(SelectorType.Language, binding?.spnLanguageSelector, selected, list)
    }

    override fun refreshDefaultScreenSelector(selected: String?, list: ArrayList<String>) {
        refreshSelector(SelectorType.Screen, binding?.spnScreenSelector, selected, list)
    }

    override fun refreshThemeSelector(selected: String?, list: ArrayList<String>) {
        refreshSelector(SelectorType.Theme, binding?.rdThemeSelector, selected, list)
    }

    private fun refreshSelector(
        type: SelectorType,
        view: View?,
        selected: String?,
        list: ArrayList<String>
    ) {
        if (view is Spinner) {
            val arrayAdapter: ArrayAdapter<String> =
                ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, list)
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            view.adapter = arrayAdapter
            view.setSelection(list.indexOf(selected))
            view.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val selectedItem: String = parent.getItemAtPosition(position).toString()
                    when (type) {
                        SelectorType.Language -> {
                            presenter.saveSelectedLanguage(selectedItem)
                            if (isLanguageSelectorInit) {
                                (context as? MainActivity)?.setLocale(selectedItem, true)
                            }
                            isLanguageSelectorInit = true
                        }
                        SelectorType.Screen -> {
                            presenter.saveSelectedScreen(selectedItem)
                            if (isThemeSelectorInit) {
                                // TODO: Refresh view when theme change applied
                            }
                            isThemeSelectorInit = true
                        }
                        else -> "NO OP"
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        } else if (view is RadioGroup) {
            if (selected == binding?.rbtnDark?.text.toString()) {
                binding?.rbtnDark?.id?.let {
                    view.check(it)
                }

            } else {
                binding?.rbtnLight?.id?.let {
                    view.check(it)
                }
            }

            view.setOnCheckedChangeListener { radioGroup, i ->
                var name = ""
                name = if (i == binding?.rbtnDark?.id) {
                    binding?.rbtnDark?.text.toString()
                } else {
                    binding?.rbtnLight?.text.toString()
                }
                presenter.saveSelectedTheme(name)
                Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as? MainActivity)?.toggleSettingsButton(true)
    }

    enum class SelectorType {
        Language, Screen, Theme
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String): SettingsFragment =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
