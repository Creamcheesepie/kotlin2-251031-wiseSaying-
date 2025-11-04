package com.back.service

import com.back.entity.WiseSaying
import com.back.repository.WiseSayingRepository

class Service {
   val wiseSayingRepository: WiseSayingRepository = WiseSayingRepository();

    fun saveWiseSaying(){
        print("명언: ")
        val content : String = readln();
        print("작가: ")
        val author : String = readln();
        wiseSayingRepository.save(WiseSaying(0,content,author));
    }

    fun wiseSayingList(){
        println("번호    /    작가  /   명언")
        for(wiseSaying in wiseSayingRepository.getAllWiseSayings()){
            wiseSaying.print();
        }
    }

    fun deleteWiseSaying(id : Int){
        val wiseSaying = wiseSayingRepository.findById(id)

        if(wiseSaying == null){
            println("${id}번 명언은 존재하지 않습니다.");
            return;
        }

        wiseSayingRepository.delete(wiseSaying)
        println("${id}번 명언이 삭제되었습니다.");
    }

    fun updateWiseSaying(id : Int){
        var wiseSaying: WiseSaying? = wiseSayingRepository.findById(id)

        if(wiseSaying == null){
            println("${id}번 명언은 존재하지 않습니다.");
            return;
        }

        println("명언(기존): ${wiseSaying.content}")
        print("명언: ")
        val content : String = readln();
        println("작가(기존): ${wiseSaying.author}")
        print("작가: ")
        val author : String = readln();

        val updateWiseSaying : WiseSaying = WiseSaying(id, content, author);
        wiseSayingRepository.update(wiseSaying, updateWiseSaying);
        println("${id}번 명언이 수정되었습니다.");
    }

}