package com.example.paytmintegration

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.paytmintegration.APi.ApiCall
import com.example.paytmintegration.APi.RetrofitInstance
import com.example.paytmintegration.ui.theme.PaytmintegrationTheme
import com.example.paytmintegration.viewmodel.viewmodel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val textfiledviewmodel: viewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaytmintegrationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Main(
                        vm=textfiledviewmodel
                    )
                }
            }
        }
    }
}

@Composable
fun Main(vm:viewmodel){
    PriceField(vm = vm)
    Spacer(modifier = Modifier.height(height = 10.dp))
    InitiateTransactionButton(vm=vm)
}
@Composable
fun PriceField(vm:viewmodel){
    TextField(value = vm.price.collectAsState().value,
        onValueChange ={
            it -> vm.updatePriceField(it)
        } )
}
@Composable
fun InitiateTransactionButton(vm:viewmodel){
    val price=vm.price.collectAsState().value
    Button(onClick = {
       GlobalScope.launch{transactionHappening(price = price)}

    }) {
        Text(stringResource(id = R.string.btn))
    }
}
suspend fun transactionHappening(price:String){
 val api=RetrofitInstance.getRetrofitInstance().create(ApiCall::class.java)
    val response=api.getTransactionApiData(price = price)
    Log.e("",response.toString())
}