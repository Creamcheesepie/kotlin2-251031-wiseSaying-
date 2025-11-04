package com.back.controller

import com.back.System.controller.SystemController
import com.back.rq.Rq
import com.back.service.Service

class Controller {

    fun run(){
        val controller = Service();
        println("== 명언 앱 ==")

        while(true) {
            print("명령) ")
            val input = readln();
            val rq : Rq = Rq(input);

            when (rq.action) {
                "등록" -> controller.saveWiseSaying();
                "목록" -> controller.wiseSayingList();
                "삭제" -> controller.deleteWiseSaying(rq.getPramValueAsInt("id",0));
                "수정" -> controller.updateWiseSaying(rq.getPramValueAsInt("id",0));
                "종료" -> break;
                "종료" -> SystemController().exit();
            }
        }
    }

}