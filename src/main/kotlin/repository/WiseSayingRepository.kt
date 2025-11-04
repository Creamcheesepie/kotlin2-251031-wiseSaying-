package com.back.repository

import com.back.entity.WiseSaying

class WiseSayingRepository {
    var wiseSayings : MutableList<WiseSaying> = mutableListOf();
    var id : Int = 1;

    fun save(wiseSaying: WiseSaying):WiseSaying {
        return wiseSaying.also{
            wiseSayings.add(wiseSaying.setId(id++,wiseSaying))};
    }

    fun getAllWiseSayings(): MutableList<WiseSaying> {
        return wiseSayings.toMutableList();
    }

    fun delete(wiseSaying: WiseSaying) {
        wiseSayings.remove(wiseSaying)
    }

    fun update(wiseSaying: WiseSaying, newWiseSaying: WiseSaying) {
        wiseSayings.set(wiseSayings.indexOf(wiseSaying),newWiseSaying);
    }

    fun findById(id: Int): WiseSaying? = wiseSayings.firstOrNull{it.id == id}
}