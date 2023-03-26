package com.eaggle.Quiz.modules

import com.eaggle.Quiz.helpers.DataManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class HiltModule {

    @Provides
    @ActivityScoped
    fun createDataStorage(): DataManager{
        return DataManager()
    }
}