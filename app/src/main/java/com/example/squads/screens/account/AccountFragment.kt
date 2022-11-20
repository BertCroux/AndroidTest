package com.example.squads.screens.account
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
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

        addObservers()

        return binding.root
    }

    private fun addObservers() {
        //observer for the latest measurement
        accountViewModel.account.observe(viewLifecycleOwner, Observer { acc ->
            //if the account changes, all must be updated
            acc.let {
                binding.name.text = String.format("%s %s", it.firstName, it.lastName)
                binding.userId.text = String.format("User-ID: %d", it.userId)
                binding.email.text = it.email
                binding.phonenumber.text = it.phoneNumber
                binding.address.text = String.format(
                    "%s %s %s %s",
                    it.address.street,
                    it.address.number,
                    it.address.zipCode,
                    it.address.city
                )
                binding.lengte.text = String.format("%dcm", it.lengthInCm)
                binding.issues.text = it.physicalIssues
                binding.drugs.text = it.drugsUsed
                binding.drugs.text = it.drugsUsed
            }
        })
    }
}