package list;

public interface SimpleList<T> {
    public int size();

    public void clear();

    public String insertAtNext(T data);

    public int find(T data);

}
