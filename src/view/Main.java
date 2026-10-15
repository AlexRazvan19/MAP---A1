package view;

import controller.Controller;
import model.AppleTree;
import model.CherryTree;
import model.FruitTree;
import model.PearTree;
import repository.IRepository;
import repository.Repository;
import repository.RepositoryException;


public class Main {
    public static void main(String[] args) {
        IRepository repository = new Repository(10);
        Controller controller = new Controller(repository);

        System.out.println("=== Orchard - Fruit trees older than 3 years ===\n");

        try {
            controller.addTree(new AppleTree(5));
            controller.addTree(new PearTree(2));
            controller.addTree(new CherryTree(7));
            controller.addTree(new AppleTree(3));
            controller.addTree(new PearTree(10));
            controller.addTree(new CherryTree(1));

            System.out.println("All trees in the orchard:");
            printTrees(controller.getAllTrees());

            System.out.println("\nTrees older than 3 years:");
            printTrees(controller.getTreesOlderThanThreeYears());

            System.out.println("\nRemoving tree at index 1 (PearTree age 2)...");
            controller.removeTree(1);

            System.out.println("All trees after removal:");
            printTrees(controller.getAllTrees());

            System.out.println("\nTrees older than 3 years after removal:");
            printTrees(controller.getTreesOlderThanThreeYears());

            System.out.println("\nTrying to remove at invalid index 99...");
            controller.removeTree(99);

        } catch (RepositoryException e) {
            System.out.println("Repository error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid argument: " + e.getMessage());
        }
        try {
            System.out.println("\nFilling a small repository to capacity...");
            IRepository smallRepo = new Repository(2);
            Controller smallController = new Controller(smallRepo);
            smallController.addTree(new AppleTree(4));
            smallController.addTree(new PearTree(6));
            smallController.addTree(new CherryTree(8)); // should fail
        } catch (RepositoryException e) {
            System.out.println("Repository error: " + e.getMessage());
        }

        try {
            System.out.println("\nTrying to create a tree with negative age...");
            new CherryTree(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid argument: " + e.getMessage());
        }
    }

    private static void printTrees(FruitTree[] trees) {
        if (trees.length == 0) {
            System.out.println("  (none)");
            return;
        }
        for (int i = 0; i < trees.length; i++) {
            System.out.println("  [" + i + "] " + trees[i].getType() + " tree, age " + trees[i].getAge());
        }
    }
}
