package com.touta.courses.model

import com.touta.courses.R
import com.touta.courses.api.request.RegistrationRequest

import org.junit.Assert.*
import org.junit.Test

class RegistrationRequestTest {
    @Test
    fun `validate_registeration_returns_short_password`(){
        val data = RegistrationRequest("aa@bb.com","12456","12456",
            "kamel","","")
        val errors = RegistrationRequest.getErrors(data)
        val expected = intArrayOf(R.string.password_short)
        assertArrayEquals(errors.toIntArray(), expected)
    }

    @Test
    fun `validate registeration returns empty`(){
        val data = RegistrationRequest("aa@bb.com","12453336","12453336",
            "","","")
        val errors = RegistrationRequest.getErrors(data)
        val expected = intArrayOf(R.string.fill_empty)
        assertArrayEquals(errors.toIntArray(), expected)
    }

    @Test
    fun `validate registeration returns confirmation issue`(){
        val data = RegistrationRequest("aa@bb.com","12453336","124513336",
            "kameloov","","")
        val errors = RegistrationRequest.getErrors(data)
        val expected = intArrayOf(R.string.confirm_not_match)
        assertArrayEquals(errors.toIntArray(), expected)
    }


    @Test
    fun `validate registeration returns success`(){
        val data = RegistrationRequest("aa@bb.com","12453336","12453336",
            "kameloov","","")
        val errors = RegistrationRequest.getErrors(data)
        val expected = intArrayOf()
        assert(errors.size == 0)
    }
}