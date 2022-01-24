package barretina.arnau.calers.settings

import android.content.Context
import barretina.arnau.calers.settings.datasources.SettingsMemoryDataSourceImp

class SettingsPresenter(override val context: Context) : SettingsContract.Presenter {

    override var view: SettingsContract.View? = null

    // TODO: MOVE DATA ACCESS VIA SettingsDataSource LOGIC TO THE PERTINENT USECASE
    private var settingsMemoryDataSource = SettingsMemoryDataSourceImp(context)

    override fun onViewCreated() {
        view?.refreshLanguagesSelector(
            settingsMemoryDataSource.getSelectedLanguage(),
            settingsMemoryDataSource.getAvailableLanguages()
        )
        view?.refreshDefaultScreenSelector(
            settingsMemoryDataSource.getDefaultStartScreen(),
            settingsMemoryDataSource.getAvailableScreens()
        )
        view?.refreshThemeSelector(
            settingsMemoryDataSource.getSelectedTheme(),
            settingsMemoryDataSource.getAvailableThemes()
        )
    }

    override fun saveSelectedLanguage(language: String) {
        settingsMemoryDataSource.saveSelectedLanguage(language)
    }

    override fun saveSelectedScreen(screen: String) {
        settingsMemoryDataSource.saveDefaultStartScreen(screen)
    }

    override fun saveSelectedTheme(theme: String) {
        settingsMemoryDataSource.saveSelectedTheme(theme)
    }
}
