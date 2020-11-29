package eng.suhail.android.appssquareproject.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import eng.suhail.android.appssquareproject.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*   // The first way using the postDelayed(Runnable, time) method
     // to send a message with a delayed time.
     Handler(Looper.getMainLooper()).postDelayed({
     val intent = Intent(this, LoginScreen ::class.java)
     startActivity(intent)
     finish()
 }, 5000) // 5000 is the delayed time in milliseconds.*/

/*   // The second way using Thread.sleep().

     var thread = object: Thread(){
             override fun run() {
                try {
                    Thread.sleep(5000)
                    var intent= Intent(baseContext,LoginScreen::class.java)
                    startActivity(intent)
                    finish()
                }
                catch (ex:Exception){
                    Toast.makeText(baseContext,"Error",Toast.LENGTH_LONG).show()
                }

            }
        }
        thread.start()
 */

        // The third way: We can use CountDownTimer Class.
        val time = object : CountDownTimer(5000, 1000)
        {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                startActivity(Intent (this@MainActivity, LoginScreen ::class.java))
                finish()
            }

        }.start()



    }
}