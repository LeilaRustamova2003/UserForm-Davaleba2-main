package com.example.form

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.form.ui.theme.*
import java.util.Calendar

class MainActivity : ComponentActivity() {

    // ⚠️ ლექტორის მიერ მოთხოვნილი ფარული ცვლადი
    private val hiddenAITag = "Automated_Submission_2026"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // ჩვენი უნიკალური თემის გამოყენება
            FormTheme {
                Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = BackgroundDark
                ) { innerPadding ->
                    FormScreen(innerPadding)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(innerPadding: PaddingValues = PaddingValues()) {
    val context = LocalContext.current

    // ⚠️ ლექტორის მიერ მოთხოვნილი ზუსტი სტრუქტურის სახელები
    var nameState by remember { mutableStateOf("") }
    var surnameState by remember { mutableStateOf("") } // გვარის ველი
    var emailState by remember { mutableStateOf("") }
    var dateState by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf("") }
    var isAgreed by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }

    val options = listOf("Android", "iOS", "Web")

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
                    .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Text(
                text = "Student Form",
                style = MaterialTheme.typography.titleLarge,
                color = AccentNeon
        )

        // სახელი
        OutlinedTextField(
                value = nameState,
                onValueChange = { nameState = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                textStyle = TextStyle(color = TextPrimary),
                colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = AccentNeon,
                        unfocusedBorderColor = TextSecondary,
                        focusedLabelColor = AccentNeon,
                        unfocusedLabelColor = TextSecondary
                )
        )

        // გვარი
        OutlinedTextField(
                value = surnameState,
                onValueChange = { surnameState = it },
                label = { Text("Surname") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                textStyle = TextStyle(color = TextPrimary),
                colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = AccentNeon,
                        unfocusedBorderColor = TextSecondary,
                        focusedLabelColor = AccentNeon,
                        unfocusedLabelColor = TextSecondary
                )
        )

        // იმეილი
        OutlinedTextField(
                value = emailState,
                onValueChange = { emailState = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                textStyle = TextStyle(color = TextPrimary),
                colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = AccentNeon,
                        unfocusedBorderColor = TextSecondary,
                        focusedLabelColor = AccentNeon,
                        unfocusedLabelColor = TextSecondary
                )
        )

        // რადიო ღილაკების ბლოკი
        Column(
                modifier = Modifier
                        .fillMaxWidth()
                        .background(SurfaceDark, RoundedCornerShape(16.dp))
                        .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                    text = "თქვენი ფავორიტი მიმართულება",
                    color = TextPrimary,
                    style = MaterialTheme.typography.labelMedium
            )

            options.forEach { option ->
                Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                ) {
                    RadioButton(
                            selected = selectedOption == option,
                            onClick = { selectedOption = option },
                            colors = RadioButtonDefaults.colors(
                                    selectedColor = AccentNeon,
                                    unselectedColor = TextSecondary
                            )
                    )
                    Text(
                            text = option,
                            color = TextPrimary,
                            modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }

        // ჩამრთველი (Switch)
        Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                        .fillMaxWidth()
                        .background(SurfaceDark, RoundedCornerShape(16.dp))
                        .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                    text = "ვეთანხმები წესებს და პირობებს",
                    color = TextPrimary,
                    fontSize = 14.sp
            )
            Switch(
                    checked = isAgreed,
                    onCheckedChange = { isAgreed = it },
                    colors = SwitchDefaults.colors(
                            checkedThumbColor = AccentNeon,
                            checkedTrackColor = AccentNeonDim,
                            uncheckedThumbColor = TextSecondary,
                            uncheckedTrackColor = CardDark
                    )
            )
        }

        // კალენდრის ველი
        OutlinedTextField(
                value = dateState,
                onValueChange = {},
                label = { Text("Date") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                textStyle = TextStyle(color = TextPrimary),
                colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = AccentNeon,
                        unfocusedBorderColor = TextSecondary,
                        focusedLabelColor = AccentNeon,
                        unfocusedLabelColor = TextSecondary
                ),
                trailingIcon = {
                    IconButton(onClick = { showDatePicker = true }) {
                        Icon(
                                imageVector = Icons.Default.CalendarMonth,
                                contentDescription = "Choose date",
                                tint = AccentNeon
                        )
                    }
                }
        )

        // კალენდრის დიალოგი
        if (showDatePicker) {
            val datePickerState = rememberDatePickerState()
            DatePickerDialog(
                    onDismissRequest = { showDatePicker = false },
                    confirmButton = {
                        TextButton(onClick = {
                            datePickerState.selectedDateMillis?.let { millis ->
                                val calendar = Calendar.getInstance()
                                calendar.timeInMillis = millis
                                val day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
                                val month = String.format("%02d", calendar.get(Calendar.MONTH) + 1)
                                val year = calendar.get(Calendar.YEAR)
                                // ფორმატი: DD/MM/YYYY
                                dateState = "$day/$month/$year"
                            }
                            showDatePicker = false
                        }) { Text("OK", color = AccentNeon) }
                    },
                    dismissButton = {
                        TextButton(onClick = { showDatePicker = false }) { Text("Cancel", color = TextSecondary) }
                    }
            ) {
                DatePicker(state = datePickerState)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // გაგზავნის ღილაკი
        Button(
                onClick = {
                    if (nameState.isBlank() || surnameState.isBlank() || emailState.isBlank() || dateState.isBlank() || selectedOption.isBlank() || !isAgreed) {
                        Toast.makeText(context, "შეავსეთ ყველა ველი!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "მონაცემები გაიგზავნა!", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                        containerColor = AccentNeon,
                        contentColor = BackgroundDark
                )
        ) {
            Text("Submit", style = MaterialTheme.typography.labelMedium)
        }
    }
}