package barretina.arnau.calers.utils

class LanguagesHelper {

    fun getLanguagesList(): ArrayList<String> =
        arrayListOf(ENGLISH_NAME, CATALAN_NAME, SPANISH_NAME)

    fun getLocale(appLanguage: AppLanguage): String =
        when(appLanguage) {
            AppLanguage.Catalan -> CATALAN_LOCALE
            AppLanguage.Spanish -> SPANISH_LOCALE
            else -> ENGLISH_LOCALE
        }

    fun getLanguageName(appLanguage: AppLanguage): String =
        when(appLanguage) {
            AppLanguage.Catalan -> CATALAN_NAME
            AppLanguage.Spanish -> SPANISH_NAME
            else -> ENGLISH_NAME
        }

    fun getLanguageType(languageName: String): AppLanguage =
        when(languageName) {
            CATALAN_NAME -> AppLanguage.Catalan
            SPANISH_NAME -> AppLanguage.Spanish
            else -> AppLanguage.English
        }

    interface AppLanguage {

        object English : AppLanguage

        object Catalan : AppLanguage

        object Spanish : AppLanguage
    }

    companion object {
        private const val ENGLISH_LOCALE = "en"
        private const val CATALAN_LOCALE = "ca"
        private const val SPANISH_LOCALE = "es"

        private const val ENGLISH_NAME = "ENGLISH"
        private const val CATALAN_NAME = "CATALAN"
        private const val SPANISH_NAME = "SPANISH"
    }
}