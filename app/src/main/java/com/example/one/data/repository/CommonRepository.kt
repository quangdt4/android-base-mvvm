package com.example.one.data.repository

import com.example.one.data.network.AppApi
import com.example.one.data.network.response.PhotoRes
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Response

@Singleton
class CommonRepository @Inject constructor(private var appApi: AppApi) {

//    fun getSearchResultStream(query: String){
//        return Pager(
//            config = PagingConfig(enablePlaceholders = false, pageSize = NETWORK_PAGE_SIZE),
//            pagingSourceFactory = { UnsplashPagingSource(service, query) }
//        ).flow
//    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 25
    }

//    fun getTalentsList(offset: Int, limit: Int, search: String,
//                       filterFollowing: Int, type: String?): Observable<Response<TalentsResponse>> {
//        return appApi.getTalents(offset, limit, filterFollowing, search, type)
//    }

    fun getPhoto(id: String): Observable<Response<PhotoRes>> {
        return appApi.getPhoto(id)
    }

//    fun doUploadApiCall(
//            url: String,
//            picturePath: String,
//            description: String
//    ): Observable<retrofit2.Response<Void>> {
//        val headers = FileUtils.getMimeType(picturePath)
//        val requestBody =
//                ProgressRequestBody.create(MediaType.parse("image/*"), File(picturePath), null)
//        return appApi.uploadFile( url, requestBody)
//    }
}
