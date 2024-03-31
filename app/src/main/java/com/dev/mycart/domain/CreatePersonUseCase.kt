package com.dev.mycart.domain

import javax.inject.Inject

class CreatePersonUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun createPerson(person: Person) : Boolean {
        return repository.createPerson(person)
    }
}