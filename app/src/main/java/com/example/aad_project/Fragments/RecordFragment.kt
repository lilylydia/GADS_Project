package com.example.aad_project.Fragments

import  android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.aad_project.Adapters.RecordsAdapter
import com.example.aad_project.Model.RecordsViewModel
import com.example.aad_project.databinding.FragementRecordBinding


class RecordsFragment : Fragment() {

    private lateinit var mBinding: FragementRecordBinding
    private val viewModel: RecordsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragementRecordBinding.inflate(inflater)

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

       // mBinding.lifecycleOwner = this

        mBinding.model = viewModel
        mBinding.rvRecords.adapter = RecordsAdapter()

        viewModel.loadRecords()
        viewModel.records().observe(viewLifecycleOwner, Observer {
            it?.let { records ->
                (mBinding.rvRecords.adapter as RecordsAdapter).records(records)
            }
        })
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        @JvmStatic
        fun newInstance(sectionNumber: Int) = RecordsFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_SECTION_NUMBER, sectionNumber)
            }
        }
    }
}