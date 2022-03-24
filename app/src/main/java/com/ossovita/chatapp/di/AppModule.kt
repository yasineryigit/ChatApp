package com.ossovita.chatapp.di

import android.content.Context
import com.ossovita.chatapp.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.livedata.ChatDomain
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideChatClient(@ApplicationContext context: Context): ChatClient {
        val client = ChatClient.Builder(context.getString(R.string.api_key), context)
            .logLevel(ChatLogLevel.ALL) // Set to NOTHING in prod
            .build()
        ChatDomain.Builder(client, context).build()
        return client
    }


}