package pe.faro.service;

import java.util.List;

public interface Service<T> {
	
	public boolean insert(T obj);
	public List<T> getall();
	public boolean update(T obj);
	public boolean delete(int id);
	
}
