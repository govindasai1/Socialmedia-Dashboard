package Evaulation.DashBoard.Data

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Methodss {
    fun followUsers(userName: String,usersList: MutableList<UserInfo> = Lists.userInfo, postlst: MutableList<Post> = Lists.postList) {
        var list1:MutableList<UserInfo> = mutableListOf()
        list1.addAll(Lists.userInfo)
        list1.removeIf { it.userName==userName}
        list1.removeAll(Lists.FollowingUsers)
        println(list1)
        println("enter user name to follow")
        var userName: String= readln()
        var list = usersList.filter { it.userName == userName }
        if (list.isNotEmpty()) {
            Lists.FollowingUsers.addAll(list)
            var userId = list.let { it.get(0).userId }
            var list2 = postlst.filter { it.userId == userId }
            Lists.viwingPost.addAll(list2)
            println("$userName followed")
        } else println("user not found")
    }

    fun unfollowUsers(usersList: MutableList<UserInfo> = Lists.userInfo) {
        println(Lists.FollowingUsers)
        println("enter username to unfollow :")
        var userName= readln()
        var list = usersList.filter { it.userName == userName }
        if (list.isNotEmpty()) {
            Lists.FollowingUsers.removeAll(list)
            var userId = list.get(0).userId
            var list2 = Lists.viwingPost.map { it.userId == userId }
            if (list2.get(0)) {
                Lists.viwingPost.removeIf { it.userId == userId }
                println("$userName unfollowed")
            } else println("$userName notfollowed")
        } else println("useer not found")
    }

    fun creatingPost(userName: String, postlst: MutableList<Post> = Lists.postList) {
        var userId: Int = (Lists.usersList.filter { it.userName == userName }).get(0).userId
        var authorName = (Lists.usersList.filter { it.userName == userName }).get(0).name
        var numberOfPosts = ((postlst.sortedByDescending { it.postId }).get(0).postId)+1//(postlst.filter { it.userId == userId }).size
        if (userId != 0) {
            println("enter some content :")
            var content: String = readln()
            var time = time()
            postlst.add(Post(userId, (numberOfPosts), authorName, content, time, 0,"notliked", mutableListOf()))
            println("post added for user $userName")
        } else println("useer not found")
    }

    fun basedOnLikes(likes: Int) {
        var list = Lists.viwingPost.filter { it.likes > likes }
        println("these are the posts that are grater than  $likes\n$list");
    }

    fun sortOnLikes() {
        var list = Lists.viwingPost.sortedBy { it.likes }
        println(list)
    }

    fun sortOnTime() {
        var list = Lists.viwingPost.sortedBy {it.timestamp}
        println(list)
    }

    fun ownPosts(userName: String) {
        var userId = (Lists.usersList.filter { it.userName == userName }).get(0).userId
        var list = Lists.postList.filter { it.userId==userId }
        println(list)
    }
    fun followedUsers(){
        println(Lists.viwingPost)
    }
    fun likeOrUnlikeOrComment(userName: String)= runBlocking{
        followedUsers()
        println("enter post id")
        var postId:Int= readln().toInt()
        println("enter comment to add")
        var comment:String? = readln()
        var output=Lists.postList.find { it.postId==postId }
        try{
        output?.let {
            var like = async {
               if (it.status == "notliked") {
                   it.likes = ++(it.likes)
                   it.status = "liked"
               } else {
                   println("already liked\n dou you want to unlike press 1")
                   var out= readln().toInt()
                   if(out==1){
                       it.status="notliked"
                       it.likes=it.likes-1
                   }
               }
           }
            var commentt=async {
                if (comment != null) {
                    it.comments?.add(comment)
                }
               }
            like.await()
            commentt.await()
        }}catch (exception:Exception){
                    println("post not found")
        }
    }
    fun time():String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val formatted = current.format(formatter)
        return formatted
    }
}