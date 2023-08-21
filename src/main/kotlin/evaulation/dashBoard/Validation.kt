package evaulation.dashBoard

object Validation {
    private val passwordvalidation: Regex =Regex("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
    private val start: Long =6000000000
    private val end=9999999999
    private val emailValid="@gmail.com"
    fun passwordValidation(password:String):Boolean{
        return passwordvalidation.matches(password)
    }
    fun phonenumberValidation(phonenumber:Long):Boolean{
        return (phonenumber in (start + 1)..<end)
    }
    fun emailValidation(email:String):Boolean{
        return email.contains(emailValid)
    }
    fun userNameValidation(userName:String):Boolean{
        return userName.length>10
    }
    fun nameValidation(name:String):Boolean{
        return name.length>10
    }

}