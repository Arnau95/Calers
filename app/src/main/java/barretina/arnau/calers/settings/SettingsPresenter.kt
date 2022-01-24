package barretina.arnau.calers.settings

import android.content.Context
import barretina.arnau.calers.settings.datasources.SettingsMemoryDataSourceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SettingsPresenter(override val context: Context) : SettingsContract.Presenter {

    override var view: SettingsContract.View? = null

    // TODO: MOVE DATA ACCESS VIA SettingsDataSource LOGIC TO THE PERTINENT USECASE
    private var settingsMemoryDataSource = SettingsMemoryDataSourceImp(context)

    override fun onViewCreated() {
        GlobalScope.launch(Dispatchers.IO) {
            view?.refreshLanguagesSelector(settingsMemoryDataSource.getSelectedLanguage(), settingsMemoryDataSource.getAvailableLanguages())
            view?.refreshDefaultScreenSelector(settingsMemoryDataSource.getDefaultStartScreen(), settingsMemoryDataSource.getAvailableScreens())
            view?.refreshThemeSelector(settingsMemoryDataSource.getSelectedTheme(), settingsMemoryDataSource.getAvailableThemes())
        }
    }

    override fun saveSelectedLanguage(language: String) {
        GlobalScope.launch {
            settingsMemoryDataSource.saveSelectedLanguage(language)
        }
    }

    override fun saveSelectedScreen(screen: String) {
        GlobalScope.launch {
            settingsMemoryDataSource.saveDefaultStartScreen(screen)
        }
    }

    override fun saveSelectedTheme(theme: String) {
        GlobalScope.launch {
            settingsMemoryDataSource.saveSelectedTheme(theme)
        }
    }
}
