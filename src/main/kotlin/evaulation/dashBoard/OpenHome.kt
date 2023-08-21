package evaulation.dashBoard

fun main(){
    println("for  login press --> 1\nfor register new user press --> 2")
    var responce= readln().toInt()
    when(responce){
        1-> loginCall()
        2-> registationCall()
    }
    println("\"LOGGING OUT BYE BYE\"")
}