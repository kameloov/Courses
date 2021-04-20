package com.touta.courses.ui.user.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.touta.courses.R
import com.touta.courses.adapter.ErrorAdapter
import com.touta.courses.api.Resource
import com.touta.courses.api.request.LoginRequest
import com.touta.courses.ui.user.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val usersViewModel : UsersViewModel by activityViewModels()
    private val errorAdapter : ErrorAdapter = ErrorAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
    }

    private fun init(){
        lstLoginErrors.adapter  = errorAdapter
        lstLoginErrors.layoutManager = LinearLayoutManager(context)
        btnLogin.setOnClickListener {
            val email = txtEmail.text.toString()
            val password = txtPassword.text.toString()
            usersViewModel.login(LoginRequest(email,password))
        }
        txtNavRegister.setOnClickListener{
            showRegister()
        }
    }

    private fun observe(){
        with(usersViewModel){
            // observe input errors for pre login
            loginErrors.observe(viewLifecycleOwner,{
                errorAdapter.submitList(it)
            })
            // observe login result
            loginState.observe(viewLifecycleOwner,{
                when (it) {
                   is  Resource.Success<*> ->{
                       progressBar.visibility = View.INVISIBLE
                       Snackbar.make(requireView(),getString(R.string.login_success),Snackbar.LENGTH_LONG).show()
                   }
                    is Resource.Error<*> ->{
                        progressBar.visibility = View.INVISIBLE
                        Snackbar.make(requireView(),getString(R.string.login_error),Snackbar.LENGTH_LONG).show()
                    }
                    is Resource.Loading -> progressBar.visibility = View.VISIBLE
                }
            })
        }
    }

    private fun showRegister(){
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }
}