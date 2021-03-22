package com.bignerdranch.nyethack

fun main() {
    val greetingFunction = { playerName: String, numBuildings: Int ->
        val currentYear = 2021
        println("Adding $numBuildings house${if (numBuildings > 1) "s" else ""}")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    val greetingFunction2: () -> String = {
        val currentYear = 2021
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }

    runSimulation()
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}

fun runSimulation() {
    val grtFunc = configureGreetingFunction()
    println(grtFunc("Guyal"))
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}
