package ru.vssemikoz.deezerapp.base;

public interface BaseUseCase<T, P> {
    T run(P params);
}
