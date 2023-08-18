//data class Items(var name:String,var price:Int)
//var list1= mutableListOf<Items>(Items("laptop", 50000), Items("phone", 25000))
//fun main(){
//    var amnt=0
//   var  lis2=list1.let { list1.map {amnt+=it.price  } }
//    println(amnt)
//   var result= amnt.let { amnt-((25f/100f)*amnt) }
//    println("..>  $result")
//
//}
//fun doing() {
//    var a = readln().toInt()
//    if (a == 1) {
//        var b = a + 1
//        println(b)
//    }
//    else{
//        println(a)
//    }
//}
//fun main(){
//    var S1:Int=1
//    val s2="1"
//    var result=if(S1.equals(s2
//    )) "same"
//    else
//        "not same"
//    var result1=if(S1==(s2
//        )) "same"
//    else
//        "not same"
//    println(result)
//    println("$result1 <--")
//}
fun main(){
    var num=4
    var str=
        when(num){
            1 -> 1
            2 -> 2
            3 -> 'n'
            4 -> 2.554
            else -> "nothing"
        }
    println(str)
}