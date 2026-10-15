package repository;

import model.FruitTree;

public interface IRepository {
    void add(FruitTree tree) throws RepositoryException;

    void remove(int index) throws RepositoryException;

    FruitTree[] getAll();

    int size();
}
