package com.example.Imbd

data class Movies(var name:String,var title:String,var year:Int,var rating:Float,var language:String)
class Imdb {

    var list1: MutableList<Movies> = mutableListOf<Movies>(
        Movies("saitan", "kill kiler", 2023, 3.5f, "Telugu"),
        Movies("pushpa", "taggada le", 2022, 4.0f, "panIndia"),
        Movies("varasadu", "family", 2023, 3.0f, "tamil"),
        Movies("dhamaka", "mass maharaj", 2021, 2.5f, "malayalam")
    )
    fun searchByName(name: String,list:List<Movies>){
        val movie: List<Movies> =list.filter { it.name.equals(name, true) }
        println(movie)
    }
    fun getByRating(rating: Float,list: List<Movies>){
        val list2:List<Movies> =list.filter { it.rating>rating }
        println(list2)
    }
    fun getByPrefix(name: String,list: List<Movies>){
        val list2:List<Movies> = list.filter { it.name.startsWith(name) }
        println(list2)
    }
    fun getByYear(year: Int,list: List<Movies>){
        val list2 = mutableListOf<Movies>()
//        list2= list.filter { it.year.equals(year) }
        list.map { if(it.year.equals(year)){ list2.add(it)} }
//        list.forEach { if(it.year.equals(year)){ list2.add(it)}}
        println(list2)
    }
    fun getByLanguage(language: String,list: List<Movies>){
        val list2:List<Movies> =list.filter { it.language.equals(language) }
        println(list2)
    }
    fun getByTitle(title: String,list: List<Movies>){
        val Movies =list.filter { it.title.equals(title) }
        println(Movies)
    }
}
fun mains() {
    var indbobj= Imdb()
    println("what do u want to search with \n 1.name \n 2.rating \n 3.pefix \n 4.year \n 5.language \n 6.title")
    var input :Int= readln().toInt()
    when(input){
        1-> {println("enter name")
            var name=readln()
            indbobj.searchByName(name,indbobj.list1)}
        2 ->{println("enter rating")
            var rating:Float= readln().toFloat()
            indbobj.getByRating(rating,indbobj.list1) }
        3->{ println("enter starting letter")
            var starting:String= readln()
            indbobj.getByPrefix(starting,indbobj.list1) }
        4->{
            println("enter year")
            var year:Int= readln().toInt()
            indbobj.getByYear(year,indbobj.list1)}
        5->{println("enter language")
            var language:String= readln()
            indbobj.getByLanguage(language,indbobj.list1)}
        6->{
            println("enter title")
            var title:String= readln()
            indbobj.getByTitle(title,indbobj.list1)
        }
    }

}
fun main(){
    var i:Int
    do {
        mains()
        println("do you want to search again press :1 or 0")
        i= readln().toInt()
    }
    while (i==1)
}