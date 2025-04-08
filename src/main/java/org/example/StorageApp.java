package org.example;

import java.util.Optional;
import java.util.Scanner;


public class StorageApp {
    private final StorageService service = new StorageService();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n 1 - Сдать вещь\n 2 - Получить вещь\n 0 - Выход");
            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> handleStore();
                case "2" -> handleRetrieve();
                case "0" -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор.");
            }
        }
    }

    private void handleStore() {
        System.out.print("Введите код хранения: ");
        String code = scanner.nextLine();

        if (service.containsCode(code)) {
            System.out.print("Код уже существует. Перезаписать? (y/n): ");
            String confirm = scanner.nextLine();
            if (!confirm.equalsIgnoreCase("y")) {
                System.out.println("Операция отменена.");
                return;
            }
        }

        System.out.print("Введите описание вещи: ");
        String item = scanner.nextLine();

        boolean success = service.storeItem(code, item, true);
        if (success) {
            System.out.println("Вещь сохранена.");
        } else {
            System.out.println("Не удалось сохранить вещь.");
        }
    }

    private void handleRetrieve() {
        System.out.print("Введите код хранения: ");
        String code = scanner.nextLine();

        Optional<String> item = service.retrieveItem(code);
        if (item.isPresent()) {
            System.out.println("Ваша вещь: " + item.get());
        } else {
            System.out.println("Вещь по коду не найдена.");
        }
    }

    public static void main(String[] args) {
        new StorageApp().run();
    }
}
