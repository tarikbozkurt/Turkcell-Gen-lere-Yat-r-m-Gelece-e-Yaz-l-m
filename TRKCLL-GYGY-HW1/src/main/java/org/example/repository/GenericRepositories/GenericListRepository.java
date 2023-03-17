package org.example.repository.GenericRepositories;

import org.example.entity.BaseEntity.BaseEntity;

import java.util.List;
import java.util.Objects;

public class GenericListRepository <T extends BaseEntity<PK>, PK extends Object>  implements GenericRepository<T,PK>{

    private List<T> database;

    public GenericListRepository(List<T> database) {
        this.database = database;
    }

    @Override
    public T getById(PK id) {
        for (T t : database) {

            if(t.getId().equals(id)){
                return t;
            }

        }
        return null;
    }

    @Override
    public void create(T entity) {

        database.add(entity);

    }

    @Override
    public void update(T entity) {

        for (T t : database) {

            if(t.getId().equals(entity.getId())){

                t = entity;// just try it
            }

        }
        //
    }

    @Override
    public void delete(T entity) {

        for (T t : database) {

            if(t.getId().equals(entity.getId()))
            {
                System.out.println("Deleted : " + t);
                database.remove(t);
                return;
                }


        }


    }

    @Override
    public List<T> getAll() {
        return database;
    }
}
