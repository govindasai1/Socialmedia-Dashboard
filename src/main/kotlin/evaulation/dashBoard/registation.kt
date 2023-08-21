package evaulation.dashBoard

fun registation():String{
    println("enter username to set :")
    var userName = readln()
    println("enter name :")
    var name = readln()
    println("enter email :")
    var email= readln()
    println("enter phonenumber")
    var phonenumber:Long= readln().toLong()
    println("enter password to set :")
    var password:String= readln()
    if(Validation.userNameValidation(userName) && Validation.nameValidation(name) && Validation.emailValidation(email) && Validation.phonenumberValidation(phonenumber) && Validation.passwordValidation(password)){
    var userid=((Lists.usersList.sortedByDescending { it.userId })[0].userId)+1
    Lists.usersList.apply { Lists.usersList.add(User(userid,userName,name,email,phonenumber,password)) }
    Lists.userInfo.apply { Lists.userInfo.add(UserInfo(userid,userName,name)) }
    return("registered successfully")
    }
    else{
        return registation()
    }
}