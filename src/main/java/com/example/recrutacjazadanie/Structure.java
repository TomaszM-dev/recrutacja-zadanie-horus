package com.example.recrutacjazadanie;
import java.util.List;
import java.util.Optional;

public interface Structure {

    // zwraca dowolny element o podanym kolorze
    Optional<com.example.recrutacjazadanie.Block> findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List<Block> findBlocksByMaterial(String material);

    //zwraca liczbę wszystkich elementów tworzących strukturę wziasc pod uwage ze composite block to jest gropowanie blokowż
    int count();

}
