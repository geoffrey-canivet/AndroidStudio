package com.example.listes

data class Person(val name: String, val phone : String) {
    override fun toString(): String {
        return "$name\n$phone"
    }
}
