package com.example.one.data.network

import com.example.one.data.network.response.PhotoRes
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppApi {
    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int?,
        @Query("per_page") per_page: Int?,
        @Query("order_by") order_by: String?
    ): List<PhotoRes>

    @GET("photos/{id}")
    fun getPhoto(@Path("id") id: String): Observable<Response<PhotoRes>>

    @GET("photos/random")
    suspend fun getRandomPhotos(
        @Query("collections") collectionsId: String?,
        @Query("featured") featured: Boolean?,
        @Query("username") username: String?,
        @Query("query") query: String?,
        @Query("orientation") orientation: String?,
        @Query("content_filter") contentFilter: String?,
        @Query("count") count: Int?
    ): List<PhotoRes>
}
