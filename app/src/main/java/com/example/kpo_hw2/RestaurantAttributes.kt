package com.example.kpo_hw2

class RestaurantAttributes {
    private var totalRevenue: Double = 0.0
    private val ratingsMap = mutableMapOf<String, MutableList<Int>>()

    fun addRevenue(price: Double) {
        totalRevenue += price
    }

    // Добавление оценки для блюда
    fun addRating(dishName: String, rating: Int) {
        if (ratingsMap.containsKey(dishName)) {
            ratingsMap[dishName]?.add(rating)
        } else {
            ratingsMap[dishName] = mutableListOf(rating)
        }
    }

//    fun getTotalRevenue(): String {
//        return totalRevenue.toString()
//    }

    // Получение всех оценок блюда
    fun getAllRatings(dishName: String): List<Int>? {
        return ratingsMap[dishName]
    }

    // Вычисление средней оценки всех блюд
    fun averageRating(): Double {
        var totalRating = 0
        var totalCount = 0

        for ((_, ratings) in ratingsMap) {
            for (rating in ratings) {
                totalRating += rating
                totalCount++
            }
        }

        return if (totalCount > 0) {
            totalRating.toDouble() / totalCount
        } else {
            0.0
        }
    }


    // Нахождение блюда с самой низкой средней оценкой
    fun findDishWithMinAverageRating(): String? {
        var minDish: String? = null
        var minRating = Double.MAX_VALUE

        for ((dish, ratings) in ratingsMap) {
            val averageRating = ratings.average()
            if (averageRating < minRating) {
                minRating = averageRating
                minDish = dish
            }
        }

        return minDish
    }

    // Нахождение блюда с самой высокой средней оценкой
    fun findDishWithMaxAverageRating(): String? {
        var maxDish: String? = null
        var maxRating = Double.MIN_VALUE

        for ((dish, ratings) in ratingsMap) {
            val averageRating = ratings.average()
            if (averageRating > maxRating) {
                maxRating = averageRating
                maxDish = dish
            }
        }

        return maxDish
    }
}