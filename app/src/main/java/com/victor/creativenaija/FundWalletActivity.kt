package com.victor.creativenaija

import `in`.aabhasjindal.otptextview.OTPListener
import `in`.aabhasjindal.otptextview.OtpTextView
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fevziomurtekin.payview.Payview
import com.fevziomurtekin.payview.data.PayModel
import com.flutterwave.raveandroid.rave_presentation.RaveNonUIManager
import com.flutterwave.raveandroid.rave_presentation.card.Card
import com.flutterwave.raveandroid.rave_presentation.card.CardPaymentCallback
import com.flutterwave.raveandroid.rave_presentation.card.CardPaymentManager
import com.victor.creativenaija.databinding.ActivityFundWalletBinding


class FundWalletActivity : AppCompatActivity(), CardPaymentCallback {

    lateinit var cardPayManager: CardPaymentManager
    var otpDialog: Dialog? = null
    var pinDialog: Dialog? = null
    var view1: View? = null
    var view2: View? = null
    var dialogOtp: AlertDialog.Builder? = null
    var dialogPin: AlertDialog.Builder? = null

    lateinit var alertDialogPin: AlertDialog
    lateinit var alertDialogOtp: AlertDialog


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityFundWalletBinding
        binding = ActivityFundWalletBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)
        val otpView: OtpTextView = view2!!.findViewById(R.id.otp_view)
        val pinView: OtpTextView = view1!!.findViewById(R.id.pin_view)




        initializeDialogs()


        val card = Card(
            "5531886652142950",
            "12",
            "22",
            "123"
        )

//        -------------------  PayView Block ----------------------------

        binding.payview.setPayOnclickListener(View.OnClickListener {


            Log.d(
                "PayView ",
                " clicked. iss Fill all form Component : ${binding.payview.isFillAllComponents}"
            )
            cardPayManager.chargeCard(card)


        })


//        -------------------  PayView Block  End ----------------------------




        otpView.setOtpListener(object : OTPListener {
            override fun onInteractionListener() {
                // fired when user types something in the Otpbox
            }

            override fun onOTPComplete(otp: String) {
                cardPayManager.submitOtp(otp)
                // fired when user has entered the OTP fully.
//                Toast.makeText(this@MainActivity, "The OTP is $otp", Toast.LENGTH_SHORT).show()
            }
        })
        pinView.setOtpListener(object : OTPListener {
            override fun onInteractionListener() {
                // fired when user types something in the Otpbox
            }

            override fun onOTPComplete(otp: String) {
                cardPayManager.submitPin(otp)
                // fired when user has entered the OTP fully.
//                Toast.makeText(this@MainActivity, "The OTP is $otp", Toast.LENGTH_SHORT).show()
            }
        })









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
//        .shouldDisplayFee(true)
//            .showStagingLabel(boolean)

                .initialize();



        cardPayManager = CardPaymentManager(
            raveNonUIManager, this
//            raveNonUIManager, CardPaymentCallback, SavedCardsListener
        )






    }


    //    ------------ Charge Card Callback methods
    override fun showProgressIndicator(active: Boolean) {
        Log.d(TAG, "showProgressIndicator: $active")
//        if (!active) Toast.makeText(this,"Done",Toast.LENGTH_LONG).show()
//        TODO("Not yet implemented")
    }

    override fun collectCardPin() {

//        val view2: View = layoutInflater.inflate(R.layout.pin_layout, null, false)
//        val dialog = AlertDialog.Builder(this)
//        dialog.setView(view2)
//        alertDialog = dialog.create()
////        alertDialog.setContentView(view2)
        alertDialogPin.show()
//        TODO("Not yet implemented")
//        pinDialog?.show()
//        cardPayManager.submitPin("3310")
        Toast.makeText(this, "pin collected", Toast.LENGTH_LONG).show()
    }

    override fun collectOtp(message: String?) {
//        cardPayManager.submitOtp("12345")

        val view2: View = layoutInflater.inflate(R.layout.otp_view, null, false)
        val dialog = AlertDialog.Builder(this)
        dialog.setView(view2)
//        alertDialog = dialog.create()
//        alertDialog.setContentView(view2)
        alertDialogOtp.show()

//        otpDialog?.show()

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
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


    fun initializeDialogs() {

        otpDialog = Dialog(this)
        pinDialog = Dialog(this)
//    otpDialog!!.setContentView(R.layout.otp_view)
//    pinDialog!!.setContentView(R.layout.otp_view)
        view1 = layoutInflater.inflate(R.layout.pin_layout, null, false)
        view2 = layoutInflater.inflate(R.layout.otp_view, null, false)
        dialogOtp = AlertDialog.Builder(this)
        dialogPin = AlertDialog.Builder(this)
        dialogOtp!!.setView(view2)
        dialogPin!!.setView(view1)
        alertDialogPin = dialogPin!!.create()
        alertDialogOtp = dialogOtp!!.create()


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