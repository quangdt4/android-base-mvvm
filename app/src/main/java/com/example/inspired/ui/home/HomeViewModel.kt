package com.example.inspired.ui.home

import androidx.paging.PagingData
import com.example.inspired.data.network.response.PhotoRes
import com.example.inspired.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

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