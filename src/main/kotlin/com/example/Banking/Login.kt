package com.example.Banking

class Login {
    var CustmorsListObj= CustmorsList()
    fun loging() :String{
        println("enter username :")
        var username = readln()
        println("enter password :")
        var password = readln()
        var loginList: MutableList<LoginDetails> = mutableListOf(LoginDetails("govindasai1", "password"),LoginDetails("sai1","passsword"))
        var list: List<LoginDetails> =loginList.filter { it.username.equals(username) && it.password.equals(password) }
        if(list.isNotEmpty()){

            var list1: List<Custmor> =CustmorsListObj.list1.filter { it.username.equals(username) }
            if(list1.isNotEmpty()){
                var accountnumber=list1.get(0).accountnum.toString()
                return "$accountnumber"
            }
            else{
                return "id not found"
            }
        }
        else{
            return "incorrect credentials given "
        }
    }
}