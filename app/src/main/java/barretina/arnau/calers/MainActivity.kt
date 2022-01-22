package barretina.arnau.calers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import barretina.arnau.calers.Debts.DebtsFragment
import barretina.arnau.calers.Expenses.ExpensesFragment
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
        ft.addToBackStack(MainFragment.TAG)
        ft.commit()
    }

    fun navigateToExpensesFragment() {
        val fragment = ExpensesFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.mainContainer.id, fragment, ExpensesFragment.TAG)
        ft.addToBackStack(ExpensesFragment.TAG)
        ft.commit()
    }

    fun navigateToDebtsFragment() {
        val fragment = DebtsFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.mainContainer.id, fragment, DebtsFragment.TAG)
        ft.addToBackStack(DebtsFragment.TAG)
        ft.commit()
    }

    private fun configureNavigationBar() {
        binding.navBar.setListener(object : NavigationBar.NavigationBarListener {
            override fun backButtonPressed() {
                // TODO: Manage back/close navigations and set the icon properly
                Toast.makeText(baseContext, "BACK BUTTON PRESSED", Toast.LENGTH_SHORT).show()
            }

            override fun settingsButtonPressed() {
                // TODO: Open the settings screen/pop up/bottom sheet fragment
                Toast.makeText(baseContext, "SETTINGS BUTTON PRESSED", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
