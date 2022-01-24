package barretina.arnau.calers.settings.datasources

import android.content.Context

interface SettingsMemoryDataSource {

    val context: Context

    suspend fun saveSelectedLanguage(language: String)

    suspend fun saveDefaultStartScreen(screen: String)

    suspend fun saveSelectedTheme(theme: String)

    suspend fun getSelectedLanguage(): String?

    suspend fun getDefaultStartScreen(): String?

    suspend fun getSelectedTheme(): String?

    fun getAvailableLanguages(): ArrayList<String>

    fun getAvailableScreens(): ArrayList<String>

    fun getAvailableThemes(): ArrayList<String>

}

enum class Language {
    ENGLISH, CATALAN, SPANISH
}

enum class DefaultStartScreen {
    MAIN, EXPENSES, DEBTS
}

enum class Theme {
    DARK, LIGHT
}
