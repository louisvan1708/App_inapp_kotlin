package com.example.app_inapp_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.android.billingclient.api.*

class MainActivity2 : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val ironman = intent.getParcelableExtra<Ironman>("data")
        if (ironman != null){
            val tvNameDetail : TextView = findViewById( R.id.tvNameDetail)
            val tvPriceDetail : TextView = findViewById( R.id.tvPriceDetail)
            val imageView : ImageView = findViewById(R.id.imgDetail)
            tvNameDetail.text = ironman.name
            tvPriceDetail.text = ironman.price
            imageView.setImageResource(ironman.img)
        }

        button = findViewById(R.id.btnBuy)

        val skuList = ArrayList<String>()
        skuList.add("android.test.purchases")

        val purchasesUpdatedListener = PurchasesUpdatedListener{
            billingResult, purchases ->
        }

        var billingClient = BillingClient.newBuilder(this)
            .setListener(purchasesUpdatedListener)
            .enablePendingPurchases().build()

        button.setOnClickListener {
            billingClient.startConnection(object : BillingClientStateListener{
                override fun onBillingServiceDisconnected() {

                }

                override fun onBillingSetupFinished(billingResult : BillingResult) {
                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK){
                        val params = SkuDetailsParams.newBuilder()
                        params.setSkusList(skuList)
                            .setType(BillingClient.SkuType.INAPP)

                        billingClient.querySkuDetailsAsync(params.build()){
                            BillingResult, skuDetailsList ->

                            for (skuDetails in skuDetailsList!!){
                                val flowPurchase = BillingFlowParams.newBuilder()
                                    .setSkuDetails(skuDetails)
                                    .build()

                                val responseCode = billingClient.launchBillingFlow(this@MainActivity2, flowPurchase).responseCode
                            }
                        }
                    }
                }

            })
        }

    }
}

















