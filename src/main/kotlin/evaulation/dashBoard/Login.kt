package evaulation.dashBoard

fun login(): String {
    println("give user name:")
    var username= readln()
    println("give password :")
    var password= readln()
       var list = Lists.usersList.filter { it.userName==username && it.password==password}
        if(list.isNotEmpty()){
           var list1= Lists.usersList.filter { it.userName==username }
            if(list1.isNotEmpty()) {
                return list1[0].userName
            }
            else return ("user not found")
        }else return("incorrect credentials given")
}