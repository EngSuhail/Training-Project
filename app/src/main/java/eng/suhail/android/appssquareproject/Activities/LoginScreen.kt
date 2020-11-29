package eng.suhail.android.appssquareproject.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import eng.suhail.android.appssquareproject.R
import eng.suhail.android.appssquareproject.API.RetrofitClient
import eng.suhail.android.appssquareproject.Models.DataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginScreen : AppCompatActivity(), View.OnClickListener {

    lateinit var loginbtn: Button
    lateinit var phonetxt: EditText
    lateinit var passwordtxt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        loginbtn = findViewById<Button>(R.id.loginbtn)
        phonetxt = findViewById<EditText>(R.id.phonetxt)
        passwordtxt = findViewById<EditText>(R.id.passwordtxt)
        loginbtn.setOnClickListener(this)
    }

    // Creating "Toast" function
    fun showtoast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


    override fun onClick(v: View?) {
        var entered_phone = phonetxt.text.toString().trim()
        var entered_password = passwordtxt.text.toString().trim()

        //https://stackoverflow.com/questions/23214434/regular-expression-in-android-for-password-field
        fun passwordLetter(password: String?): Boolean {
            password?.let {
                //Any letter "(?=.*[a-zA-Z])" (Regex = Regular Expressions)
                val passwordPattern = "(?=.*[a-zA-Z])"
                val passwordMatcher = Regex(passwordPattern)
                return passwordMatcher.find(password) != null
            } ?: return false
        }

        when (v?.id) {
            R.id.loginbtn -> {
                if (entered_phone.isEmpty()) {
                    showtoast("Phone number is required. Can't be empty.")
                } else if (entered_password.isEmpty()) {
                    showtoast("Password is required. Can't be empty.")
                } else if (entered_phone.length != 11) {
                    showtoast("Invalid Phone Number (Must be: 11 digits).")
                } else if (entered_password.length < 8) {
                    showtoast("Password is short. 8 Characters are required.")
                } else if (!passwordLetter(entered_password)) {
                    showtoast("Password must have one letter at least.")
                }
                else {
                    RetrofitClient.instance.login("email","password")
                        .enqueue(object: Callback<DataResponse>{
                            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                                t.message?.let { showtoast(it) }
                            }

                            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                                if(response.isSuccessful){
                                    startActivity(Intent (this@LoginScreen, HomeScreen ::class.java))
                                }
                                else {showtoast("Error") }
                            }

                        })

                }

            }

        }
    }
}





