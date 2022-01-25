package barretina.arnau.calers

import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import barretina.arnau.calers.debts.DebtsFragment
import barretina.arnau.calers.expenses.ExpensesFragment
import barretina.arnau.calers.settings.SettingsFragment
import barretina.arnau.calers.databinding.ActivityMainBinding
import barretina.arnau.calers.utils.LanguagesHelper
import java.util.*

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: MainActivityContract.Presenter

    private val languagesHelper: LanguagesHelper = LanguagesHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter = MainActivityPresenter(applicationContext)
        presenter.attachView(this)
        presenter.initialize()

        configureNavigationBar()
    }

    override fun navigateToMainFragment() {
        val fragment = MainFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.mainContainer.id, fragment, MainFragment.TAG)
        ft.commit()
    }

    override fun navigateToExpensesFragment() {
        val fragment = ExpensesFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.mainContainer.id, fragment, ExpensesFragment.TAG)
        ft.commit()

        binding.navBar.toggleBackButton(true)
    }

    override fun navigateToDebtsFragment() {
        val fragment = DebtsFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.mainContainer.id, fragment, DebtsFragment.TAG)
        ft.commit()

        binding.navBar.toggleBackButton(true)
    }

    fun showSettings() {
        val settingsFragment = SettingsFragment.newInstance("", "")
        supportFragmentManager.beginTransaction()
            .add(settingsFragment, SettingsFragment::class.java.name).commit()
    }

    private fun configureNavigationBar() {
        binding.navBar.setListener(object : NavigationBar.NavigationBarListener {
            override fun backButtonPressed() {
                onBackPressed()
            }

            override fun settingsButtonPressed() {
                binding.navBar.toggleSettingsButton(false)
                showSettings()
            }
        })
    }

    private fun showExitAppDialog() {
        val dialog = AlertDialog.Builder(this)
            .setMessage(R.string.exit_dialog_message)
            .setNegativeButton(R.string.cancel) { view, _ ->
                view.dismiss()
            }
            .setPositiveButton(R.string.accept) { _, _ ->
                finish()
            }
            .setCancelable(true)
            .create()

        dialog.show()
    }

    fun toggleSettingsButton(isEnabled: Boolean) {
        binding.navBar.toggleSettingsButton(isEnabled)
    }

    override fun setLocale(language: String?, mustRefresh: Boolean) {
        var localeCode = languagesHelper.getLocale(LanguagesHelper.AppLanguage.English)
        when (language) {
            languagesHelper.getLanguageName(LanguagesHelper.AppLanguage.Catalan) -> localeCode =
                languagesHelper.getLocale(LanguagesHelper.AppLanguage.Catalan)
            languagesHelper.getLanguageName(LanguagesHelper.AppLanguage.Spanish) -> localeCode =
                languagesHelper.getLocale(LanguagesHelper.AppLanguage.Spanish)
        }

        val locale = Locale(localeCode)
        Locale.setDefault(locale)
        val resources: Resources = this.resources
        val config: Configuration? = resources.configuration
        config?.let {
            it.setLocale(locale)
            resources.updateConfiguration(it, resources.displayMetrics)
        }

        if (mustRefresh) {
            val intent = intent
            finish()
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is MainFragment) {
                showExitAppDialog()
            } else {
                binding.navBar.toggleBackButton(false)
                navigateToMainFragment()
            }
        }
    }
}
