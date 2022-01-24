package barretina.arnau.calers.expenses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import barretina.arnau.calers.databinding.FragmentExpensesBinding

class ExpensesFragment : Fragment() {

    private lateinit var binding: FragmentExpensesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExpensesBinding.inflate(inflater)
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        /*binding.btnExpenses.setOnClickListener {
            (activity as? MainActivity)?.navigateToExpensesFragment()
        }

        binding.btnDebts.setOnClickListener {
            (activity as? MainActivity)?.navigateToDebtsFragment()
        }*/
    }

    companion object {
        const val TAG = "ExpensesFragment"
    }
}
