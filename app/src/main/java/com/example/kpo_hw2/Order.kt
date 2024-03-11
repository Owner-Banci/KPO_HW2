package com.example.kpo_hw2

import java.io.Serializable


import java.util.concurrent.CopyOnWriteArrayList


enum class OrderStatus {
    ACCEPTED,
    PREPARING,
    READY,
    CANCELED,
    PAID
}


class Order() : Serializable {

    var status: OrderStatus = OrderStatus.ACCEPTED
    val items: MutableList<MenuItem> = CopyOnWriteArrayList()
    private var totalPrice: Double = 0.0

    fun addItem(item: MenuItem) {
        items.add(item)
    }

    fun totalPrice(): String {
        for (item in items) {
            totalPrice += item.price
        }
        return totalPrice.toString()
    }

    fun totalTime(list: List<MenuItem>): String {
        var totalTime: Int = 0
        for (item in list) {
            totalTime += item.preparationTime
        }
        return totalTime.toString()
    }


    operator fun get(position: Int): Any {
        return items[position]

    }

    fun mostCommonItemName(): String? {
        return items.groupBy { it.name }
            .maxByOrNull { it.value.size }
            ?.key
    }

}
