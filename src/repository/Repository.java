package repository;

import model.FruitTree;

/**
 * In-memory repository implemented with a fixed-size array.
 */
public class Repository implements IRepository {
    private final FruitTree[] trees;
    private int size;

    public Repository(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.trees = new FruitTree[capacity];
        this.size = 0;
    }

    @Override
    public void add(FruitTree tree) throws RepositoryException {
        if (tree == null) {
            throw new RepositoryException("Cannot add a null tree.");
        }
        if (size >= trees.length) {
            throw new RepositoryException("Repository is full. Cannot add more trees.");
        }
        trees[size++] = tree;
    }

    @Override
    public void remove(int index) throws RepositoryException {
        if (index < 0 || index >= size) {
            throw new RepositoryException("Invalid index: " + index + ". Valid range is 0.." + (size - 1) + ".");
        }
        for (int i = index; i < size - 1; i++) {
            trees[i] = trees[i + 1];
        }
        trees[size - 1] = null;
        size--;
    }

    @Override
    public FruitTree[] getAll() {
        FruitTree[] result = new FruitTree[size];
        for (int i = 0; i < size; i++) {
            result[i] = trees[i];
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }
}
