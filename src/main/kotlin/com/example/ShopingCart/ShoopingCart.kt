package com.example.ShopingCart

class ShoopingCart {
    var list1= mutableListOf<Items>(
        Items("laptop",50000),
        Items("phone",25000),
        Items("tv",45000),
        Items("shirt",2000)
    )
    var list2: MutableList<Items> = mutableListOf<Items>()
    fun addingToCart(name:String){

        var list  = list1.filter { it.name.equals(name) }
        var listt = list2.addAll(list)
        if (listt){
            println("added to cart")
        }
        else{
            println("item not found")
        }
    }
    fun viewingCart(){
        println(list2)
    }
    fun removingItems(name: String){
        var list3: List<Items> =list2.filter { it.name.equals(name) }
        var list = list2.remove(list3[0])
        if(list){
            println("item removed")
        }
        else{
            println("item not present in cart")
        }
    }
    fun totalPrice():Int{
        var totalprice = 0
        var amount=list2.map { totalprice+=it.price }
        return totalprice
    }
    fun discountPrice(discountPercent:Int){
        if(discountPercent>90) println("discount not applicable to products")
        else {
            var price = totalPrice()
            var resultAmount = price.let { price - ((discountPercent / 100f) * price) }
            println("total price after applying $discountPercent% discount is $resultAmount")
        }
    }
}
