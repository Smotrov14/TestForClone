import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        TrucksAndContainers boxCount = new TrucksAndContainers(Integer.parseInt(boxes));
        boxCount.printInfo();

    }

}
