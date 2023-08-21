package evaulation.dashBoard

object Lists {
    var usersList:MutableList<User> = mutableListOf(
            User(1,"govindasai1","govindasai","sai101@gmail.com",6309883352,"Govind@123"),
            User(2,"nitish0","nitish","nithis3@gmail.com",9568778842,"Nitish@123")
    )
    var postList:MutableList<Post> = mutableListOf(
            Post(1,1,"govindasai","happy independence day","11:30",10,"notliked", mutableListOf()),
            Post(2,2,"nitish","happy birthday","10:05",2,"notliked",mutableListOf()),
                    Post(2,3,"nitish","hi hello world","05:05",7,"notliked",mutableListOf())
    )
    var viewingPost:MutableList<Post> = mutableListOf()
    var userInfo:MutableList<UserInfo> = mutableListOf(
        UserInfo(1,"govindasai1","govindasai"),
        UserInfo(2,"nitish0","nitish")
    )
    var FollowingUsers:MutableList<UserInfo> = mutableListOf()
}