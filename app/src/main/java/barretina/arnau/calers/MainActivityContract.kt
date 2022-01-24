package barretina.arnau.calers

import android.content.Context
import barretina.arnau.calers.utils.BaseContract

interface MainActivityContract {

    interface View: BaseContract.View {
        fun navigateToMainFragment()

        fun navigateToExpensesFragment()

        fun navigateToDebtsFragment()
    }

    interface Presenter: BaseContract.Presenter<View> {
        val context: Context

        fun initialize()
    }
}
