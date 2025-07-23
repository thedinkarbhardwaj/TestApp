package com.testapp.activities.Login


data class loginDataClass(var status: String, var message: String, var data: Data)


data class Data(
    var user_id : Int,
    var token : String,
    var name : String,
    var email : String,
    var phone : String,
    var image : String,
    var isVerified : Int)

