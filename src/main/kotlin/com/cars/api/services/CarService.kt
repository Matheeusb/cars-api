package com.cars.api.services

import com.cars.api.exceptions.CarNotFoundException
import com.cars.api.models.Car
import com.cars.api.models.CarDTO
import com.cars.api.repositories.CarRepository
import org.springframework.stereotype.Service

@Service
class CarService(val repository: CarRepository) {

    fun all(): List<Car> = repository.findAll()

    fun findByBrand(brand: String): List<Car> {
        val listCars: List<Car> = repository.findByBrandIgnoreCase(brand)
        if (listCars.isEmpty()) {
            throw CarNotFoundException("Brand with name $brand not found!")
        }
        return listCars
    }

    fun findByModel(model: String): List<Car> {
        val listCars = repository.findByModelIgnoreCase(model)
        if (listCars.isEmpty()) {
            throw CarNotFoundException("Model with name $model not found!")
        }
        return listCars
    }

    fun findByYear(year: Int): List<Car> {
        val listCars = repository.findByYear(year)
        if (listCars.isEmpty()) {
            throw CarNotFoundException("Car with year $year not found!")
        }
        return listCars
    }

    fun createACar(carDTO: CarDTO): Car = repository.save(carDTO.convertToCar())
 
    fun updateACar(id: Long, carDTO: CarDTO): Car {
        if (!repository.findById(id).isEmpty) {
            val car = Car(repository.getOne(id).id,
                    carDTO.brand,
                    carDTO.model,
                    carDTO.year)
            return repository.save(car)
        } else {
            throw CarNotFoundException("Car with id $id not found!")
        }
    }

    fun removeACar(id: Long): String {
        val car = repository.findById(id)
        if (!car.isEmpty) {
            repository.deleteById(id)
            return "Car successfully removed! $car"
        } else {
            throw CarNotFoundException("Car with id $id not found!")
        }
    }
}