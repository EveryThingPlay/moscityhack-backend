package mch.subschool.backend.repository;

public interface DashboardRepository<T> {
    String save(T model);
    T findById(String id);
}
