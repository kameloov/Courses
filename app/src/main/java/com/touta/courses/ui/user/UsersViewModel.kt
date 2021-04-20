package com.touta.courses.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.touta.courses.api.Resource
import com.touta.courses.api.request.LoginRequest
import com.touta.courses.api.request.RegistrationRequest
import com.touta.courses.model.User
import com.touta.courses.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel
@Inject
constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _registerState : MutableLiveData<Resource> = MutableLiveData()
    private val _loginState : MutableLiveData<Resource> = MutableLiveData()
    private val _registrationErrors : MutableLiveData<List<Int>> = MutableLiveData()
    private val _loginErrors : MutableLiveData<List<Int>> = MutableLiveData()

    val registerState : LiveData<Resource> get() = _registerState
    val loginState : LiveData<Resource> get() = _loginState
    val registrationErrors : LiveData<List<Int>> = _registrationErrors
    val loginErrors : LiveData<List<Int>> = _loginErrors


    fun login (loginRequest: LoginRequest){
        val  errors = LoginRequest.getErrors(loginRequest)
        if (errors.isNotEmpty()) {
            _loginErrors.postValue(errors)
            return
        }
        _loginErrors.value = listOf()
        _loginState.value = Resource.Loading()
        viewModelScope.launch {
            val response = userRepository.login(loginRequest)
            response?.let {
                var result =
                    if (it.data.isNullOrEmpty())
                        Resource.Error<Int>(it.code?:0)
                    else

                        Resource.Success<List<User>>(it.data!!)
                _loginState.postValue(result)
            }
        }
    }

    fun register(info : RegistrationRequest){

        val errors = RegistrationRequest.getErrors(info)
        // Validate Input and display any error messages
        if (errors.isNotEmpty()){
            _registrationErrors.value = errors
            return
        }
        _registrationErrors.value = listOf()
        _registerState.value = Resource.Loading()
        // input is valid , we can continue registration process
        viewModelScope.launch {
            val result = userRepository.register(info)
            if (result!= null) {
                val res = if (result.data != null)
                    Resource.Success<Int>(result.data)
                else
                    Resource.Error<Int>(result.code?:0)
                _registerState.postValue(res)
            } else
                _registerState.postValue(Resource.Error<Int>(-1))
        }
    }

}