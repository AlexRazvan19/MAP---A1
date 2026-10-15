package controller;

import model.FruitTree;
import repository.IRepository;
import repository.RepositoryException;


public class Controller {
    private static final int MIN_AGE = 3;

    private final IRepository repository;

    public Controller(IRepository repository) {
        if (repository == null) {
            throw new IllegalArgumentException("Repository cannot be null.");
        }
        this.repository = repository;
    }

    public void addTree(FruitTree tree) throws RepositoryException {
        repository.add(tree);
    }

    public void removeTree(int index) throws RepositoryException {
        repository.remove(index);
    }

    public FruitTree[] getAllTrees() {
        return repository.getAll();
    }

    /**
     * Main problem functionality: return all fruit trees older than 3 years.
     */
    public FruitTree[] getTreesOlderThanThreeYears() {
        FruitTree[] all = repository.getAll();
        int count = 0;
        for (FruitTree tree : all) {
            if (tree.isOlderThan(MIN_AGE)) {
                count++;
            }
        }

        FruitTree[] older = new FruitTree[count];
        int index = 0;
        for (FruitTree tree : all) {
            if (tree.isOlderThan(MIN_AGE)) {
                older[index++] = tree;
            }
        }
        return older;
    }

    public int size() {
        return repository.size();
    }
}
