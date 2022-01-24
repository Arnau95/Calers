package barretina.arnau.calers.extensions

import android.content.Context

fun Context.getSavedString(sharedPreferenceName: String, stringTag: String): String? {
    return getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE).getString(
        stringTag,
        null
    )
}

fun Context.saveString(sharedPreferenceName: String, stringTag: String, stringValue: String) {
    getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE).edit()
        .putString(stringTag, stringValue).apply()
}
