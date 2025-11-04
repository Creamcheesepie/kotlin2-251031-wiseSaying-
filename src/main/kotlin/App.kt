package com.back

import com.back.controller.Controller

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class App(
    val controller: Controller = Controller(),
){
    fun run(){
        controller.run();
    }
}

fun main() {
    val controller: Controller = Controller();
    controller.run();
}
