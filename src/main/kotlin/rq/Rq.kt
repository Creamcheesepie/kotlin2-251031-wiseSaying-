package com.back.rq

class Rq(val cmd : String) {
    val action : String ;
    private var paraMap : Map<String, String>;

    init {
        val cmdBits = cmd.split("?")
        action = cmdBits[0];
        paraMap = if (cmdBits.size >= 2) {
            cmdBits[1].split("&").
            map {
                val pramBits = it.split("=");
                pramBits[0] to pramBits[1];
            }
            .toMap();
        } else {
            emptyMap();
        }
    }

    private fun getParamValue(Key: String): String? {
        return paraMap[Key];
    }

    fun getPramValueAsInt(Key: String,defaultValue : Int): Int{
        return getParamValue(Key)
            ?.toIntOrNull()
            ?: defaultValue
    }

}