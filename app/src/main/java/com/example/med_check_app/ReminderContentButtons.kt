import androidx.compose.runtime.Composable
import android.content.DialogInterface
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource

@Composable
fun ReminderContentButtons() {
    val context = LocalContext.current

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            context,
            stringResource(android.R.string.yes),
            Toast.LENGTH_SHORT
        ).show()
    }
    val negativeButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            context,
            stringResource(android.R.string.no),
            Toast.LENGTH_SHORT
        ).show()
    }
    val neutralButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            context,
            "Maybe",
            Toast.LENGTH_SHORT
        ).show()
    }

    // Rest of your code
}
