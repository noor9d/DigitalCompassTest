package com.example.digitalcompass.ui.updatedestination


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.digitalcompass.R
import com.example.digitalcompass.data.models.GeoPosition
import com.example.digitalcompass.ui.compass.CompassViewModel
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_update_destination.*
import javax.inject.Inject
import kotlin.String


class UpdateDestinationFragment @Inject constructor() : DaggerFragment(), UpdateDestinationContract.View {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var viewModel: CompassViewModel? = null

    private var mSubscription = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // get ViewModel
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CompassViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_destination, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSave.setOnClickListener{
            val latText = editLat.text.toString()
            val longText = editLong.text.toString()
            if (latText.isEmpty() || longText.isEmpty()) showInputError()
            else {
                // Update destination in repository
                updateDestinationLocation(latText, longText)

                // Get back to the main screen
                goToUpdateDestinationPage()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        bindViewModel()
    }

    override fun onPause() {
        super.onPause()
        unbindViewModel()
    }

    override fun updateDestinationLocation(latText: String, longText: String) {
        viewModel?.setDestinationLocation(
            GeoPosition(
                latText.toDouble(),
                longText.toDouble())
        )
    }

    override fun goToUpdateDestinationPage() {
        activity?.finish()
    }

    override fun bindViewModel() {

    }

    override fun unbindViewModel() {

    }

    private fun showInputError() {
        Toast.makeText(activity, getString(R.string.error_on_input), Toast.LENGTH_LONG).show()
    }
}
