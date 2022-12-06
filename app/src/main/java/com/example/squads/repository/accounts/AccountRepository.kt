package com.example.squads.repository.accounts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.squads.database.SquadsRoomDatabase
import com.example.squads.database.accounts.asDomain
import com.example.squads.domain.accounts.Account
import com.example.squads.network.accounts.AccountApi
import com.example.squads.network.accounts.asDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccountRepository(private val database: SquadsRoomDatabase) {
    //val account = MutableLiveData(database.accountDao.getAccountDetails(1).value?.asDomain())

    val account = database.accountDao.getAccountDetails(1)




    suspend fun refreshAccount() {
        withContext(Dispatchers.IO) {
            val account = AccountApi.retrofitService.getUserDetailsAsync(1).await()
            database.accountDao.insert(account.asDatabase())
        }
    }
}