package com.dev.mycart.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dev.mycart.databinding.FragmentLogInBinding
import java.lang.RuntimeException
import javax.inject.Inject

class LogInFragment : Fragment() {

    private var _binding: FragmentLogInBinding? = null
    private val binding: FragmentLogInBinding
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
        _binding = FragmentLogInBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        binding.buttonLogIn.setOnClickListener {
            viewModel.logIn(
                binding.editTextLogIn.text.toString(),
                binding.editTextPassword.text.toString()
            )
        }
    }

    private fun observeViewModel() {
        viewModel.loggedIn.observe(viewLifecycleOwner) {
            if (it) {
                val intent = Intent(requireActivity(), MainActivity::class.java)
                startActivity(intent)
            } else {
                Log.d("yes", "no")
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}