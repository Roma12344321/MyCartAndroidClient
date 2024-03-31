package com.dev.mycart.data

import com.dev.mycart.domain.Person
import javax.inject.Inject

class LogInMapper @Inject constructor() {
    fun mapPersonDtoToPerson(personDto: PersonDto) : Person {
        return Person(
            username = personDto.username,
            password = personDto.password,
            email = personDto.email,
            year = personDto.year
        )
    }
    fun mapPersonToPersonDto(person: Person) : PersonDto {
        return PersonDto(
            username = person.username,
            password = person.password,
            email = person.email,
            year = person.year,
            avatar = null
        )
    }
}