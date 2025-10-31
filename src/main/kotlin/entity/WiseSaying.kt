package com.back.entity

data class WiseSaying(
    val id : Int, val content : String, val author : String
){
    fun print(){
        println("${this@WiseSaying.id} / $author / $content")
    }
}
