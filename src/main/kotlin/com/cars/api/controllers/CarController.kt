package com.cars.api.controllers

import com.cars.api.models.Car
import com.cars.api.models.CarDTO
import com.cars.api.services.CarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/cars")
class CarController {

    @Autowired
    lateinit var service: CarService

    @GetMapping
    fun list(): List<Car> = service.all()

    @GetMapping("/brand/{brand}")
    fun getCarsByBrand(@PathVariable brand: String): List<Car> = service.findByBrand(brand)

    @GetMapping("/model/{model}")
    fun getCarsByModel(@PathVariable model: String): List<Car> = service.findByModel(model)

    @GetMapping("/year/{year}")
    fun getCarsByYear(@PathVariable year: Int): List<Car> = service.findByYear(year)

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    fun createCar(@Valid @RequestBody carDTO: CarDTO) = service.createACar(carDTO)

    @PutMapping("/{id}")
    @Transactional
    fun updateCar(@PathVariable id: Long, @RequestBody carDTO: CarDTO): Car = service.updateACar(id, carDTO)

    @DeleteMapping("/{id}")
    @Transactional
    fun removeCar(@PathVariable id: Long): String = service.removeACar(id)
}