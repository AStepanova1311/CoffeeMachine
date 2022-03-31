enum class CoffeeMachine {
    BUY, FILL, TAKE, REMAINING, EXIT;

    companion object {
        fun takeAction(inputAction: String) {
            when (inputAction.uppercase()) {
                    BUY.name -> buy()
                    FILL.name -> fill()
                    TAKE.name -> take()
                    REMAINING.name -> remaining()
                    EXIT.name -> return
            }
        }
    }
}
//Assigning initial values to supplies
var water = 0
var milk = 0
var coffee = 0
var cups = 0
var money = 0

var remainingWater: Int = 400
var remainingMilk: Int = 540
var remainingCoffee: Int = 120
var remainingCups: Int = 9
var remainingMoney: Int = 550

//Print the menu unless the action to fulfill is EXIT
fun main() {
    do {
        print("Write action (buy, fill, take, remaining, exit): ")
        val action = readLine()!!
        CoffeeMachine.takeAction(action)
    } while (action != "exit")
   // println()
}
//Pick the drink to buy
fun buy() {
    println()
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    val typeOfCoffee = readln()

    when (typeOfCoffee) {
        "1" -> buyEspresso()
        "2" -> buyLatte()
        "3" -> buyCappuccino()
        "back" -> return
    }
}
//Print the message if supplies are enough to make coffee
fun printOutcome() {
    if (remainingWater >= water && remainingMilk >= milk && remainingCoffee >= coffee && remainingCups >= cups) {
        countRemainingBuy()
        println("I have enough resources, making you a coffee!")}

    else if (remainingWater < water)  println("Sorry, not enough water!")
    else if (remainingMilk < milk) println("Sorry, not enough milk!")
    else if (remainingCoffee < coffee) println("Sorry, not enough coffee!")
    else println("Sorry, not enough cups!")
}
//Assign values to supplies required to make espresso
fun buyEspresso() {
    water = 250
    milk = 0
    coffee = 16
    cups = 1
    money = 4
    printOutcome()

}
//Assign values to supplies required to make latte
fun buyLatte() {
    water = 350
    milk = 75
    coffee = 20
    cups = 1
    money = 7
    printOutcome()
}
//Assign values to supplies required to make cappuccino
fun buyCappuccino() {
    water = 200
    milk = 100
    coffee = 12
    cups = 1
    money = 6
    printOutcome()
}
//Fill the supplies
fun fill() {
    println()
    print("Write how many ml of water do you want to add: ")
    val waterFill = readln().toInt()
    print("Write how many ml of milk do you want to add: ")
    val milkFill = readln().toInt()
    print("Write how many grams of coffee beans do you want to add: ")
    val coffeeFill = readln().toInt()
    print("Write how many disposable cups of coffee do you want to add: ")
    val cupsFill = readln().toInt()

    remainingWater += waterFill
    remainingMilk += milkFill
    remainingCoffee += coffeeFill
    remainingCups += cupsFill
}
//Print the current amount of money available to take, then 0  is assigned to indicate there is mo money in the machine
fun take() {
    println()
    println("I gave you \$$remainingMoney")
    remainingMoney = 0
}

//Count the remaining supplies - if they are not enough - the remaining number do not change
fun countRemainingBuy() {

    remainingWater -= if (remainingWater < water) 0 else water
    remainingMilk -= if (remainingMilk < milk) 0 else milk
    remainingCoffee -= if (remainingCoffee < coffee) 0 else coffee
    remainingCups -= if (remainingCups < cups) 0 else cups
    remainingMoney += if (remainingWater < 0 || remainingMilk < 0 || remainingCoffee < 0 || remainingCups < 0) 0
    else money
}
//Print the remaining supplies
fun remaining() {
    println()
    println("The coffee machine has:\n" +
            "$remainingWater ml of water\n" +
            "$remainingMilk ml of milk\n" +
            "$remainingCoffee g of coffee beans\n" +
            "$remainingCups disposable cups\n" +
            "\$$remainingMoney of money")
}