package com.ossovita.chatapp.ui.channel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.ui.channel.list.ChannelListView
import javax.inject.Inject

@HiltViewModel
class ChannelViewModel @Inject constructor(
    private val client: ChatClient//client objesini inject ettik
) : ViewModel() {

    fun logout() {
        client.disconnect()
    }

    fun getUser(): User? {//nullable
        return client.getCurrentUser()
    }



}