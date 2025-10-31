package com.back
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
var wiseSayings : MutableList<WiseSaying> = mutableListOf();
var id : Int = 1;

class WiseSaying(val number : Int,val content : String,val author : String ){
    fun print(){
        println("$number / $author / $content")
    }
}


fun main() {
    println("== 명언 앱 ==")

    while(true) {
        print("명령) ")
        val input = readln();

        when (input) {
            "등록" -> saveWiseSaying();
            "목록" -> wiseSayingList();
            "종료" -> break;
        }
    }

}

fun saveWiseSaying(){
    print("명언: ")
    val content : String = readln();
    print("작가: ")
    val author : String = readln();
    wiseSayings.add(WiseSaying(id++, content ,author));
}

fun wiseSayingList(){
    println("번호    /    작가  /   명언")
    for(wiseSaying in wiseSayings){
        wiseSaying.print();
    }
}

fun deleteWiseSaying(id : Int){
    for(wiseSaying in wiseSayings){
        if(wiseSaying.number == id){
            wiseSayings.remove(wiseSaying);
            return;
        }
    }

    println("${id}번 명언은 존재하지 않습니다.");
}