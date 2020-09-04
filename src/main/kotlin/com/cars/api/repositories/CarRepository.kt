package com.cars.api.repositories

import com.cars.api.models.Car
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository : JpaRepository<Car, Long> {

    fun findByBrandIgnoreCase(brand: String): List<Car>
    fun findByModelIgnoreCase(model: String): List<Car>
    fun findByYear(year: Int): List<Car>

}