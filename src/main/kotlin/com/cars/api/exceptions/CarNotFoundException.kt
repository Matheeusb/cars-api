package com.cars.api.exceptions

import java.lang.Exception

class CarNotFoundException(override val message: String) : Exception()