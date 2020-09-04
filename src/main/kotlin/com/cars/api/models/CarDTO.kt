package com.cars.api.models

import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CarDTO(
        @NotNull @Size(min = 1, max = 20)
        val brand: String,
        @NotNull @Size(min = 1, max = 20)
        val model: String,
        @NotNull @Min(4)
        val year: Int) {

    fun convertToCar() = Car(brand = brand, model = model, year = year)

}