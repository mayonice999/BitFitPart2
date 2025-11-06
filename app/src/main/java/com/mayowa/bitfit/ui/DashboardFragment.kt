package com.mayowa.bitfit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.mayowa.bitfit.databinding.FragmentDashboardBinding
import com.mayowa.bitfit.data.AppDatabase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dao = AppDatabase.getInstance(requireContext()).entryDao()

        viewLifecycleOwner.lifecycleScope.launch {
            dao.getTotalMl().collectLatest { totalMl ->
                val totalL = (totalMl ?: 0L) / 1000.0
                binding.tvTotal.text = String.format("Total (L): %.2f", totalL)
                binding.tvEmpty.visibility = if ((totalMl ?: 0L) == 0L) View.VISIBLE else View.GONE
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            dao.getAvgMl().collectLatest { avgMl ->
                val avgL = (avgMl ?: 0.0) / 1000.0
                binding.tvAvg.text = String.format("Average (L): %.2f", avgL)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
