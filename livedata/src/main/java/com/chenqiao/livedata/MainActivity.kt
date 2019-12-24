package com.chenqiao.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var model: NameViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the ViewModel.
        model = ViewModelProviders.of(this).get(NameViewModel::class.java)

        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            nameTextView.text = newName
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)
        model.nameListData.observe(this,  Observer<List<String>> { list -> list.forEach{ println(it) }})


        update.setOnClickListener{
            val anotherName = "John Doe /" + Math.random()
            model.currentName.value = anotherName

            model.nameListData.value = listOf("aaa", "bbb", "ccc", "ddd")

        }


    }
}
