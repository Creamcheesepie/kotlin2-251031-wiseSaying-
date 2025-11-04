package com.back.entity

data class WiseSaying(
    val id : Int = 0, val content : String, val author : String
){
    fun setId(id : Int ,wiseSaying: WiseSaying): WiseSaying {
        return WiseSaying(id, content, author);
    }

    fun print(){
        println("${this@WiseSaying.id} / $author / $content")
    }
}
