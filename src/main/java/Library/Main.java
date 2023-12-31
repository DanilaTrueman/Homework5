package Library;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookCatalog catalog = new BookCatalog();

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Удалить книгу");
            System.out.println("3. Поиск книги");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите id: ");
                    int id = 0;
                    boolean idIsValid = false;
                    while (!idIsValid) {
                        if (scanner.hasNextInt()) {
                            id = scanner.nextInt();
                            scanner.nextLine();
                            boolean idExists = false;
                            for (Book book : catalog.getBooks()) {
                                if (book.getId() == id) {
                                    idExists = true;
                                    break;
                                }
                            }
                            if (idExists) {
                                System.out.println("Книга с таким id уже существует. Пожалуйста, введите другой id.");
                                System.out.print("Введите id: ");
                            } else {
                                idIsValid = true;
                            }
                        } else {
                            System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                            scanner.nextLine();
                            System.out.print("Введите id: ");
                        }
                    }

                    System.out.print("Введите название: ");
                    String title = scanner.nextLine();

                    System.out.print("Введите жанр: ");
                    String genre = scanner.nextLine();

                    System.out.print("Введите имя и фамилию автора: ");
                    String author = scanner.nextLine();

                    System.out.print("Введите год издания: ");
                    int year = 0;
                    boolean yearIsValid = false;
                    while (!yearIsValid) {
                        if (scanner.hasNextInt()) {
                            year = scanner.nextInt();
                            scanner.nextLine();
                            yearIsValid = true;
                        } else {
                            System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                            scanner.nextLine();
                            System.out.print("Введите год издания: ");
                        }
                    }

                    System.out.print("Введите краткое описание: ");
                    String description = scanner.nextLine();

                    Book newBook = new Book(id, title, genre, author, year, description);
                    catalog.addBook(newBook);

                    System.out.println("Книга добавлена!");
                    break;

                case 2:
                    System.out.print("Введите id книги для удаления: ");
                    int idToRemove = scanner.nextInt();
                    catalog.removeBook(idToRemove);
                    System.out.println("Книга удалена, если она существовала.");
                    break;

                case 3:
                    System.out.println("Выберите тип поиска:");
                    System.out.println("1. По названию");
                    System.out.println("2. По жанру");
                    System.out.println("3. По автору");
                    System.out.println("4. По году издания");

                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (searchChoice) {
                        case 1:
                            System.out.print("Введите название: ");
                            String searchTitle = scanner.nextLine();
                            List<Book> titleResults = catalog.searchByTitle(searchTitle);
                            for (Book book : titleResults) {
                                System.out.println(book.getTitle() + " - " + book.getAuthor());
                            }
                            break;

                        case 2:
                            System.out.print("Введите жанр: ");
                            String searchGenre = scanner.nextLine();
                            List<Book> genreResults = catalog.searchByGenre(searchGenre);
                            for (Book book : genreResults) {
                                System.out.println(book.getTitle() + " - " + book.getAuthor());
                            }
                            break;

                        case 3:
                            System.out.print("Введите имя автора: ");
                            String searchAuthor = scanner.nextLine();
                            List<Book> authorResults = catalog.searchByAuthor(searchAuthor);
                            for (Book book : authorResults) {
                                System.out.println(book.getTitle() + " - " + book.getAuthor());
                            }
                            break;

                        case 4:
                            System.out.print("Введите год издания: ");
                            int searchYear = scanner.nextInt();
                            List<Book> yearResults = catalog.searchByYear(searchYear);
                            for (Book book : yearResults) {
                                System.out.println(book.getTitle() + " - " + book.getAuthor());
                            }
                            break;

                        default:
                            System.out.println("Неверный выбор.");
                    }
                    break;

                case 4:
                    System.out.println("Выход из приложения.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неверный выбор.");
                    break;
            }
        }
    }
}