package com.example.hpapp.data.repository

import com.example.hpapp.data.api.CharacterApi
import com.example.hpapp.data.api.model.Characters
import javax.inject.Inject

class CharacterRepo @Inject constructor(
    private val characterApi: CharacterApi
) {
    suspend fun getCharacters(): List<Characters>{
        return characterApi.getCharacter()
    }
}