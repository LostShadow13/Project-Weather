package com.example.weatherapp.presentation.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.databinding.FragmentCityBinding

class CityFragment : Fragment() {
    private var _binding: FragmentCityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.getWeatherButton.setOnClickListener {
            val city = binding.cityEditText.text.toString().trim()

            if (city.isNotEmpty()) {
                findNavController().navigate(CityFragmentDirections.actionCityFragmentToWeatherFragment(city))
            } else {
                Toast.makeText(requireContext(), "No city provided!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}