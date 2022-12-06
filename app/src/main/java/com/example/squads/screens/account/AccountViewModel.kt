package com.example.squads.screens.account

import android.app.Application
import androidx.lifecycle.*
import com.example.squads.database.SquadsRoomDatabase
import com.example.squads.database.accounts.asDomain
import com.example.squads.repository.accounts.AccountRepository
import com.example.squads.screens.myhealth.MyHealthViewModel
import kotlinx.coroutines.launch

class AccountViewModel(application: Application) : AndroidViewModel(application)  {
    private val database = SquadsRoomDatabase.getInstance(application.applicationContext)
    private val repository = AccountRepository(database)

    //list of all the users attributes
/*    private val _account = MutableLiveData<Account>()
    val account: LiveData<Account>
        get() = _account*/

    val account = Transformations.map(repository.account.asLiveData()) {
        it.asDomain()
    }

    init {
        viewModelScope.launch {
            repository.refreshAccount()
        }
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AccountViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AccountViewModel(app) as T
            }

            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

    //get all the current user from the API
    /*fun getAccountData() {
        //for fake data :)
        _account.value = Account(
            523, "Kevin", "De Tester","Kevin@DeTester@protonmail.com", "+32 458 684 726", Address(
                "Raamvanonderstraat", "21", "Brugge", 8000
            ), 172, "Moeilijk te been & gebroken arm", "Veel pijnstillers", "KevinIsCool31"
        )
    }*/
}