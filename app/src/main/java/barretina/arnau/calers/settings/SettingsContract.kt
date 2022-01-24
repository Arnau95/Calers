package barretina.arnau.calers.settings

import android.content.Context
import barretina.arnau.calers.utils.BaseContract

interface SettingsContract {
    interface View : BaseContract.View {
        fun refreshLanguagesSelector(selected: String?, list: ArrayList<String>)

        fun refreshDefaultScreenSelector(selected: String?, list: ArrayList<String>)

        fun refreshThemeSelector(selected: String?, list: ArrayList<String>)
    }

    interface Presenter : BaseContract.Presenter<View> {
        val context: Context

        fun onViewCreated()

        fun saveSelectedLanguage(language: String)

        fun saveSelectedScreen(screen: String)

        fun saveSelectedTheme(theme: String)
    }
}
