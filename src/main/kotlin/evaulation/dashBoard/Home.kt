package evaulation.dashBoard

fun loginCall(){
    var loginResponse= login()
    println(loginResponse)
    var responce ="incorrect credentials given"
    if(loginResponse==responce){
        login()
        println(login())
    }
    else{
        do{
            calling(loginResponse)
            println("press 0 to logout press 1 to continue")
            var resp= readln().toInt()
            println(resp)
        }
            while (resp==1)
    }
}
fun registationCall(){
    var reg= registation()
    println(reg)
    if(reg==("registered successfully")){
        loginCall()
    }

}
fun calling(response:String){
    println("PRESS 1--> follow a user \nPRESS 2--> unfollow a user \nPRESS 3--> create a new post\nPRESS 4--> view posts that are grater than given number of likes" +
            "\nPRESS 5--> view post that are sorted according to likes\nPRESS 6--> view post that are sorted according to time\nPRESS 7--> show my own posts\nPRESS 8--> show users posts which are followed by me\nPRESS 9--> like or unlike or comment a post\n")
    var responce= readln().toInt()
    when(responce){
        1-> Methodss.followUsers(response)
        2-> Methodss.unfollowUsers()
        3-> Methodss.creatingPost(response)
        4->{ println("enter number of likes")
            var likes= readln().toInt()
            Methodss.basedOnLikes(likes)
        }
        5-> Methodss.sortOnLikes()
        6-> Methodss.sortOnTime()
        7-> Methodss.ownPosts(response)
        8-> Methodss.followedUsers()
        9-> Methodss.likeOrUnlikeOrComment()

    }
}