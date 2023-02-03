import dto.CategoryInsert;
import dto.CategoryItem;
import dto.CategoryService;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String conn = "jdbc:mariadb://localhost:3306/java"; // connection to database
        String user = "root";
        String password = "";
        CategoryService service = new CategoryService(conn, user, password); // init services for work with categories

        while (true) {
            int index = 0;
            Scanner input = new Scanner(System.in);

            System.out.println("[" + ++index + "] Insert");
            System.out.println("[" + ++index + "] Update");
            System.out.println("[" + ++index + "] Get all");
            System.out.println("[" + ++index + "] Delete by id");
            System.out.print(Color.RED);
            System.out.println("[" + ++index + "] Exit");
            System.out.print(Color.RESET);

            System.out.print("Enter index to select action:");
            int selectedIndex = input.nextInt();

            switch (selectedIndex) {
                case 1: // inserting new item in database
                    System.out.print("Enter name of new item: ");
                    Scanner scanNewName = new Scanner(System.in);
                    String name = scanNewName.nextLine();

                    service.insert(new CategoryInsert(name));

                    stop(); // shows massage DONE ! and program stop until user click on some key
                    break;

                case 2:  // updating item by id
                    System.out.print("Enter id of item:");
                    Scanner scanId = new Scanner(System.in);
                    int id = scanId.nextInt();

                    System.out.print("Enter new name: ");
                    Scanner scanName = new Scanner(System.in);
                    String newName = scanName.nextLine();

                    service.update(new CategoryItem(id, newName));

                    stop();
                    break;

                case 3:
                    List<CategoryItem> items = service.getAll();
                    for (CategoryItem item : items) System.out.println(item);

                    stop();
                    break;

                case 4:
                    System.out.print("Enter id:");
                    int deleteId = input.nextInt();
                    service.delete(deleteId);

                    stop();
                    break;

                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void sortArr() {
        Person[] list = {
                new Person("Orest", "Jakovich"),
                new Person("Kolya", "Rlff"),
                new Person("Artur", "test")
        };
        for (Person item : list) System.out.print(item);

        Arrays.sort(list);

        System.out.println("\nsorted: ");
        for (Person item : list) {
            System.out.print(item);
        }
    }

    private static int getRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static void inputData() {
        Scanner input = new Scanner(System.in);
        int w = input.nextInt();
        System.out.println(w);
    }
    private static void stop(){
        System.out.print(Color.GREEN);
        System.out.println("Done !");
        System.out.print(Color.RESET); // shows a message that the operation was successfully processed

        Scanner stopper = new Scanner(System.in);
        String tmp = stopper.nextLine(); // waiting until user click on some key
    }
    enum Color { // enum for beautiful colors in console
        //Color end string, color reset
        RESET("\033[0m"),

        // Regular Colors. Normal color, no bold, background color etc.
        BLACK("\033[0;30m"),    // BLACK
        RED("\033[0;31m"),      // RED
        GREEN("\033[0;32m"),    // GREEN
        YELLOW("\033[0;33m"),   // YELLOW
        BLUE("\033[0;34m"),     // BLUE
        MAGENTA("\033[0;35m"),  // MAGENTA
        CYAN("\033[0;36m"),     // CYAN
        WHITE("\033[0;37m"),    // WHITE

        // Bold
        BLACK_BOLD("\033[1;30m"),   // BLACK
        RED_BOLD("\033[1;31m"),     // RED
        GREEN_BOLD("\033[1;32m"),   // GREEN
        YELLOW_BOLD("\033[1;33m"),  // YELLOW
        BLUE_BOLD("\033[1;34m"),    // BLUE
        MAGENTA_BOLD("\033[1;35m"), // MAGENTA
        CYAN_BOLD("\033[1;36m"),    // CYAN
        WHITE_BOLD("\033[1;37m"),   // WHITE

        // Underline
        BLACK_UNDERLINED("\033[4;30m"),     // BLACK
        RED_UNDERLINED("\033[4;31m"),       // RED
        GREEN_UNDERLINED("\033[4;32m"),     // GREEN
        YELLOW_UNDERLINED("\033[4;33m"),    // YELLOW
        BLUE_UNDERLINED("\033[4;34m"),      // BLUE
        MAGENTA_UNDERLINED("\033[4;35m"),   // MAGENTA
        CYAN_UNDERLINED("\033[4;36m"),      // CYAN
        WHITE_UNDERLINED("\033[4;37m"),     // WHITE

        // Background
        BLACK_BACKGROUND("\033[40m"),   // BLACK
        RED_BACKGROUND("\033[41m"),     // RED
        GREEN_BACKGROUND("\033[42m"),   // GREEN
        YELLOW_BACKGROUND("\033[43m"),  // YELLOW
        BLUE_BACKGROUND("\033[44m"),    // BLUE
        MAGENTA_BACKGROUND("\033[45m"), // MAGENTA
        CYAN_BACKGROUND("\033[46m"),    // CYAN
        WHITE_BACKGROUND("\033[47m"),   // WHITE

        // High Intensity
        BLACK_BRIGHT("\033[0;90m"),     // BLACK
        RED_BRIGHT("\033[0;91m"),       // RED
        GREEN_BRIGHT("\033[0;92m"),     // GREEN
        YELLOW_BRIGHT("\033[0;93m"),    // YELLOW
        BLUE_BRIGHT("\033[0;94m"),      // BLUE
        MAGENTA_BRIGHT("\033[0;95m"),   // MAGENTA
        CYAN_BRIGHT("\033[0;96m"),      // CYAN
        WHITE_BRIGHT("\033[0;97m"),     // WHITE

        // Bold High Intensity
        BLACK_BOLD_BRIGHT("\033[1;90m"),    // BLACK
        RED_BOLD_BRIGHT("\033[1;91m"),      // RED
        GREEN_BOLD_BRIGHT("\033[1;92m"),    // GREEN
        YELLOW_BOLD_BRIGHT("\033[1;93m"),   // YELLOW
        BLUE_BOLD_BRIGHT("\033[1;94m"),     // BLUE
        MAGENTA_BOLD_BRIGHT("\033[1;95m"),  // MAGENTA
        CYAN_BOLD_BRIGHT("\033[1;96m"),     // CYAN
        WHITE_BOLD_BRIGHT("\033[1;97m"),    // WHITE

        // High Intensity backgrounds
        BLACK_BACKGROUND_BRIGHT("\033[0;100m"),     // BLACK
        RED_BACKGROUND_BRIGHT("\033[0;101m"),       // RED
        GREEN_BACKGROUND_BRIGHT("\033[0;102m"),     // GREEN
        YELLOW_BACKGROUND_BRIGHT("\033[0;103m"),    // YELLOW
        BLUE_BACKGROUND_BRIGHT("\033[0;104m"),      // BLUE
        MAGENTA_BACKGROUND_BRIGHT("\033[0;105m"),   // MAGENTA
        CYAN_BACKGROUND_BRIGHT("\033[0;106m"),      // CYAN
        WHITE_BACKGROUND_BRIGHT("\033[0;107m");     // WHITE

        private final String code;

        Color(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }
}