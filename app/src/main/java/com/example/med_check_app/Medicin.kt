import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun MedicinContent() {
    var selectedOption by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(bottom = 100.dp)
        ) {
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            selectedOption = "Paracetamol: Til voksne er den sædvanlige dosis 2 tabletter (1 gram) 3-4 gange dagligt. Hvis du har konstante smerter, anbefaler vi, at du tager dine tabletter i faste doser fordelt over døgnets timer."
                        },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, if (selectedOption == "Paracetamol: Til voksne er den sædvanlige dosis 2 tabletter (1 gram) 3-4 gange dagligt. Hvis du har konstante smerter, anbefaler vi, at du tager dine tabletter i faste doser fordelt over døgnets timer.") Color(0xFF6200EE) else Color.Gray)
                ) {
                    Text(
                        text = "Paracetamol",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                if (selectedOption == "Paracetamol: Til voksne er den sædvanlige dosis 2 tabletter (1 gram) 3-4 gange dagligt. Hvis du har konstante smerter, anbefaler vi, at du tager dine tabletter i faste doser fordelt over døgnets timer.") {
                    TextField(
                        value = selectedOption,
                        onValueChange = { /* No-op */ },
                        label = { Text(text = "Medicin forklaring") },
                        readOnly = true,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            selectedOption = "Morfin: Morfin og andre opioider kan påvirke ens hukommelses- og koncentrationsevne, og man kan blive konfus eller døsig. Man kan også opleve hudkløe, sved, mundtørhed og svimmelhed."
                        },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, if (selectedOption == "Morfin: Morfin og andre opioider kan påvirke ens hukommelses- og koncentrationsevne, og man kan blive konfus eller døsig. Man kan også opleve hudkløe, sved, mundtørhed og svimmelhed.") Color(0xFF6200EE) else Color.Gray)
                ) {
                    Text(
                        text = "Morfin",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                if (selectedOption == "Morfin: Morfin og andre opioider kan påvirke ens hukommelses- og koncentrationsevne, og man kan blive konfus eller døsig. Man kan også opleve hudkløe, sved, mundtørhed og svimmelhed.") {
                    TextField(
                        value = selectedOption,
                        onValueChange = { /* No-op */ },
                        label = { Text(text = "Medicin forklaring") },
                        readOnly = true,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            selectedOption = "Propanolol: Propranolol er et middel mod for højt blodtryk, angina pectoris og hjerterytmeforstyrrelser. Det er også et effektivt middel mod migræne."
                        },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, if (selectedOption == "Propanolol: Propranolol er et middel mod for højt blodtryk, angina pectoris og hjerterytmeforstyrrelser. Det er også et effektivt middel mod migræne.") Color(0xFF6200EE) else Color.Gray)
                ) {
                    Text(
                        text = "Propanolol",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                if (selectedOption == "Propanolol: Propranolol er et middel mod for højt blodtryk, angina pectoris og hjerterytmeforstyrrelser. Det er også et effektivt middel mod migræne.") {
                    TextField(
                        value = selectedOption,
                        onValueChange = { /* No-op */ },
                        label = { Text(text = "Medicin forklaring") },
                        readOnly = true,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            selectedOption = "Terbutalin: Terbutalin anvendes ved astma, som er en lungesygdom. Astma skyldes en inflammation, dvs. en betændelsestilstand, i luftvejene."
                        },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, if (selectedOption == "Terbutalin: Terbutalin anvendes ved astma, som er en lungesygdom. Astma skyldes en inflammation, dvs. en betændelsestilstand, i luftvejene.") Color(0xFF6200EE) else Color.Gray)
                ) {
                    Text(
                        text = "Terbutalin",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                if (selectedOption == "Terbutalin: Terbutalin anvendes ved astma, som er en lungesygdom. Astma skyldes en inflammation, dvs. en betændelsestilstand, i luftvejene.") {
                    TextField(
                        value = selectedOption,
                        onValueChange = { /* No-op */ },
                        label = { Text(text = "Medicin forklaring") },
                        readOnly = true,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
        }

        if (selectedOption.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        selectedOption = ""
                    }
            )
        }
    }
}

@Composable
fun MedicinTopBar() {
    TopAppBar(title = {
        Text(
            text = "Medicin Information",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
        )
    })
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MedicinPage() {
    Scaffold(
        topBar = { MedicinTopBar() },
        content = { MedicinContent() }
    )
}
