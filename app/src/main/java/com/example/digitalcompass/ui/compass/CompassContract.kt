package com.example.digitalcompass.ui.compass

import com.example.digitalcompass.ui.compass.models.DirectionsUiModel
import com.example.digitalcompass.ui.compass.models.LocationUiModel
import com.example.digitalcompass.BaseView

interface CompassContract {
    interface View : BaseView {
        fun updateDirections(directionsUiModel: DirectionsUiModel)

        fun updateCurrentLocation(locationUiModel: LocationUiModel)

        fun updateDestinationLocation(locationUiModel: LocationUiModel)

        fun goToUpdateDestinationPage()

        fun showOnErrorGettingDirections()

        fun showOnErrorGettingLocation()
    }

    interface ViewModel
}
