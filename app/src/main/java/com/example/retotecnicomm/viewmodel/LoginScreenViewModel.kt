package com.example.retotecnicomm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData<Boolean>(false)

    fun signInWithEmailAndPassword(
        email: String, password: String, home: ()-> Unit
    ) = viewModelScope.launch{
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Log.d("retotecnicomm", "signInWithEmailAndPassword done!!")
                        home()
                    }else{
                        Log.d("retotecnicomm", "signInWithEmailAndPassword: ${task.result.toString()}")
                    }
                }
        }
        catch(ex:Exception){
            Log.d("retotecnicomm", "signInWithEmailAndPassword: ${ex.message}")
        }

    }
}