package com.example.myapplication

import java.io.Serializable

class Person : Serializable {

    var name: String;
    var add: String;
    var phone: String;
    var gen: String;

    constructor(name: String, add: String, phone: String, gen: String) {
        this.name = name
        this.add = add
        this.phone = phone
        this.gen = gen
    }

    override fun toString(): String {
        return "$name $add $phone $gen";
    }

}
