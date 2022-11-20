package com.example.squads.screens.account
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.squads.databinding.FragmentAccountBinding


class AccountFragment : Fragment() {
    lateinit var binding: FragmentAccountBinding
    lateinit var accountViewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, com.example.squads.R.layout.fragment_account, container, false
        )

        //get the viewmodel
        val vm: AccountViewModel by activityViewModels()

        //set the viewmodel
        accountViewModel = vm

        // set the viewmodel in the xml file
        binding.accountViewModel = accountViewModel

        //implements the live data
        binding.lifecycleOwner = this


        return binding.root
    }
}