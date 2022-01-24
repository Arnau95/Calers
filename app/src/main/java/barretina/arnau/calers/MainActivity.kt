package barretina.arnau.calers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import barretina.arnau.calers.debts.DebtsFragment
import barretina.arnau.calers.expenses.ExpensesFragment
import barretina.arnau.calers.settings.SettingsFragment
import barretina.arnau.calers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        navigateToMainFragment()
        configureNavigationBar()
    }

    fun navigateToMainFragment() {
        val fragment = MainFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.mainContainer.id, fragment, MainFragment.TAG)
        //ft.addToBackStack(MainFragment.TAG)
        ft.commit()
    }

    fun navigateToExpensesFragment() {
        val fragment = ExpensesFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.mainContainer.id, fragment, ExpensesFragment.TAG)
        ft.addToBackStack(ExpensesFragment.TAG)
        ft.commit()

        binding.navBar.toggleBackButton(true)
    }

    fun navigateToDebtsFragment() {
        val fragment = DebtsFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.mainContainer.id, fragment, DebtsFragment.TAG)
        ft.addToBackStack(DebtsFragment.TAG)
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

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            binding.navBar.toggleBackButton(false)
        }

        supportFragmentManager.fragments.forEach {
            if (it is MainFragment) {
                showExitAppDialog()
            } else {
                super.onBackPressed()
            }
        }
    }
}
