package barretina.arnau.calers.debts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import barretina.arnau.calers.databinding.FragmentDebtsBinding

class DebtsFragment : Fragment() {

    private lateinit var binding: FragmentDebtsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDebtsBinding.inflate(inflater)
        initListeners()
        return binding.root
    }

    private fun initListeners() {
/*        binding.btnExpenses.setOnClickListener {
            (activity as? MainActivity)?.navigateToExpensesFragment()
        }

        binding.btnDebts.setOnClickListener {
            (activity as? MainActivity)?.navigateToDebtsFragment()
        }*/
    }

    companion object {
        const val TAG = "DebtsFragment"
    }
}
