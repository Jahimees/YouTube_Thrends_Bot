package dao;

import entity.Entity;

public interface DAO {

    Entity get(int id);
    boolean create(Entity entity);
    boolean delete(Entity entity);
    boolean update(Entity entity);
}
