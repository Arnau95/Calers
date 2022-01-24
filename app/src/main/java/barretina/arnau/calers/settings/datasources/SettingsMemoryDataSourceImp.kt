package barretina.arnau.calers.settings.datasources

import android.content.Context
import barretina.arnau.calers.extensions.getSavedString
import barretina.arnau.calers.extensions.saveString

class SettingsMemoryDataSourceImp(override val context: Context) : SettingsMemoryDataSource {

    override suspend fun saveSelectedLanguage(language: String) {
        context.saveString(SETTINGS_SHARED_PREFERENCE, SAVED_LANGUAGE_TAG, language)
    }

    override suspend fun saveDefaultStartScreen(screen: String) {
        context.saveString(SETTINGS_SHARED_PREFERENCE, SAVED_DEFAULT_SCREEN_TAG, screen)
    }

    override suspend fun saveSelectedTheme(theme: String) {
        context.saveString(SETTINGS_SHARED_PREFERENCE, SAVED_THEME_TAG, theme)
    }

    override suspend fun getSelectedLanguage(): String? {
        return context.getSavedString(SETTINGS_SHARED_PREFERENCE, SAVED_LANGUAGE_TAG)
    }

    override suspend fun getDefaultStartScreen(): String? {
        return context.getSavedString(SETTINGS_SHARED_PREFERENCE, SAVED_DEFAULT_SCREEN_TAG)
    }

    override suspend fun getSelectedTheme(): String? {
        return context.getSavedString(SETTINGS_SHARED_PREFERENCE, SAVED_THEME_TAG)
    }

    override fun getAvailableLanguages(): ArrayList<String> {
        val languages: ArrayList<String> = ArrayList()
        Language.values().forEach {
            languages.add(it.name)
        }
        return languages
    }

    override fun getAvailableScreens(): ArrayList<String> {
        val screens: ArrayList<String> = ArrayList()
        DefaultStartScreen.values().forEach {
            screens.add(it.name)
        }
        return screens
    }

    override fun getAvailableThemes(): ArrayList<String> {
        val themes: ArrayList<String> = ArrayList()
        Theme.values().forEach {
            themes.add(it.name)
        }
        return themes
    }


    companion object {
        const val SETTINGS_SHARED_PREFERENCE = "SP_SETTINGS"

        const val SAVED_DEFAULT_SCREEN_TAG = "saved_screen"
        const val SAVED_LANGUAGE_TAG = "saved_language"
        const val SAVED_THEME_TAG = "saved_theme"
    }
}