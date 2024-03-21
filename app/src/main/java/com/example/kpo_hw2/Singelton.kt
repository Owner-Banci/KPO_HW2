package com.example.kpo_hw2

object OrderManager {
    private val lock = Any()
    @Volatile
    private var instance: Order? = null

    fun getInstance(): Order {
        if (instance == null) {
            synchronized(lock) {
                if (instance == null) {
                    instance = Order()
                }
            }
        }
        return instance!!
    }
}

object MenuManager {
    private val lock = Any()
    @Volatile
    private var instance: Menu? = null

    fun getInstance(): Menu {
        if (instance == null) {
            synchronized(lock) {
                if (instance == null) {
                    instance = Menu()
                }
            }
        }
        return instance!!
    }
}

object RestourantManager {
    private val lock = Any()
    @Volatile
    private var instance: RestaurantAttributes? = null

    fun getInstance(): RestaurantAttributes {
        if (instance == null) {
            synchronized(lock) {
                if (instance == null) {
                    instance = RestaurantAttributes()
                }
            }
        }
        return instance!!
    }
}
