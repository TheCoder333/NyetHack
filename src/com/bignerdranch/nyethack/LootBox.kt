package com.bignerdranch.nyethack

class LootBox<T : Loot>(vararg item: T) {
    var open = false
    private var loot: Array<out T> = item

    operator fun get(index: Int): T? = loot[index].takeIf { open }

    fun fetch(item: Int): T? {
        return loot[item].takeIf { open }
    }

    fun <R> fetch(item: Int, lootModFunction: (T) -> R): R? {
        return lootModFunction(loot[item]).takeIf { open }
    }
}

open class Loot(val value: Int)

class Fedora(val name: String, value: Int) : Loot(value)

class Coin(value: Int) : Loot(value)

class Barrel<out T>(val item: T)

fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

    lootBarrel = fedoraBarrel
    val myFedora: Fedora = lootBarrel.item

    val str = "Hi".addEnthusiasm().easyPrint<String>()

    str.numVowels

    null printWithDefault "hi"
}

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount).also { return this }

fun <T> T.easyPrint(): T {
    println(this)
    return this
}

val String.numVowels
    get() = 10

infix fun String?.printWithDefault(default: String) = print(this ?: default)
