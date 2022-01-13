package de.sample.naci.composetutorial.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.sample.naci.composetutorial.R
import de.sample.naci.composetutorial.databinding.ActivityLifecycleExampleBinding

class LifecycleExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLifecycleExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.host_fragment, LifecycleExampleFirstFragment())
            //.add(R.id.host_fragment, LifecycleExampleFragment())
            .commit()
    }
}