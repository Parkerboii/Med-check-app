package com.example.med_check_app.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DataViewModel: ViewModel(){
    val state = mutableStateOf(MedicinData())

    fun getData(medicinName: String){
        viewModelScope.launch {
            state.value = getMedicinDescription(medicinName)
        }
    }
}

suspend fun getMedicinDescription(medicinName: String):MedicinData{
    val db = FirebaseFirestore.getInstance()
    var Medicin = MedicinData()

    try {
        db.collection("Medicin")
            .whereEqualTo("Name", medicinName)
            .get()
            .await().map {
                val result = it.toObject(MedicinData::class.java)
                Medicin = result
            }
    }catch (e: FirebaseFirestoreException){
        Log.d("error", "getMedicinDescription: $e")
    }

    return Medicin
}