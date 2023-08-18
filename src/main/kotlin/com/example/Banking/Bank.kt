package com.example.Banking

data class Custmor(var username: String,var name:String,var email:String,var accountnum:Int,var savingsBal:Int,var fixedBal:Int,var currentBal:Int)
data class LoginDetails(var username:String,var password:String)
var output:String ="incorrect credentials given "
var CustmorsListObj= CustmorsList()
fun CallingMethods(accnum:Int){
    println("enter type of account 1.savings 2.current 3.fixed")
    var type= readln().toInt()
    println("1.withdraw or 2.deposit")
    var i = readln().toInt()
    println("enter amount")
    var amunt= readln().toInt()

 when(type){
     1->when(i){
         1-> BankingAccount.SavingAccount().withdrawAmount(accnum,amunt, CustmorsListObj.list1)
         2-> BankingAccount.SavingAccount().depositAmount(accnum,amunt, CustmorsListObj.list1)
     }
     2->when(i){
         1-> BankingAccount.CurrentAccount().withdrawAmount(accnum,amunt, CustmorsListObj.list1)
         2-> BankingAccount.CurrentAccount().depositAmount(accnum,amunt, CustmorsListObj.list1)
     }
     3->when(i){
         1-> BankingAccount.FixedAccount().withdrawAmount(accnum,amunt, CustmorsListObj.list1)
         2-> BankingAccount.FixedAccount().depositAmount(accnum,amunt, CustmorsListObj.list1)
 }
 }
}
fun main(){
var loginObj=Login()
    var responce=loginObj.loging()
    println(responce)
    if(responce.equals(output)){
        loginObj.loging()
    }
    else{
        do{
            CallingMethods(responce.toInt())
            println("do you want to deposit or withdraaw again press 1")
            var i= readln().toInt()
        }
        while (i==1)
    }

}
