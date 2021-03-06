package barretina.arnau.calers.expenses

import java.io.Serializable
import java.util.Calendar

data class Expense(
    val concept: String,
    val price: Float,
    val croCashback: Float
) : Serializable {
    val date = Calendar.getInstance()
}
