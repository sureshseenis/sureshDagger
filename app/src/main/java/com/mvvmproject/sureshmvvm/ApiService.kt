package cchcc.learn.amu

import com.google.gson.JsonArray
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    fun getApi(): Observable<JsonArray>
}