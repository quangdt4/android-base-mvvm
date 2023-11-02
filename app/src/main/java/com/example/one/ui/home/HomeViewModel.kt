package com.example.one.ui.home

import androidx.paging.PagingData
import com.example.one.data.network.response.PhotoRes
import com.example.one.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    private var currentQueryValue: String? = null
    private var currentSearchResult: Flow<PagingData<PhotoRes>>? = null

//    fun searchPictures(queryString: String): Flow<PagingData<UnsplashPhoto>> {
//        currentQueryValue = queryString
//        val newResult: Flow<PagingData<UnsplashPhoto>> =
//            repository.getSearchResultStream(queryString).cachedIn(viewModelScope)
//        currentSearchResult = newResult
//        return newResult
//    }
}
