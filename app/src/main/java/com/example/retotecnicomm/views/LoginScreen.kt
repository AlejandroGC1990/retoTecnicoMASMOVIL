package com.example.retotecnicomm.views

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.retotecnicomm.navigation.Screens
import com.example.retotecnicomm.viewmodel.LoginScreenViewModel


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val showLoginForm = rememberSaveable{
        mutableStateOf(true)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            if (showLoginForm.value) {
                Text(text="Iniciar Sesión")
                UserForm(isCreateAccount = false){email, password ->
                    viewModel.signInWithEmailAndPassword(email, password){
                        Log.d("RetoTécnicoMM", "Logueado con $email y $password")
                        navController.navigate(Screens.HomeScreen.name)
                    }
                }
            }else{
                Text(text="Crear Sesión")
                UserForm(isCreateAccount = true){
                        email, password ->
                    Log.d("RetoTécnicoMM", "Creando con $email y $password")
                    viewModel.createUsersWithEmailandPassword(email, password){
                        navController.navigate(Screens.HomeScreen.name)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                val text1 =
                    if(showLoginForm.value) "¿No tienes cuenta?"
                    else "¿Ya tienes cuenta?"
                val text2 =
                    if(showLoginForm.value) "Registrate"
                    else "Iniciar Sesión"
                (Text(text = text1))
                (Text(
                    text = text2,
                    modifier = Modifier
                        .clickable {showLoginForm.value = !showLoginForm.value}
                        .padding(start = 5.dp),
                        color = MaterialTheme.colorScheme.secondary
                    )
                )
            }
        }
    }

//    var username by remember { mutableStateOf("Name") }
//    var password by remember { mutableStateOf("Password") }
//
//    val keyboardControler = LocalSoftwareKeyboardController.current
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ){
//        Text(text = "Login")
//
//        // Username TextField
//        TextField(
//            value=username,
//            onValueChange = {
//                username = it
//            },
//            keyboardOptions = KeyboardOptions(
//                imeAction = ImeAction.Next
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        )
//
//        // Password TextField
//        TextField(
//            value=password,
//            onValueChange = {
//                password = it
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Password,
//                imeAction = ImeAction.Done
//            ),
//            keyboardActions = KeyboardActions(
//                onNext = {
//                    keyboardControler?.hide()
//                }
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        )
//
//        Button(
//            onClick = { goToHome() },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        ) {
//            Text(text = "Login")
//        }
//    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserForm(
    isCreateAccount: Boolean = false,
    onDone: (String, String) -> Unit = {email, pwd ->}
) {
    val email = rememberSaveable {
        mutableStateOf("")
    }
    val password = rememberSaveable {
        mutableStateOf("")
    }
    val passwordVisible = rememberSaveable {
        mutableStateOf(false)
    }
    val valido = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }
    val keyboardControler = LocalSoftwareKeyboardController.current

    Column(horizontalAlignment = Alignment.CenterHorizontally){
        EmailInput(
            emailState = email
        )
        PasswordInput(
            passwordState = password,
            labelId= "Password",
            passwordVisible = passwordVisible
        )
        SubmitButton(
            textId = if(isCreateAccount) "Create Account" else "Login",
            inputValido = valido
        ){
            onDone(email.value.trim(), password.value.trim())
            keyboardControler?.hide()
        }
    }
}

@Composable
fun SubmitButton(
    textId: String,
    inputValido: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape,
        enabled = inputValido
    ) {
        Text(
            text = textId,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}

@Composable
fun PasswordInput(
    passwordState: MutableState<String>,
    labelId: String,
    passwordVisible: MutableState<Boolean>
) {
    val VisualTransformation = if(passwordVisible.value)
        VisualTransformation.None
    else PasswordVisualTransformation()

    OutlinedTextField(
        value = passwordState.value,
        onValueChange = {passwordState.value = it},
        label = {Text(text = labelId)},
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        visualTransformation = VisualTransformation,
        trailingIcon = {
            if(passwordState.value.isNotBlank()){
                PasswordVisibleIcon(passwordVisible)
            }else null
        }
    )
}

@Composable
fun PasswordVisibleIcon(
    passwordVisible: MutableState<Boolean>
) {
    val image =
        if(passwordVisible.value){
            Icons.Default.VisibilityOff
        }else{
            Icons.Default.Visibility
        }
    IconButton(onClick = {
        passwordVisible.value =!passwordVisible.value
    }){
        Icon(
            imageVector = image,
            contentDescription = ""
        )
    }
}

@Composable
fun EmailInput(
    emailState: MutableState<String>,
    labelId: String = "Email"
) {
    InputField(
        valueState = emailState,
        labelId = labelId,
        keyBoardType = KeyboardType.Email
    )
}

@Composable
fun InputField(
    valueState: MutableState<String>,
    labelId: String,
    isSingleLine: Boolean = true,
    keyBoardType: KeyboardType
) {
    OutlinedTextField(
        value=valueState.value,
        onValueChange = {valueState.value = it},
        label = {Text(text = labelId)},
        singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType
        ),
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
    )
}

