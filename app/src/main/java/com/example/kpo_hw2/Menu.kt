package com.example.kpo_hw2

data class MenuItem(
    val name: String,
    val preparationTime: Int,
    var count: Int,
    val price: Double,
) {
    fun deminishCount(): Int { //Увеличиваем количество блюд
        val newCount = count - 1
        count = newCount
        return newCount
    }


    fun decriseCount(): Int { //Уменьшаем количество блюд
        val newCount = count + 1
        count = newCount
        return newCount
    }
}

open class Menu() {
    val items: MutableList<MenuItem> = mutableListOf()

    fun addItem(item: MenuItem) {
        items.add(item)
    }

    fun removeItem(item: Int) {
        items.removeAt(item)
    }


//    fun getName(item: MenuItem): String{
//        return item.name
//    }

    operator fun get(position: Int): MenuItem {
        return items[position]
    }

}


