package com.example.FileOperatios

import java.io.File
import java.io.FileWriter

fun main(){
var write= "https://app.gemoo.com/share/image-annotation/547120092782514176?codeId=Pa6eeBy6bQobg&origin=imageurlgenerator"
    var file= File("image.txt")
    var directory=File("hello")
    var fls = downloadImages(write)
    directory.mkdir()


//        file.createNewFile()
//    println(fls.toString())
//    file.writer().write()
//    println( file.readText())
//    file.reader().forEachLine { println(it) }
//    var x=write.split(".")
//    println(".${x[1]}")
//    operations(write)
//    var directory=File(write)
//    var file=File(write)
//    println(file.exists())
//    println(file.canRead())
//    println(file.canWrite())
//    println(directory.mkdirs())
//    var cretd=file.createNewFile()
//    println(cretd)
//    println(file.path)
//    val filePath = Paths.get("Ab.txt")
//    val attributes: BasicFileAttributes = Files.readAttributes(filePath, BasicFileAttributes::class.java)
//    val creationTime = attributes.creationTime()
//    println(filePath)
}
fun downloadImages(write: String) {

}
fun operations(input:String){
    var fil=FileWriter("Ab.txt")
//    var fileWriter=fil.writer()
    fil.write(input)
//    println(fil.)
    fil.close()
}