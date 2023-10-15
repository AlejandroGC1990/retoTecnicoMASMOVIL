package com.example.retotecnicomm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retotecnicomm.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
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

    fun createUsersWithEmailandPassword(
        email:String,
        password: String,
        home: ()-> Unit
    ){
        if(_loading.value == false){
            _loading.value = true
            viewModelScope.launch{
                try {
                    auth.createUserWithEmailAndPassword(email, password)
                      .addOnCompleteListener { task ->
                            if(task.isSuccessful){
                                val displayName = task.result?.user?.email?.split("@")?.get(0)
                                createUser(displayName)
                                home()
                            }else{
                                Log.d("retotecnicomm", "createUserWithEmailandPassword: ${task.result.toString()}")
                            }
                        }
                }
                catch(ex:Exception){
                    Log.d("retotecnicomm", "createUserWithEmailandPassword: ${ex.message}")
                }
                _loading.value = false
            }
        }
    }

    private fun createUser(displayName: String?) {
        val userId = auth.currentUser?.uid
//        val user = mutableMapOf<String, Any>()
//
//        user["user_id"] = userId.toString()
//        user["display_name"] = displayName.toString()

        //Usando data class para crear ususarios
        val user = User(
            userId = userId.toString(),
            displayName = displayName.toString(),
            avatarUrl = "",
            quote = "patata",
            profession = "dev",
            id = null
        ).toMap()

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener {
                Log.d("retotecnicomm", "creado ${it.id}")
            }.addOnFailureListener{
                Log.d("retotecnicomm", "error al crear ${it}")
            }
    }
}