package duypn.classes;

public interface IDaoRepository<T> {
    public boolean create(T info) throws Exception ;
    public boolean update(T info) throws Exception;
    public boolean delete(int key) throws Exception;
}
