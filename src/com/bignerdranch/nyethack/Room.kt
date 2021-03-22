package com.bignerdranch.nyethack

open class Room(val name: String) {
    open val dangerLevel = 5
    var monster: Monster? = Goblin()

    fun description() = "Room: $name"

    open fun load() = "Nothing much to see here..."
}

open class TownSquare : Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "GONG"

    final override fun load() = "The villagers rally and cheer as you enter!\n${ringBell()}"

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}

fun main() {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
        .map{ animal -> "A baby $animal" }
        .map{ baby -> "$baby, with the cutest little tail ever!"}
    println(babies)

    val it = listOf(listOf(1, 2, 3), listOf(4, 5, 6)).flatten()
    println(it)

    val itemsOfManyColors = listOf(listOf("red apple", "green apple", "blue apple"), listOf("red fish", "blue fish"), listOf("yellow banana", "teal banana"))

    val redItems = itemsOfManyColors.flatMap { it.filter { element -> element.contains("red") }}
    println(redItems)

    val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val primes = numbers.filter { num ->
        (2 until num).map { num % it }
            .none { it == 0 }
    }
    println(primes)

    val employees = listOf("Denny", "Claudette", "Peter")
    val shirtSize = listOf("large", "x-large", "medium")
    val employeeShirtSizes = employees.zip(shirtSize).toMap()
    println(employeeShirtSizes["Denny"])

    generateSequence(0) { it + 1 }
        .onEach { println("The Count says: $it, ah ah ah!") }
}
