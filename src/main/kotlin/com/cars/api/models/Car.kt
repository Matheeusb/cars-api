package com.cars.api.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Car(@Id
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          val id: Long? = null,
          val brand: String,
          val model: String,
          val year: Int)