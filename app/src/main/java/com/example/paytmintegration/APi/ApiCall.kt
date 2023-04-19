package com.example.paytmintegration.APi

import com.example.paytmintegration.api.PaytmInitiateTransactionApi
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

    interface ApiCall {
   @POST("theia/api/v1/initiateTransaction?mid={mid}&orderId={order-id}")
   fun getTransactionApiData(
       price:String="1",
       @Path("mid") mid:String="QZgwlM82098919406711",
       @Path("order-id") orderId:String="ORDERID_98765",
       @Body request: PaytmInitiateTransactionApi
   = PaytmInitiateTransactionApi(price=price)
   ):Response<InitiateTrasactionApiResponseHolder>

}