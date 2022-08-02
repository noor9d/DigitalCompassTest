package com.example.digitalcompass.ui.updatedestination

import com.example.digitalcompass.BaseView

interface UpdateDestinationContract {
    interface View : BaseView {
        fun updateDestinationLocation(latText: String, longText: String)

        fun goToUpdateDestinationPage()

    }
}