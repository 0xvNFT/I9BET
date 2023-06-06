package com.i9betstoryphat.i9bet.ui.phone

import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import android.telephony.TelephonyManager
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import com.i9betstoryphat.i9bet.BaseActivity
import com.i9betstoryphat.i9bet.MainActivity
import com.i9betstoryphat.i9bet.R
import com.i9betstoryphat.i9bet.data.HttpRequest
import com.i9betstoryphat.i9bet.data.LoginPhone
import com.i9betstoryphat.i9bet.databinding.ActivityPhoneBinding
import com.i9betstoryphat.i9bet.utils.AppUtils
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.util.Locale

class PhoneActivity : BaseActivity<ActivityPhoneBinding>() {


    override fun getViewBinding() = ActivityPhoneBinding.inflate(layoutInflater)
    var mv: String = ""

    override fun initView() {
        super.initView()
        phoneActivity = this
        val tm = this.getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        mv = tm.networkOperatorName.lowercase(Locale.getDefault())
        isEmulatorMain = isEmulator()
    }

    override fun initData() {
        super.initData()


    }

    fun isEmulator(): Boolean {
        try {
            val buildDetails =
                (Build.FINGERPRINT + Build.DEVICE + Build.MODEL + Build.BRAND + Build.PRODUCT + Build.MANUFACTURER + Build.HARDWARE).lowercase(
                    Locale.getDefault()
                )
            if (buildDetails.contains("generic")
                || buildDetails.contains("unknown")
                || buildDetails.contains("emulator")
                || buildDetails.contains("sdk")
                || buildDetails.contains("genymotion")
                || buildDetails.contains("x86") // this includes vbox86
                || buildDetails.contains("goldfish")
                || buildDetails.contains("test-keys")
            ) return true
        } catch (t: Throwable) {
        }
        try {
            if (mv == "android") return true
        } catch (t: Throwable) {
        }
        try {
            if (File("/init.goldfish.rc").exists()) return true
        } catch (t: Throwable) {
        }
        return false
    }

    inner class PhoneTask(var phone: String) :
        AsyncTask<String?, String?, String>() {
        override fun doInBackground(vararg p0: String?): String {
            val user = JSONObject()
            try {
                user.put("appName", "App TK88 COLOR")
                user.put("package", "com.i9betstoryphat.i9bet")
                user.put("phone", phone + "")
                user.put("simulator", isEmulatorMain)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            val res: String =
                HttpRequest().performPostCall("https://xinhtv16.com/getNumber", user)
            Log.d("response", res)
            var obj: JSONObject? = null
            try {
                obj = JSONObject(res)
                if (obj.getString("homeURL") != "") {
                    AppUtils.saveLogin(
                        LoginPhone(
                            obj.getString("homeURL"),
                            obj.getString("changeURL"),
                            obj.getString("mobile"),
                            obj.getString("contact"),
                            obj.getString("lct")
                        )
                    )
                }
            } catch (e: JSONException) {
                AppUtils.saveLogin(LoginPhone(lct = "false"))
            }
            return "true"
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            startActivity(Intent(phoneActivity, MainActivity::class.java))
        }


    }

    fun checkPhone(view: View) {
        val phoneNumber = binding.inputText
        val phoneNumbe = phoneNumber.text.toString()

        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)

        if (phoneNumbe == "" || phoneNumbe.length != 10) {
            Toast.makeText(this, "Số điện thoại bạn nhập chưa chính xác !", Toast.LENGTH_SHORT)
                .show()
        } else {
            val btn = findViewById<TextView>(R.id.btnOk)
            btn.text = "Loading..."
            val PhoneTask = PhoneTask(phoneNumbe)
            PhoneTask.execute("")
        }
    }

    companion object {
        var isEmulatorMain = false

        lateinit var phoneActivity: PhoneActivity
    }

}