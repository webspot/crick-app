package msj.xloop.secondapi;

import java.util.Collection;

public interface IRepo<T> {

    public void save(T p);
    public Collection<T> getAll();
}