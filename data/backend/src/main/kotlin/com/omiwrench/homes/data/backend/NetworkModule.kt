package com.omiwrench.homes.data.backend

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.util.Locale

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideJsonConfig() = Json {
        encodeDefaults = true
        prettyPrint = true
        ignoreUnknownKeys = true
        explicitNulls = true
    }

    interface HttpClientFactory {
        operator fun invoke(environment: NetworkEnvironment): HttpClient
    }

    @Provides
    fun provideNetworkEnvironment(): NetworkEnvironment =
        if(BuildConfig.DEBUG) {
            NetworkEnvironment.Debug
        } else {
            NetworkEnvironment.Release
        }

    @Provides
    fun provideHttpClientFactory(
        jsonConfig: Json
    ) = object : HttpClientFactory {
        override fun invoke(environment: NetworkEnvironment): HttpClient = HttpClient(Android) {
            defaultRequest {
                header(HttpHeaders.AcceptLanguage, Locale.getDefault().language)
                header("X-client-name", "tome-of-homes")
                header("X-client-version", "0.0.1-0")
                url {
                    host = environment.backendUrl
                    protocol = URLProtocol.HTTP
                    port = 3000
                }
            }

            install(Resources)

            install(ContentNegotiation) {
                json(jsonConfig)
            }
        }
    }

    @Provides
    fun provideHttpClient(
        factory: HttpClientFactory,
        environment: NetworkEnvironment
    ): HttpClient = factory(environment)
}