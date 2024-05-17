package com.darleyleal.coffewithcode.viewmodel

class CoffeeViewModel {

    fun calcularValorMocca(quantidade: Int): String {
        val resultado = quantidade * 15
        return "R$ $resultado"
    }

    fun calcularValorLatte(quantidade: Int): String {
        val resultado = quantidade * 10
        return "R$ $resultado"
    }

    fun calcularValorIced(quantidade: Int): String {
        val resultado = quantidade * 12
        return "R$ $resultado"
    }

    fun calcularValorCoado(quantidade: Int): String {
        val resultado = quantidade * 5
        return "R$ $resultado"
    }

    fun calcularValorTotal(
        quantidadeMocca: Int, quantidadeLatte: Int, quantidadeIced: Int, quantidadeCoado: Int
    ): Int {
        return (quantidadeMocca * 15) + (quantidadeIced * 12) + (quantidadeLatte * 10) + (quantidadeCoado * 5)
    }
}