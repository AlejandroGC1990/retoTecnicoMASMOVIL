package com.example.retotecnicomm.presentation

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.retotecnicomm.api.ApiClient
import com.example.retotecnicomm.authentication.LoginRequest
import com.example.retotecnicomm.authentication.LoginResponse
import com.example.retotecnicomm.authentication.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginScreenViewModel : ViewModel() {
    private val apiClient = ApiClient().getApiService()

    fun login(context: Context, email: String, password: String, onLoginComplete: (Boolean) -> Unit) {
        val loginRequest = LoginRequest(email, password)
        val loginResultLiveData = mutableStateOf<LoginResult?>(null)
        val sessionManager = SessionManager(context)
        val call = apiClient.login(loginRequest)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        val user = loginResponse.user
                        val authToken = loginResponse.authToken
                        sessionManager.saveAuthToken(authToken)
//                        loginResultLiveData.value = LoginResult.Success(user)
                        onLoginComplete(true)
                    } else {
//                        loginResultLiveData.value = LoginResult.Error("Respuesta de inicio de sesión vacía o inválida")
                        onLoginComplete(false)
                    }
                } else {
//                    loginResultLiveData.value = LoginResult.Error("Error de servidor: ${response.code()}")
                    onLoginComplete(false)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                loginResultLiveData.value = LoginResult.Error("Error de red: ${t.message}")
                onLoginComplete(false)
            }
        })
    }
}


//class LoginScreenViewModel: ViewModel() {
//    private val auth: FirebaseAuth = Firebase.auth
//    private val _loading = MutableLiveData<Boolean>(false)
//
//    fun signInWithEmailAndPassword(
//        email: String, password: String, home: ()-> Unit
//    ) = viewModelScope.launch{
//        try {
//            auth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener { task ->
//                    if(task.isSuccessful){
//                        Log.d("retotecnicomm", "signInWithEmailAndPassword done!!")
//                        home()
//                    }else{
//                        Log.d("retotecnicomm", "signInWithEmailAndPassword: ${task.result.toString()}")
//                    }
//                }
//        }
//        catch(ex:Exception){
//            Log.d("retotecnicomm", "signInWithEmailAndPassword: ${ex.message}")
//        }
//
//    }
//
//    fun createUsersWithEmailandPassword(
//        email:String,
//        password: String,
//        home: ()-> Unit
//    ){
//        if(_loading.value == false){
//            _loading.value = true
//            viewModelScope.launch{
//                try {
//                    auth.createUserWithEmailAndPassword(email, password)
//                      .addOnCompleteListener { task ->
//                            if(task.isSuccessful){
//                                val displayName = task.result?.user?.email?.split("@")?.get(0)
//                                createUser(displayName)
//                                home()
//                            }else{
//                                Log.d("retotecnicomm", "createUserWithEmailandPassword: ${task.result.toString()}")
//                            }
//                        }
//                }
//                catch(ex:Exception){
//                    Log.d("retotecnicomm", "createUserWithEmailandPassword: ${ex.message}")
//                }
//                _loading.value = false
//            }
//        }
//    }
//
//    private fun createUser(displayName: String?) {
//        val userId = auth.currentUser?.uid
////        val user = mutableMapOf<String, Any>()
////
////        user["user_id"] = userId.toString()
////        user["display_name"] = displayName.toString()
//
//        //Usando data class para registrar usuarios
//        val user = User(
//            userId = userId.toString(),
//            displayName = displayName.toString(),
//            avatarUrl = "",
//            quote = "patata",
//            profession = "dev",
//            id = null
//        ).toMap()
//
//        FirebaseFirestore.getInstance().collection("users")
//            .add(user)
//            .addOnSuccessListener {
//                Log.d("retotecnicomm", "creado ${it.id}")
//            }.addOnFailureListener{
//                Log.d("retotecnicomm", "error al crear ${it}")
//            }
//    }
//}