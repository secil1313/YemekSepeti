package com.secil.utility;

import java.util.List;
import java.util.Optional;

/**
 *
 * @param <T>->Entitynin adı/Type
 * @param <ID>->Entitynin @Id ile işaretlenmiş alanının DataTypeı
 */
public interface IService<T,ID> {
    T save(T t);
    /**
     * Belli bir entity listesini kaydetmek için kullanırız.Kayıt işleminden sonra
     * kaydedilen tüm kayıtların almış oldukları idler ile listesini döneriz.
     */
    Iterable<T> saveAll(Iterable<T> entities);
    T update (T t);
    void delete(T t);
    void deleteById(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();
}
