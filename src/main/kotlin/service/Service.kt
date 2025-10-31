package com.back.service

import com.back.entity.WiseSaying

class Service {
    var wiseSayings : MutableList<WiseSaying> = mutableListOf();
    var id : Int = 1;
    
    fun saveWiseSaying(){
        print("명언: ")
        val content : String = readln();
        print("작가: ")
        val author : String = readln();
        wiseSayings.add(WiseSaying(id++, content, author));
    }

    fun wiseSayingList(){
        println("번호    /    작가  /   명언")
        for(wiseSaying in wiseSayings){
            wiseSaying.print();
        }
    }

    fun deleteWiseSaying(id : Int){
        var wiseSaying = wiseSayings.firstOrNull{
            it.id == id
        }

        if(wiseSaying == null){
            println("${id}번 명언은 존재하지 않습니다.");
            return;
        }

        wiseSayings.remove(wiseSaying)
        println("${id}번 명언이 삭제되었습니다.");
    }

    fun updateWiseSaying(id : Int){
        for(wiseSaying in wiseSayings){
            if(wiseSaying.id == id){
                val i : Int = wiseSayings.indexOf(wiseSaying);
                println("명언(기존): ${wiseSaying.content}")
                print("명언: ")
                val content : String = readln();
                println("작가(기존): ${wiseSaying.author}")
                print("작가: ")
                val author : String = readln();
                val updateWiseSaying : WiseSaying = WiseSaying(id, content, author);
                wiseSayings.set(i,updateWiseSaying);
                return;
            }
        }

        println("${id}번 명언은 존재하지 않습니다.");
    }
}