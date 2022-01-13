package de.sample.naci.composetutorial.lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.sample.naci.composetutorial.R
import de.sample.naci.composetutorial.databinding.FragmentFirstLifecycleExampleBinding
import timber.log.Timber

class LifecycleExampleFirstFragment : Fragment() {
    private var binding: FragmentFirstLifecycleExampleBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        FragmentFirstLifecycleExampleBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d("View created")

        binding?.goTo?.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .add(R.id.host_fragment, LifecycleExampleFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}