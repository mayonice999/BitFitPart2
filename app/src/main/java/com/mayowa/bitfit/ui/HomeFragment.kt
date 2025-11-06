package com.mayowa.bitfit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mayowa.bitfit.databinding.FragmentHomeBinding
import com.mayowa.bitfit.ui.adapter.EntryAdapter
import com.mayowa.bitfit.data.AppDatabase
import com.mayowa.bitfit.data.EntryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapter = EntryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter

        val dao = AppDatabase.getInstance(requireContext()).entryDao()

        // Load list
        viewLifecycleOwner.lifecycleScope.launch {
            dao.getAll().collectLatest { list ->
                adapter.submitList(list)
            }
        }

        binding.btnAdd.setOnClickListener {
            val text = binding.inputAmountMl.text.toString().trim()
            val ml = text.toIntOrNull()
            if (ml == null || ml <= 0) {
                Toast.makeText(requireContext(), "Enter a valid mL amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                dao.insert(EntryEntity(amountMl = ml, timestamp = System.currentTimeMillis()))
                withContext(Dispatchers.Main) {
                    binding.inputAmountMl.text?.clear()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
