package barretina.arnau.calers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val fragment: MainFragment = MainFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.mainContainer.id, fragment, MainFragment.TAG)
        //ft.addToBackStack(MainFragment.TAG)
        ft.commit()
    }

    fun navigateToExpensesFragment() {
        // TODO
        /*val fragment: MainFragment = MainFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.mainContainer.id, fragment, MainFragment.TAG)
        ft.addToBackStack(MainFragment.TAG)
        ft.commit()*/
    }

    fun navigateToDebtsFragment() {
        // TODO
        /*val fragment: MainFragment = MainFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.mainContainer.id, fragment, MainFragment.TAG)
        ft.addToBackStack(MainFragment.TAG)
        ft.commit()*/
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
