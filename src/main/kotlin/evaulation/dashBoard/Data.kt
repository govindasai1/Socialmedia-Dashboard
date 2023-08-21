package evaulation.dashBoard

data class User(var userId:Int, var userName:String,var name:String, var email:String, var phoneNumber: Long, var password:String)
data class Post(var userId:Int,var postId:Int,var author:String,var content:String,var timestamp:String,var likes:Int,var status:String,var comments:MutableList<String>?=null)
data class UserInfo(var userId:Int,var userName:String,var name:String)