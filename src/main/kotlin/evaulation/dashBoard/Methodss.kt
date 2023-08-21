package evaulation.dashBoard

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Methodss {
    fun followUsers(userName: String, usersList: MutableList<UserInfo> = Lists.userInfo, postlist: MutableList<Post> = Lists.postList) {
        var list1:MutableList<UserInfo> = mutableListOf()
        list1.addAll(Lists.userInfo)
        list1.removeIf { it.userName==userName}
        list1.removeAll(Lists.FollowingUsers)
        println(list1)
        println("enter user name to follow")
        var userName1: String= readln()
        var list = usersList.filter { it.userName == userName1 }
        if (list.isNotEmpty()) {
            Lists.FollowingUsers.addAll(list)
            var userId = list[0].userId
            var list2 = postlist.filter { it.userId == userId }
            Lists.viewingPost.addAll(list2)
            println("$userName1 followed")
        } else println("user not found")
    }

    fun unfollowUsers(usersList: MutableList<UserInfo> = Lists.userInfo) {
        println(Lists.FollowingUsers)
        println("enter username to unfollow :")
        var userName= readln()
        var list = usersList.filter { it.userName == userName }
        if (list.isNotEmpty()) {
            Lists.FollowingUsers.removeAll(list)
            var userId = list[0].userId
            var list2 = Lists.viewingPost.map { it.userId == userId }
            if (list2[0]) {
                Lists.viewingPost.removeIf { it.userId == userId }
                println("$userName unfollowed")
            } else println("$userName not followed")
        } else println("user not found")
    }

    fun creatingPost(userName: String, postlist: MutableList<Post> = Lists.postList) {
        var userId: Int = (Lists.usersList.filter { it.userName == userName })[0].userId
        var authorName = (Lists.usersList.filter { it.userName == userName })[0].name
        var numberOfPosts = ((postlist.sortedByDescending { it.postId })[0].postId)+1
        if (userId != 0) {
            println("enter some content :")
            var content: String = readln()
            var time = time()
            postlist.add(Post(userId, (numberOfPosts), authorName, content, time, 0,"notliked", mutableListOf()))
            println("post added for user $userName")
        } else println("user not found")
    }

    fun basedOnLikes(likes: Int) {
        var list = Lists.viewingPost.filter { it.likes > likes }
        println("these are the posts that are grater than  $likes\n$list")
    }

    fun sortOnLikes() {
        var list = Lists.viewingPost.sortedBy { it.likes }
        println(list)
    }

    fun sortOnTime() {
        var list = Lists.viewingPost.sortedBy {it.timestamp}
        println(list)
    }

    fun ownPosts(userName: String) {
        var userId = (Lists.usersList.filter { it.userName == userName })[0].userId
        var list = Lists.postList.filter { it.userId==userId }
        println(list)
    }
    fun followedUsers(){
        println(Lists.viewingPost)
    }
    fun likeOrUnlikeOrComment()= runBlocking {
        followedUsers()
        println("enter post id")
        var postId: Int = readln().toInt()
        do {
        println("to like post press -> 1\nto comment post press -> 2\nto unlike like post press -> 1")
        var responce = readln().toInt()

            when (responce) {
                1 -> {
                    var output = Lists.postList.find { it.postId == postId }
                    try {
                        output?.let {
                            var like = async {
                                if (it.status == "notliked") {
                                    it.likes  += 1
                                    it.status = "liked"

                                } else {
                                    println("already liked\n dou you want to unlike press 1")
                                    var out = readln().toInt()
                                    if (out == 1) {
                                        it.status = "notliked"
                                        it.likes -= 1
                                    }
                                }
                            }
                            like.await()

                        }
                    } catch (exception: Exception) {
                        println("post not found")
                    }
                }

                2 -> {
                    println("enter comment to add")
                    var comment: String? = readln()
                    var output = Lists.postList.find { it.postId == postId }
                    try {
                        output?.let {
                            var commentt = async {
                                if (comment != null) {
                                    it.comments?.add(comment)
                                }
                            }
                            commentt.await()
                        }
                    } catch (exception: Exception) {
                        println("post not found")
                    }
                }

                3 -> {
                    var output = Lists.postList.find { it.postId == postId }
                    try {
                        output?.let {
                            var like = async {
                                if (it.status == "liked") {
                                    it.likes = --(it.likes)
                                    it.status = "notliked"
                                } else {
                                    println("already notliked ")
                                }
                            }
                            like.await()
                        }
                    } catch (exception: Exception) {
                        println("post not found")
                    }
                }

                else -> println("nothing")
            }
            println("do you want to make interactions press 1 :")
            var interaction= readln().toInt()
        }while (interaction==1)
    }
    private fun time(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        return current.format(formatter)
    }
}