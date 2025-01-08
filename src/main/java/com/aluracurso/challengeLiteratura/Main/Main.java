package com.aluracurso.challengeLiteratura.Main;

import com.aluracurso.challengeLiteratura.models.Book;
import com.aluracurso.challengeLiteratura.models.Data;
import com.aluracurso.challengeLiteratura.models.DataBook;
import com.aluracurso.challengeLiteratura.repository.BookRepository;
import com.aluracurso.challengeLiteratura.services.ApiClient;
import com.aluracurso.challengeLiteratura.services.DataConverter;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final String URL_API = "https://gutendex.com/books/";
    private ApiClient apiClient = new ApiClient();
    private Scanner input = new Scanner(System.in);
    private DataConverter converter = new DataConverter();
    private BookRepository repository;

    public Main(BookRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        var option = -1;
        while(option != 0) {
            var menu = """
                     \n####### Menú #######
                     \n1 - Buscar libro
                     2 - Ver lista de libros
                     
                     0 - Salir
                    """;

            System.out.println(menu);
            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    searchBooks();
                break;

                case 2:
                    showListBook();
                break;

                case 0:
                    System.out.println("Cerrando aplicacion...");
                break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        }
    }

    private void saveBook(DataBook dataBook) {
        Book book = new Book(dataBook);
        repository.save(book);
        System.out.println("Libro guardado exitosamente: " + book.getTitle());
    }


    private DataBook searchBooks() {
        System.out.println("¿Que libro desea buscar hoy?");
        var nameBook = input.nextLine();
        var json = apiClient.getData(URL_API + "?search=" + nameBook.replace(" ", "+"));

        var foundBook = converter.getData(json, Data.class);
        Optional<DataBook> book = foundBook.bookList().stream()
                .filter(b -> b.title().toUpperCase().contains(nameBook.toUpperCase()))
                .findFirst();

        if (book.isPresent()) {
            System.out.println("Su libro es: ");
            System.out.println(book.get());

            saveBook(book.get());
        } else {
            System.out.println("El libro " + book + " no se ha podido encontrar");
        }
        return null;
    }

    private void showListBook() {
        var books = repository.findAll();

        if (books.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos.");
        } else {
            System.out.println("####### Lista de Libros #######");
            books.forEach(book -> {
                System.out.println("Título: " + book.getTitle());
                System.out.println("Idiomas: " + book.getLanguages());
                System.out.println("Descargas: " + book.getDownloads());
                System.out.println("-------------------------");
            });
        }
    }
}
