package com.example.ShopingCart

fun main(){
    var ShoopingCartOnj = ShoopingCart()
    do {

        println(" 1.add item from cart  \n 2.view cart \n 3.remove item from cart \n 4.totalPrice \n 5.adding discount")
        var i = readln().toInt()
        when (i) {
            1 -> {do{ println("items in shop are : \n${ShoopingCartOnj.list1}")
                println("enter item name")
                var name = readln().lowercase()
                ShoopingCartOnj.addingToCart(name)
                println("do you want to add again press 1 or press 0")
                var a= readln().toInt()
            }
            while (a==1)}
            2 -> ShoopingCartOnj.viewingCart()
            3 -> {println("enter item name")
                var name = readln()
                ShoopingCartOnj.removingItems(name)
            }
            4 -> println("total price is  ${ShoopingCartOnj.totalPrice()}")
            5 -> {
                println("enter discoount percentage")
                var discount= readln().toInt()
                ShoopingCartOnj.discountPrice(discount)
            }
        }
        println("do you want to do changes in cart or to see price or to apply discount press 1 or press 0")
        var x = readln().toInt()
    }while (x==1)


}