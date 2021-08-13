package com.victor.creativenaija

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fevziomurtekin.payview.Payview
import com.fevziomurtekin.payview.data.PayModel
import com.flutterwave.raveandroid.rave_core.models.SavedCard
import com.flutterwave.raveandroid.rave_java_commons.RaveConstants
import com.flutterwave.raveandroid.rave_java_commons.RaveConstants.NGN
import com.flutterwave.raveandroid.rave_presentation.RaveNonUIManager
import com.flutterwave.raveandroid.rave_presentation.card.Card
import com.flutterwave.raveandroid.rave_presentation.card.CardPaymentCallback
import com.flutterwave.raveandroid.rave_presentation.card.CardPaymentManager
import com.flutterwave.raveandroid.rave_presentation.card.SavedCardsListener
import com.victor.creativenaija.databinding.ActivityFundWalletBinding
import com.victor.creativenaija.utils.Constants


class FundWalletActivity : AppCompatActivity(), CardPaymentCallback{

    lateinit var cardPayManager:CardPaymentManager
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityFundWalletBinding

        val card = Card(
            "5531886652142950",
            "12",
            "22",
            "123"
        )

        binding = ActivityFundWalletBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)



        binding.payview.setOnDataChangedListener(object : Payview.OnChangelistener {
            override fun onChangelistener(payModel: PayModel?, isFillAllComponent: Boolean) {


                Log.d(
                    "PayView", "data : ${payModel?.cardOwnerName} \n " +
                            "is Fill all form component : $isFillAllComponent"
                )

            }

        })

//        binding.payview.setPayOnclickListener {
//            Toast.makeText(this, " clicked", Toast.LENGTH_LONG).show()
//        }


        val raveNonUIManager: RaveNonUIManager =
            RaveNonUIManager()
                .setAmount(400.0)
                .setCurrency("NGN")
                .setCountry("NG")
                .setEmail("abraham.nnu@gmail.com")
                .setfName("Victor")
                .setlName("Abraham")
                .setNarration("")
                .setPublicKey("FLWPUBK_TEST-46d2d918ac29137f8a911db6814da801-X")
                .setEncryptionKey("FLWSECK_TEST6de83b78dc54")
                .setTxRef("5555")
                .setPhoneNumber("09077644842")
                .onStagingEnv(true)
//                .setMeta(List<Meta>)
                .isPreAuth(false)
//                .setSubAccounts(List<SubAccount>)

                .initialize();

//        .shouldDisplayFee(true)
//            .showStagingLabel(boolean)


        cardPayManager = CardPaymentManager(
            raveNonUIManager, this
//            raveNonUIManager, CardPaymentCallback, SavedCardsListener
        )


        binding.payview.setPayOnclickListener(View.OnClickListener {



            Log.d(
                "PayView ",
                " clicked. iss Fill all form Component : ${binding.payview.isFillAllComponents}"
            )
            cardPayManager.chargeCard(card)



        })


//         card= Card(
//
////            "5531886652142950", "12",
////            "22",
////            "123"
//        )

        // Test MasterCard PIN

//        cardPayManager.chargeCard(card);
    }


    override fun showProgressIndicator(active: Boolean) {
        Log.d(TAG, "showProgressIndicator: $active")
//        if (!active) Toast.makeText(this,"Done",Toast.LENGTH_LONG).show()
//        TODO("Not yet implemented")
    }

    override fun collectCardPin() {
//        TODO("Not yet implemented")
        cardPayManager.submitPin("3310")
        Toast.makeText(this,"pin collected",Toast.LENGTH_LONG).show()
    }

    override fun collectOtp(message: String?) {
        cardPayManager.submitOtp("12345")
        Toast.makeText(this,"otp collected",Toast.LENGTH_LONG).show()
        Log.d(TAG, "collectOtp: $message")
//        TODO("Not yet implemented")
    }

    override fun collectAddress() {
        Log.d(TAG, "collectAddress: collected address")
//        TODO("Not yet implemented")
    }

    override fun showAuthenticationWebPage(authenticationUrl: String?) {
//        TODO("Not yet implemented")
        Log.d(TAG, "showAuthenticationWebPage: $authenticationUrl")
    }

    override fun onError(errorMessage: String?, flwRef: String?) {

        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()

        Log.d(TAG, "onError: $errorMessage ")
//        Toast.makeText(this, "$flwRef success",Toast.LENGTH_LONG).show()
////        TODO("Not yet implemented")
//    }
    }

    override fun onSuccessful(flwRef: String?) {

        Log.d(TAG, "onSuccessful: $flwRef ")
        Toast.makeText(this, "$flwRef success", Toast.LENGTH_LONG).show()
//        TODO("Not yet implemented")
    }

//    override fun onSavedCardsLookupSuccessful(
//        cards: MutableList<SavedCard>?,
//        phoneNumber: String?
//    ) {
////        TODO("Not yet implemented")
//    }
//
//    override fun onSavedCardsLookupFailed(message: String?) {
////        TODO("Not yet implemented")
//    }
//
//    override fun onDeleteSavedCardRequestSuccessful() {
////        TODO("Not yet implemented")
//    }
//
//    override fun onDeleteSavedCardRequestFailed(message: String?) {
////        TODO("Not yet implemented")
//    }
//
//    override fun collectOtpForSaveCardCharge() {
////        TODO("Not yet implemented")
//    }
//
//    override fun onCardSaveSuccessful(phoneNumber: String?) {
////        TODO("Not yet implemented")
//    }
//
//    override fun onCardSaveFailed(message: String?) {
////        TODO("Not yet implemented")
    }


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        /*
//         *  We advise you to do a further verification of transaction's details on your server to be
//         *  sure everything checks out before providing service or goods.
//        */
//        if (requestCode == RaveConstants.RAVE_REQUEST_CODE && data != null) {
//            val message = data.getStringExtra("response")
//            if (resultCode == Constants.RESULT_SUCCESS) {
//                Toast.makeText(this, "SUCCESS $message", Toast.LENGTH_SHORT).show()
//            } else if (resultCode == Constants.RESULT_ERROR) {
//                Toast.makeText(this, "ERROR $message", Toast.LENGTH_SHORT).show()
//            } else if (resultCode == Constants.RESULT_CANCELLED) {
//                Toast.makeText(this, "CANCELLED $message", Toast.LENGTH_SHORT).show()
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }


//}