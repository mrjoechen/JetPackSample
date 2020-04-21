package com.chenqiao.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Created by chenqiao on 2020/4/21.
 * e-mail : mrjctech@gmail.com
 */
class SeekBarFragment : Fragment(){

    lateinit var mSeekBar: SeekBar
    lateinit var mSeekBarViewModel: SeekBarViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_share_data, container, false)
        mSeekBar = root.findViewById(R.id.seekBar)

        mSeekBarViewModel = activity?.run {
            ViewModelProviders.of(this).get(SeekBarViewModel::class.java)

        }?: throw Exception("Invalid Activity")

        mSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mSeekBarViewModel.seekBarValue.postValue(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        mSeekBarViewModel.seekBarValue.observe(this, Observer {
            mSeekBar.progress = it
        })

        return root
    }


}