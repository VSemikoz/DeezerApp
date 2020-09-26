package ru.vssemikoz.deezerapp.base

interface BaseMapper<T, R> {
    fun map(mapObject: T): R
}
