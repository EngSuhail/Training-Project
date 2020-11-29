package eng.suhail.android.appssquareproject.API

import eng.suhail.android.appssquareproject.Models.DataResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIRest {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<DataResponse>
}



