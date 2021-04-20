package com.touta.courses.ui.user.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.touta.courses.R
import com.touta.courses.adapter.ErrorAdapter
import com.touta.courses.api.Resource
import com.touta.courses.api.request.RegistrationRequest
import com.touta.courses.ui.user.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.register_fragment.*

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.register_fragment) {


    private  val userViewModel: UsersViewModel by activityViewModels()
    //private  val userViewModel: UsersViewModel by viewModels()
    private lateinit var errorAdapter : ErrorAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRegister.setOnClickListener {
            val name = edtRegName.text.toString()
            val email = edtRegEmail.text.toString()
            val phone = edtRegPhone.text.toString()
            val password = edtregPassword.text.toString()
            val confirm = edtRegConfirm.text.toString()
            val registrationRequest = RegistrationRequest(email, password, confirm, name, phone, "" )
            userViewModel.register(registrationRequest)
        }

        txtNavLogin.setOnClickListener{
            showLogin()
        }

        initAdapter()
        observe()
    }

    private fun observe(){
        userViewModel.registrationErrors.observe(viewLifecycleOwner, Observer {
            print(it.toString())
            errorAdapter.submitList(it) })
        userViewModel.registerState.observe(viewLifecycleOwner,{
            when (it) {
                is Resource.Success<*> -> {
                    progressBar2.visibility = View.INVISIBLE
                    Snackbar.make(requireView(),getString(R.string.register_success),Snackbar.LENGTH_SHORT).show()
                }
                is Resource.Error<*> ->{
                    progressBar2.visibility = View.INVISIBLE
                    Snackbar.make(requireView(),getString(R.string.register_error),Snackbar.LENGTH_SHORT).show()
                }
                is Resource.Loading ->progressBar2.visibility = View.VISIBLE
            }
        })
    }

    private fun initAdapter(){
        errorAdapter = ErrorAdapter()
        lstErrors.layoutManager = LinearLayoutManager(context)
        lstErrors.adapter = errorAdapter
    }

    private fun showLogin(){
        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
    }

}