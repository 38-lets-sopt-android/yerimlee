package com.example.letssopt

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class Content(
    val title: String
)

class MainViewModel : ViewModel() {

    private val _contentList = MutableStateFlow<List<Content>>(emptyList())
    val contentList: StateFlow<List<Content>> = _contentList

    init {
        loadContents()
    }

    private fun loadContents() {
        _contentList.value = listOf(
            Content("이 사람 톰역? 되나요"),
            Content("스트레인저 씽스5"),
            Content("헤일 메리"),
            Content("크라임씬 리턴즈"),
            Content("파묘")
        )
    }
}