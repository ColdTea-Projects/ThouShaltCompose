package de.sample.naci.composetutorial.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import de.sample.naci.composetutorial.BuildConfig
import de.sample.naci.composetutorial.gamepager.data.GamesApi
import de.sample.naci.composetutorial.gamepager.data.GamesRepository
import de.sample.naci.composetutorial.gamepager.data.GamesSource
import de.sample.naci.composetutorial.gamepager.utils.json
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideGameSource(gamesRepository: GamesRepository) = GamesSource(gamesRepository)

    @Provides
    @Singleton
    fun provideGamesRepository(gamesApi: GamesApi): GamesRepository = GamesRepository(gamesApi)

    @Provides
    @Singleton
    fun provideGamesApi(retrofit: Retrofit): GamesApi = retrofit.create(GamesApi::class.java)

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.ROOT_URL_GAMES_API)
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().apply {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(httpLoggingInterceptor)
        }.build()

}