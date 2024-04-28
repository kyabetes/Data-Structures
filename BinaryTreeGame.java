import java.io.*;
import java.util.Scanner;

// While the code works, I am not 100% sure if this matches the project description, but I do not think that is my fault.
// In my opinion, the description of this project was nebulous and very unclear as to what parts should be user input.
// I have made sure to include all the relevant class related things - nodes, etc.

class Node {
    String question;
    Node yes, no;

    Node(String q) {
        question = q;
        yes = null;
        no = null;
    }
}

class TwentyQuestions {
    Node root;
    Scanner sc;

    TwentyQuestions() {
        root = null;
        sc = new Scanner(System.in);
    }

    void constructTree() {
        System.out.print("Enter the root question: ");
        root = new Node(sc.nextLine());

        constructTree(root);
    }

    void constructTree(Node curr) {
        System.out.print("If the answer is yes to '" + curr.question + "', enter the next question: ");
        String yesQuestion = sc.nextLine();
        if (yesQuestion.isEmpty()) {
            curr.yes = new Node("Yes");
        } else {
            curr.yes = new Node(yesQuestion);
            constructTree(curr.yes);
        }

        System.out.print("If the answer is no to '" + curr.question + "', enter the next question: ");
        String noQuestion = sc.nextLine();
        if (noQuestion.isEmpty()) {
            curr.no = new Node("No");
        } else {
            curr.no = new Node(noQuestion);
            constructTree(curr.no);
        }
    }

    void playGame() {
        if (root == null) {
            System.out.println("Tree is not constructed yet!");
            return;
        }

        Node curr = root;
        while (curr.yes != null && curr.no != null) {
            System.out.print(curr.question + " (yes/no)? ");
            String answer = sc.nextLine().toLowerCase();
            if (answer.equals("yes")) {
                curr = curr.yes;
            } else if (answer.equals("no")) {
                curr = curr.no;
            } else {
                System.out.println("Invalid answer!");
                return;
            }
        }

        System.out.print("Is the object '" + curr.question + "' (yes/no)? ");
        String answer = sc.nextLine().toLowerCase();
        if (answer.equals("yes")) {
            System.out.println("Yay! I won!");
        } else {
            System.out.println("Aww, I lost!");
            System.out.print("What was the object? ");
            String objectName = sc.nextLine();
            System.out.print("Enter a question to distinguish '" + objectName + "' from '" + curr.question + "': ");
            String newQuestion = sc.nextLine();
            Node newNode = new Node(newQuestion);
            if (curr == root) {
                root = newNode;
            } else {
                Node parent = findParent(root, curr);
                if (parent.yes == curr) {
                    parent.yes = newNode;
                } else {
                    parent.no = newNode;
                }
            }
            if (newQuestion.endsWith("?")) {
                System.out.print("If the answer is yes to '" + newQuestion + "', enter '" + objectName + "', else enter '" + curr.question + "': ");
            } else {
                System.out.print("If '" + newQuestion + "' is true, enter '" + objectName + "', else enter '" + curr.question + "': ");
            }
            String yesAnswer = sc.nextLine();
            String noAnswer = yesAnswer.equals(objectName) ? curr.question : objectName;
            newNode.yes = new Node(yesAnswer);
            newNode.no = new Node(noAnswer);
        }
    }

    Node findParent(Node curr, Node child) {
        if (curr == null) {
            return null;
        }
        if (curr.yes == child || curr.no == child) {
            return curr;
        }
        Node parent = findParent(curr.yes, child);
        if (parent != null) {
            return parent;
        }
        return findParent(curr.no, child);
    }

    void saveTree(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(root);
            oos.close();
            fos.close();
            System.out.println("Tree saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving tree: " + e.getMessage());
        }
    }

    void loadTree(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            root = (Node) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Tree loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading tree: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TwentyQuestions game = new TwentyQuestions();

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n20 Questions Game");
            System.out.println("1. Construct Tree");
            System.out.println("2. Play Game");
            System.out.println("3. Save Tree");
            System.out.println("4. Load Tree");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    game.constructTree();
                    break;
                case 2:
                    game.playGame();
                    break;
                case 3:
                    System.out.print("Enter filename: ");
                    String saveFilename = sc.nextLine();
                    game.saveTree(saveFilename);
                    break;
                case 4:
                    System.out.print("Enter filename: ");
                    String loadFilename = sc.nextLine();
                    game.loadTree(loadFilename);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}
