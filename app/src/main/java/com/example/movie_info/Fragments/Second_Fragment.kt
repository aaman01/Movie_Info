package com.example.movie_info.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.movie_info.Database.MovieDatabase
import com.example.movie_info.Reycler_Adapter.Adapter2
import com.example.movie_info.api.Movieapi
import com.example.movie_info.databinding.FragmentSecondBinding
import com.example.movie_info.repository.Repository
import com.example.movie_info.viewmodels.MainViewModel
import com.example.movie_info.viewmodels.MainViewModelFactory
import com.example.movie_infol.api.retrofithelper
import kotlinx.coroutines.launch


class Second_Fragment : Fragment() {
    lateinit var mainViewModel: MainViewModel
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()

        lifecycleScope.launch {

            MovieDatabase.getDatabase(requireActivity()).moviedao().getfav().observe(
                viewLifecycleOwner, Observer {
                    binding.recyclerview.apply {
                        layoutManager = LinearLayoutManager(requireView().context)
                        adapter = Adapter2(mainViewModel).apply {
                            setdata(it)
                        }
                    }
                }
            )


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    private fun initialization() {

        val movieapi = retrofithelper.getInstance().create(Movieapi::class.java)
        val movieDatabase = MovieDatabase.getDatabase(requireContext())
        val repository = Repository(movieapi, movieDatabase)
        mainViewModel = ViewModelProvider(
            this@Second_Fragment,
            MainViewModelFactory(repository)
        )[MainViewModel::class.java]
        mainViewModel.getmoviee("1")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}