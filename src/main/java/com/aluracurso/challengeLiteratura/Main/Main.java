package com.aluracurso.challengeLiteratura.Main;

import com.aluracurso.challengeLiteratura.models.Data;
import com.aluracurso.challengeLiteratura.models.DataBook;
import com.aluracurso.challengeLiteratura.services.ApiClient;
import com.aluracurso.challengeLiteratura.services.DataConverter;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final String URL_API = "https://gutendex.com/books/";
    private ApiClient apiClient = new ApiClient();
    private Scanner input = new Scanner(System.in);
    private DataConverter converter = new DataConverter();

    public void showMenu() {
        var option = -1;
        while(option != 0) {
            var menu = """
                     \n####### Menú #######
                     \n1 - Buscar libro
                     
                     0 - Salir
                    """;

            System.out.println(menu);
            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    searchBooks();
                break;

                case 0:
                    System.out.println("Cerrando aplicacion...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        }
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
        } else {
            System.out.println("El libro " + book + " no se ha podido encontrar");
        }
        return null;
    }
}
