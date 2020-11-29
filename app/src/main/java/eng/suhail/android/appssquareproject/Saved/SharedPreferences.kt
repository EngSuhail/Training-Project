//package eng.suhail.android.appssquareproject.Saved
//
//import android.content.Context
//import eng.suhail.android.appssquareproject.Models.User
//
//class SharedPreferences private constructor(mCtx: Context) {
//    private val mCtx: Context
//    fun saveUser(user: User) {
//        val sharedPreferences: android.content.SharedPreferences? =
//            mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
//        val editor: SharedPreferences.Editor = sharedPreferences.edit()
//        editor.putInt("id", user.id)
//        editor.putString("email", user.email)
//        editor.putString("name", user.name)
//        editor.putString("school", user.getSchool())
//        editor.apply()
//    }
//
//    val isLoggedIn: Boolean
//        get() {
//            val sharedPreferences: android.content.SharedPreferences? =
//                mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
//            if (sharedPreferences != null) {
//                return sharedPreferences.getInt("id", -1) !== -1
//            }
//        }
//    val user: User
//        get() {
//            val sharedPreferences: android.content.SharedPreferences? =
//                mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
//            return User(
//                sharedPreferences.getInt("id", -1),
//                sharedPreferences.getString("email", null),
//                sharedPreferences.getString("name", null),
//                sharedPreferences.getString("school", null)
//            )
//        }
//
//    fun clear() {
//        val sharedPreferences: android.content.SharedPreferences? =
//            mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
//        val editor: SharedPreferences.Editor = sharedPreferences.edit()
//        editor.clear()
//        editor.apply()
//    }
//
//    companion object {
//        private const val SHARED_PREF_NAME = "my_shared_preff"
//        private var mInstance: SharedPreferences? = null
//        @Synchronized
//        fun getInstance(mCtx: Context): SharedPreferences? {
//            if (mInstance == null) {
//                mInstance = SharedPreferences(mCtx)
//            }
//            return mInstance
//        }
//    }
//
//    init {
//        this.mCtx = mCtx
//    }
//}