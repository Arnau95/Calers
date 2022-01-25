package barretina.arnau.calers.settings.datasources

import android.content.Context

interface SettingsMemoryDataSource {

    val context: Context

    fun saveSelectedLanguage(language: String)

    fun saveDefaultStartScreen(screen: String)

    fun saveSelectedTheme(theme: String)

    fun getSelectedLanguage(): String?

    fun getDefaultStartScreen(): String?

    fun getSelectedTheme(): String?

    fun getAvailableScreens(): ArrayList<String>

    fun getAvailableThemes(): ArrayList<String>
}

enum class DefaultStartScreen {
    MAIN, EXPENSES, DEBTS
}

enum class Theme {
    DARK, LIGHT
}
