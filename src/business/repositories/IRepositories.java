package business.repositories;

import java.util.List;

public interface IRepositories<T> {

    boolean create(T obj);
    List<T> read();
    boolean update(T obj);
    T buscarPorNomes(String titulo);
    boolean removerPorNome(String titulo);

}