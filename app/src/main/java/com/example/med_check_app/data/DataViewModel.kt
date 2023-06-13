package com.example.med_check_app.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.med_check_app.data.Reminder
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DataViewModel: ViewModel(){
    val state = mutableStateOf(Reminder())

    init {
        getData()
    }

    private fun getData(medType:String){
        viewModelScope.launch {
            val medicinName = medType
            state.value = getMedicinDescription(medicinName)
        }
    }
}

suspend fun getMedicinDescription(medicinName: String):Reminder{
    val db = FirebaseFirestore.getInstance()
    var Medicin = Reminder()

    try {
        db.collection("Medicin").whereEqualTo("Name", medicinName).get().await().map {
            val result = it.toObject(Reminder::class.java)
            Medicin = result
        }
    }catch (e: FirebaseFirestoreException){
        Log.d("error", "getMedicinDescription: $e")
    }

    return Medicin
}