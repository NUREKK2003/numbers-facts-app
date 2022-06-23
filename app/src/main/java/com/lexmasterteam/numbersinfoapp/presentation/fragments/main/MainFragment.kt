package com.lexmasterteam.numbersinfoapp.presentation.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lexmasterteam.numbersinfoapp.R
import com.lexmasterteam.numbersinfoapp.databinding.FragmentMainBinding
import com.lexmasterteam.numbersinfoapp.presentation.viewmodels.NumberFactViewModel
import com.lexmasterteam.numbersinfoapp.presentation.viewmodels.NumbersFactsSavedViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModelDB by viewModels<NumbersFactsSavedViewModel>()
    private val viewModelApi by viewModels<NumberFactViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = NumberFactAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        // pogłówkuj nad tym jak tu obserwera dodać (może zmienić gdzieś listę na mutable list?)
        adapter.setData(viewModelDB.state.value.facts)

    }








}