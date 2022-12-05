package com.example.squads.screens.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {
    // list of all the users attributes
    private val _account = MutableLiveData<Account>()
    val account: LiveData<Account>
        get() = _account
    init {
        getAccountData()
    }

    // get all the current user from the API
    fun getAccountData() {
        // for fake data :)
        _account.value = Account(
            523, "Kevin", "De Tester", "Kevin@DeTester@protonmail.com", "+32 458 684 726",
            Address(
                "Raamvanonderstraat", "21", "Brugge", 8000
            ),
            172, "Moeilijk te been & gebroken arm", "Veel pijnstillers", "KevinIsCool31"
        )
    }
}
