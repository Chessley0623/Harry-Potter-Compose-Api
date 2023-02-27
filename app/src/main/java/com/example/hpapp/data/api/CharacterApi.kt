package com.example.hpapp.data.api

import com.example.hpapp.data.api.model.Characters
import retrofit2.http.GET

interface CharacterApi {

    @GET(ApiConstants.END_POINT)
    suspend fun getCharacter():List<Characters>
}