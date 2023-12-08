package homework5.repository;

import homework5.model.Team;

import java.util.List;

public interface TeamRepository <T extends Team> {
    List<T> getAll();
    void add(T t);
    void remove(String teamName);
    Long getMaxId();
}
