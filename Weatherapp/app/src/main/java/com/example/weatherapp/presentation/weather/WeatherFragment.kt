package com.example.weatherapp.presentation.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.weatherapp.databinding.FragmentWeatherBinding

class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<WeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val args by navArgs<WeatherFragmentArgs>()

        viewModel.loadWeather(args.city)

        viewModel.weatherLiveData.observe(viewLifecycleOwner) {
            if (it?.current != null) {
                binding.textViewCondition.text = it.current.weatherDescriptions.first()
                binding.textViewTemperature.text = "${it.current.temperature} °C"
                binding.textViewFeelsLikeTemperature.text = "Відчувається як ${it.current.feelslike} °C"
                binding.textViewWind.text = "Вітер: ${it.current.windDegree}, ${it.current.windSpeed} м/с"
                binding.textViewPrecipitation.text = "Опади: ${it.current.precip} мм"
                binding.textViewVisibility.text = "Видимість: ${it.current.visibility} км"
                binding.imageViewCardView.visibility = View.VISIBLE
                Glide.with(requireContext()).load(it.current.weatherIcons.first()).into(binding.imageViewConditionIcon)
            } else {
                binding.errorLayout.visibility = View.VISIBLE
                binding.weatherLayout.visibility = View.GONE
            }
            binding.groupLoading.visibility = View.GONE
        }

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}