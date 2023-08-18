package Evaulation.DashBoard.Data

fun main(){
    println("for  login press --> 1\nfor register new user press --> 2")
    var responce= readln().toInt()
    when(responce){
        1-> loginnCall()
        2-> registationCall()
    }
    println("\"LOOGING OUT BYE BYE\"")
}