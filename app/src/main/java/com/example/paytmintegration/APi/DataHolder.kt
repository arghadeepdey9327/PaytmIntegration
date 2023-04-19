package com.example.paytmintegration.api

data class PaytmInitiateTransactionApi(
    val price:String="1",
    val body:Body=Body(price=price),
    val head:Head=Head()
)
data class Head(
    val signature:Checksum=Checksum()
)
data class Checksum(
    val body:String=Body().toString(),
    val merchantKey:String=""
)
data class Body(
    val price:String="1",
    val requestType:String="payment",
    val merchantId:String="QZgwlM82098919406711",
//    val websiteName:String="URL",
    val orderId:String="ORDERID_98765",
//    val callbackUrl:String="URL",
    val txtAmount:TxtAmount= TxtAmount(price=price),
    val userInfo:UserInfo= UserInfo()
)
data class TxtAmount(
    val price:String="1",
    val currency:String="INR"
)
data class UserInfo(
val custId:String="CUST_001"
)