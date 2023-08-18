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
    var password:String= readln()
    val regx: Regex =Regex("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
    if(userName.length<10 && name.length<10 && email.contains("@gmail.com") && phonenum>6000000000 && phonenum<9999999999 && regx.matches(password)){
    var userid=((Lists.usersList.sortedByDescending { it.userId }).get(0).userId)+1
    Lists.usersList.apply { Lists.usersList.add(User(userid,userName,name,email,phonenum,password)) }
    Lists.userInfo.apply { Lists.userInfo.add(UserInfo(userid,userName,name)) }
    return("registered successfully")
    }
    else{
        return Registation()
    }
}