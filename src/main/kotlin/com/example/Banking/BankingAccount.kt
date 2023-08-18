package com.example.Banking

sealed class BankingAccount{
    class SavingAccount{
        fun depositAmount(accountnum: Int,amount:Int,list: List<Custmor>){
            var list2: List<Custmor> = list.filter { it.accountnum==accountnum }
            if(list2.isNotEmpty()){
                list2.map { it.savingsBal+=amount }
                println(list2)
            }
        }
        fun withdrawAmount(accountnum: Int,amount:Int,list: List<Custmor>){
            var list2: List<Custmor> = list.filter { it.accountnum==accountnum && it.savingsBal>=amount }
//            println(list2)
            if(list2.isNotEmpty()){
                list2.map { it.savingsBal-=amount }
                println(list2)
            }
            else{
                println("amount not suficient")
            }
        }
    }
    class FixedAccount{
        fun depositAmount(accountnum: Int,amount:Int,list: List<Custmor>){
            var list2: List<Custmor> = list.filter { it.accountnum==accountnum }
            if(list2.isNotEmpty()){
                list2.map { it.fixedBal+=amount }
                println(list2)
            }
        }
        fun withdrawAmount(accountnum: Int,amount:Int,list: List<Custmor>){
            var list2: List<Custmor> = list.filter { it.accountnum==accountnum && it.fixedBal>=amount }
            if(list2.isNotEmpty()){
                list2.map { it.fixedBal-=amount }
                println(list2)
            }
            else{
                println("amount not sufficient")
            }
        }
    }
    class CurrentAccount{
        fun depositAmount(accountnum: Int,amount:Int,list: List<Custmor>){
            var list2: List<Custmor> = list.filter { it.accountnum==accountnum }
            if(list2.isNotEmpty()){
                list2.map { it.currentBal+=amount }
                println(list2)
            }
        }
        fun withdrawAmount(accountnum: Int,amount:Int,list: List<Custmor>){
            var list2: List<Custmor> = list.filter { it.accountnum==accountnum && it.currentBal>=amount }
            if(list2.isNotEmpty()){
                list2.map { it.currentBal-=amount }
                println(list2)
            }
            else{
                println("amount not sufficient")
            }
        }
    }
}