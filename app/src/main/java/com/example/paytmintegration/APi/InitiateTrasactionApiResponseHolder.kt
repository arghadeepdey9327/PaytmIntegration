package com.example.paytmintegration.APi

data class InitiateTrasactionApiResponseHolder(
val head:Head=Head(),
val body:Body=Body()
)
data class Head(
    val responseTimestamp:String="",
    val version:String="",
    val clientId:String="",
    val signature:String=""
)
data class Body(
    val resultInfo:ResultInfo=ResultInfo(),
    val txnToken:String="",
    val isPromoCodeValid:String="",
    val authenticated:String=""
)
data class ResultInfo(
    val resultStatus:String="",
    val resultCode:String="",
    val resultMsg:String=""
)