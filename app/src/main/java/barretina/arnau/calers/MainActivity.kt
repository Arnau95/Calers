package barretina.arnau.calers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import barretina.arnau.calers.Debts.DebtsFragment
import barretina.arnau.calers.Expenses.ExpensesFragment
import barretina.arnau.calers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        navigateToMainFragment()
        //setContentView(R.layout.activity_main)
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

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
