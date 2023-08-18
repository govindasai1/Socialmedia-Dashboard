package Evaulation.DashBoard.Data

fun Registation():String{
    println("enter username to set :")
    var userName = readln()
    println("enter name :")
    var name = readln()
    println("enter email :")
    var email= readln()
    println("enter phonenumber")
    var phonenum:Long= readln().toLong()
    println("enter password to set :")
    var password= readln()
    var userid=((Lists.usersList.sortedByDescending { it.userId }).get(0).userId)+1
    Lists.usersList.apply { Lists.usersList.add(User(userid,userName,name,email,phonenum,password)) }
    Lists.userInfo.apply { Lists.userInfo.add(UserInfo(userid,userName,name)) }
    return ("regestered sucesfully")
}