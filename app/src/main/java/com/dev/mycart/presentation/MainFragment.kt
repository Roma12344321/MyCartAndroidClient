package com.dev.mycart.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dev.mycart.databinding.FragmentMainBinding
import javax.inject.Inject

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("Binding is null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[LogInViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as MyCartApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}