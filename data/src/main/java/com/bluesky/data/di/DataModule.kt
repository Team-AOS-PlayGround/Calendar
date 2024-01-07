package com.bluesky.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.bluesky.data.datasource.CalendarDataSource
import com.bluesky.data.datasource.SettingDataSource
import com.bluesky.data.repository.setting.CalendarDataSourceImpl
import com.bluesky.data.repository.setting.SettingDataSourceImpl
import com.bluesky.domain.repository.setting.CalendarRepository
import com.bluesky.domain.repository.setting.SettingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    private const val SETTING_DATASTORE_NAME = "SETTINGS_PREFERENCES"
    private const val CALENDAR_DATASTORE_NAME = "CALENDAR_PREFERENCES"
    private val Context.settingDataStore by preferencesDataStore(SETTING_DATASTORE_NAME)
    private val Context.calendarDataStore by preferencesDataStore(CALENDAR_DATASTORE_NAME)

    @Provides
    @Singleton
    @Named("setting")
    fun provideSettingsDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> = context.settingDataStore

    @Provides
    @Singleton
    @Named("calendar")
    fun provideCalendarDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> = context.calendarDataStore

    @Provides
    @Singleton
    fun provideSettingRepository(
        settingDataSource: SettingDataSource
    ) : SettingRepository {
        return SettingDataSourceImpl(settingDataSource)
    }

    @Provides
    @Singleton
    fun provideCalendarRepository(
        calendarDataSource: CalendarDataSource
    ) : CalendarRepository {
        return CalendarDataSourceImpl(calendarDataSource)
    }
}
