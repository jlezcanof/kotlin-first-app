package com.codely.demo

import java.time.LocalDate
import java.time.Period
import kotlin.system.exitProcess

class Codelyber {
    fun greet() = "Welcome to kotlin skeleton!!!"
}

fun main() {
    println("Please enter a date with the format <yyyy-MM-dd>")
    supportNulableString(readLine()).takeUnless {
        it.isNullOrEmpty() || it.isNullOrBlank()
    }?.let {
        LocalDate.parse(it)
    }.apply {
        // para hacer mutaciones
        if (this == null) {
            println("The date is not valid")
            exitProcess(1)
        }
    }?.also {
        println("You wrote $it")
    }.run {
        with(Period.between(this, LocalDate.now())){
            println("The different between the date you wrote and today is ${this.years}")
        }
    }

}


fun supportNulableString(line: String?) = line
