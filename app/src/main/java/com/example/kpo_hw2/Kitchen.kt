package com.example.kpo_hw2

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class Kitchen {

    fun startPreparing(order: Order) {
        CoroutineScope(Dispatchers.Default).launch {
            // Имитация процесса приготовления заказа
            for (item in order.items) {
                withContext(Dispatchers.Main) {
                    order.status = OrderStatus.PREPARING
                }
                TimeUnit.SECONDS.sleep(item.preparationTime.toLong())
            }
            // По завершении приготовления заказа меняем его состояние
            withContext(Dispatchers.Main) {
                order.status = OrderStatus.READY
            }
        }


    }

}