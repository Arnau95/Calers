package barretina.arnau.calers

import android.content.Context
import barretina.arnau.calers.settings.datasources.DefaultStartScreen
import barretina.arnau.calers.settings.datasources.SettingsMemoryDataSourceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityPresenter(override val context: Context) : MainActivityContract.Presenter {

    override var view: MainActivityContract.View? = null

    private val settings: SettingsMemoryDataSourceImp = SettingsMemoryDataSourceImp(context)

    override fun initialize() {
        GlobalScope.launch(Dispatchers.IO) {
            when (settings.getDefaultStartScreen()) {
                DefaultStartScreen.EXPENSES.toString() -> view?.navigateToExpensesFragment()
                DefaultStartScreen.DEBTS.toString() -> view?.navigateToDebtsFragment()
                else -> view?.navigateToMainFragment()
            }
        }
    }
}
