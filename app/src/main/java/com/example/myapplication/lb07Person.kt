package com.example.myapplication

import java.io.Serializable

class lb07Person : Serializable {

    val name: String
    val address: String
    val mobile: String
    val gender: String


    constructor(name: String, address: String, mobile: String, gender: String) {
        this.name = name
        this.address = address
        this.mobile = mobile
        this.gender = gender
    }

    override fun toString(): String {
        return "$name $address $mobile $gender"
    }


}