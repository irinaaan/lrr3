import java.sql.*;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            String url = "jdbc:mysql://localhost/supermarket?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
            String username = "root";
            String password = "123456789";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                tableLoop:
                while (true) {
                    System.out.println("Выберите таблицу:");
                    System.out.println("1. Products");
                    System.out.println("2. Clients");
                    System.out.println("3. Workers");
                    System.out.println("4. Orders");
                    System.out.println("0. Выход");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1: {
                            // Обработка выбора таблицы Products
                            while (true) {
                                System.out.println("Выберите действие:");
                                System.out.println("1. Добавить новый продукт");
                                System.out.println("2. Изменить продукт");
                                System.out.println("3. Удалить продукт");
                                System.out.println("4. Просмотр всех продуктов");
                                System.out.println("0. Вернуться к выбору таблицы");

                                int action = scanner.nextInt();

                                switch (action) {
                                    case 1:
                                        // Добавление нового продукта
                                        System.out.println("Введите название продукта:");
                                        String name = scanner.next();
                                        System.out.println("Введите описание продукта:");
                                        String description = scanner.next();
                                        System.out.println("Введите цену продукта:");
                                        int price = scanner.nextInt();

                                        String insertSql = "INSERT INTO products (Name, Description, Price) VALUES (?, ?, ?)";
                                        PreparedStatement insertStatement = conn.prepareStatement(insertSql);
                                        insertStatement.setString(1, name);
                                        insertStatement.setString(2, description);
                                        insertStatement.setInt(3, price);
                                        insertStatement.executeUpdate();
                                        System.out.println("Продукт успешно добавлен.\n");
                                        break;

                                    case 2:
                                        // Изменение продукта
                                        System.out.println("Введите ID продукта, который вы хотите изменить:");
                                        int idToUpdate = scanner.nextInt();
                                        System.out.println("Введите новое название продукта:");
                                        String newName = scanner.next();
                                        System.out.println("Введите новое описание продукта:");
                                        String newDescription = scanner.next();
                                        System.out.println("Введите новую цену продукта:");
                                        int newPrice = scanner.nextInt();

                                        String updateSql = "UPDATE products SET Name = ?, Description = ?, Price = ? WHERE IdProducts = ?";
                                        PreparedStatement updateStatement = conn.prepareStatement(updateSql);
                                        updateStatement.setString(1, newName);
                                        updateStatement.setString(2, newDescription);
                                        updateStatement.setInt(3, newPrice);
                                        updateStatement.setInt(4, idToUpdate);

                                        int rowsAffected = updateStatement.executeUpdate();
                                        if (rowsAffected > 0) {
                                            System.out.println("Продукт успешно изменен.\n");
                                        } else {
                                            System.out.println("Продукт с таким ID не найден.\n");
                                        }
                                        break;

                                    case 3:
                                        // Удаление продукта
                                        System.out.println("Введите ID продукта, который вы хотите удалить:");
                                        int idToDelete = scanner.nextInt();

                                        String deleteSql = "DELETE FROM products WHERE IdProducts = ?";
                                        PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
                                        deleteStatement.setInt(1, idToDelete);
                                        rowsAffected = deleteStatement.executeUpdate();
                                        if (rowsAffected > 0) {
                                            System.out.println("Продукт успешно удален.\n");
                                        } else {
                                            System.out.println("Продукт с таким ID не найден.\n");
                                        }
                                        break;

                                    case 4:
                                        // Просмотр всех элементов таблицы
                                        String selectSql = "SELECT * FROM products";
                                        ResultSet resultSet = statement.executeQuery(selectSql);
                                        while (resultSet.next()) {
                                            int id = resultSet.getInt("IdProducts");
                                            String productname = resultSet.getString("Name");
                                            String descriptionn = resultSet.getString("Description");
                                            int pricee = resultSet.getInt("Price");
                                            System.out.printf("%d\t%s\t%s\t%d%n", id, productname, descriptionn, pricee);
                                        }
                                        System.out.printf("\n");
                                        break;

                                    case 0:
                                        // Возврат к выбору таблицы
                                        continue tableLoop;
                                    default:
                                        System.out.println("Некорректный ввод.");
                                        break;
                                }
                            }
                        }

                        case 2:  {
                            // Обработка выбора таблицы Clients
                            while (true) {
                                System.out.println("Выберите действие:");
                                System.out.println("1. Добавить нового клиента");
                                System.out.println("2. Изменить данные клиента");
                                System.out.println("3. Удалить клиента");
                                System.out.println("4. Просмотр всех клиентов");
                                System.out.println("0. Вернуться к выбору таблицы");

                                int action = scanner.nextInt();

                                switch (action) {
                                    case 1:
                                        // Добавление нового клиента
                                        System.out.println("Введите имя клиента:");
                                        String name = scanner.next();
                                        System.out.println("Введите фамилию клиента:");
                                        String surname = scanner.next();
                                        System.out.println("Введите номер телефона клиента:");
                                        String phonenumber = scanner.next();
                                        System.out.println("Введите город, где живет клиент:");
                                        String city = scanner.next();
                                        System.out.println("Введите страну, где живет клиент:");
                                        String country = scanner.next();

                                        String insertSql = "INSERT INTO clients (Name, Surname, `Phone number`, City, Country) VALUES (?, ?, ?, ?, ?)";
                                        PreparedStatement insertStatement = conn.prepareStatement(insertSql);
                                        insertStatement.setString(1, name);
                                        insertStatement.setString(2, surname);
                                        insertStatement.setString(3, phonenumber);
                                        insertStatement.setString(4, city);
                                        insertStatement.setString(5, country);
                                        insertStatement.executeUpdate();
                                        System.out.println("Клиент успешно добавлен.\n");
                                        break;

                                    case 2:
                                        // Изменение данных клиента
                                        System.out.println("Введите ID клиента, данные которого вы хотите изменить:");
                                        int idToUpdate = scanner.nextInt();
                                        System.out.println("Введите новое имя клиента:");
                                        String newName = scanner.next();
                                        System.out.println("Введите новую фамилию клиента:");
                                        String newSurname = scanner.next();
                                        System.out.println("Введите новый номер телефона клиента:");
                                        String newPhonenumber = scanner.next();
                                        System.out.println("Введите город, где живет клиент:");
                                        String newCity = scanner.next();
                                        System.out.println("Введите страну, где живет клиент:");
                                        String newCountry = scanner.next();

                                        String updateSql = "UPDATE clients SET Name = ?, Surname = ?, `Phone number` = ?, City = ?, Country = ? WHERE IdClients = ?";
                                        PreparedStatement updateStatement = conn.prepareStatement(updateSql);
                                        updateStatement.setString(1, newName);
                                        updateStatement.setString(2, newSurname);
                                        updateStatement.setString(3, newPhonenumber);
                                        updateStatement.setString(4, newCity);
                                        updateStatement.setString(5, newCountry);
                                        updateStatement.setInt(6, idToUpdate);

                                        int rowsAffected = updateStatement.executeUpdate();
                                        if (rowsAffected > 0) {
                                            System.out.println("Данные клиента успешно изменены.\n");
                                        } else {
                                            System.out.println("Клиент с таким ID не найден.\n");
                                        }
                                        break;

                                    case 3:
                                        // Удаление клиента
                                        System.out.println("Введите ID клиента, которого вы хотите удалить:");
                                        int idToDelete = scanner.nextInt();

                                        String deleteSql = "DELETE FROM clients WHERE IdClients = ?";
                                        PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
                                        deleteStatement.setInt(1, idToDelete);
                                        rowsAffected = deleteStatement.executeUpdate();
                                        if (rowsAffected > 0) {
                                            System.out.println("Клиент успешно удален.\n");
                                        } else {
                                            System.out.println("Клиент с таким ID не найден.\n");
                                        }
                                        break;

                                    case 4:
                                        // Просмотр всех элементов таблицы
                                        String selectSql = "SELECT * FROM clients";
                                        ResultSet resultSet = statement.executeQuery(selectSql);
                                        while (resultSet.next()) {
                                            int id = resultSet.getInt("IdClients");
                                            String n = resultSet.getString("Name");
                                            String s = resultSet.getString("Surname");
                                            String pn = resultSet.getString("Phone number");
                                            String ci = resultSet.getString("City");
                                            String co = resultSet.getString("Country");
                                            System.out.printf("%d\t%s\t%s\t%s\t%s\t%s%n", id, n, s, pn, ci, co);
                                        }
                                        System.out.printf("\n");
                                        break;

                                    case 0:
                                        // Возврат к выбору таблицы
                                        continue tableLoop;

                                    default:
                                        System.out.println("Некорректный ввод.");
                                        break;
                                }
                            }
                        }

                        case 3: {
                            // Обработка выбора таблицы Workers
                            while (true) {
                                System.out.println("Выберите действие:");
                                System.out.println("1. Добавить нового работника");
                                System.out.println("2. Изменить работника");
                                System.out.println("3. Удалить работника");
                                System.out.println("4. Просмотр всех работников");
                                System.out.println("0. Вернуться к выбору таблицы");

                                int action = scanner.nextInt();

                                switch (action) {
                                    case 1:
                                        // Добавление нового работника
                                        System.out.println("Введите имя работника:");
                                        String name = scanner.next();
                                        System.out.println("Введите фамилию работника:");
                                        String surname = scanner.next();
                                        System.out.println("Введите должность работника:");
                                        String position = scanner.next();
                                        System.out.println("Введите дату принятия на работу работника:");
                                        String employment = scanner.next();

                                        String insertSql = "INSERT INTO workers (Name, Surname, Position, `Date of employment`) VALUES (?, ?, ?, ?)";
                                        PreparedStatement insertStatement = conn.prepareStatement(insertSql);
                                        insertStatement.setString(1, name);
                                        insertStatement.setString(2, surname);
                                        insertStatement.setString(3, position);
                                        insertStatement.setString(4, employment);
                                        insertStatement.executeUpdate();
                                        System.out.println("Работник успешно добавлен.\n");
                                        break;

                                    case 2:
                                        // Изменение работника
                                        System.out.println("Введите ID работника, которого вы хотите изменить:");
                                        int idToUpdate = scanner.nextInt();
                                        System.out.println("Введите имя работника:");
                                        String newName = scanner.next();
                                        System.out.println("Введите фамилию работника:");
                                        String newSurname = scanner.next();
                                        System.out.println("Введите должность работника:");
                                        String newPosition = scanner.next();
                                        System.out.println("Введите дату принятия на работу работника:");
                                        String newEmployment = scanner.next();

                                        String updateSql = "UPDATE workers SET Name = ?, Surname = ?, Position = ?, `Date of employment` = ? WHERE IdWorkers = ?";
                                        PreparedStatement updateStatement = conn.prepareStatement(updateSql);
                                        updateStatement.setString(1, newName);
                                        updateStatement.setString(2, newSurname);
                                        updateStatement.setString(3, newPosition);
                                        updateStatement.setString(4, newEmployment);
                                        updateStatement.setInt(5, idToUpdate);

                                        int rowsAffected = updateStatement.executeUpdate();
                                        if (rowsAffected > 0) {
                                            System.out.println("Работник успешно изменен.\n");
                                        } else {
                                            System.out.println("Работник с таким ID не найден.\n");
                                        }
                                        break;

                                    case 3:
                                        // Удаление работника
                                        System.out.println("Введите ID работника, которого вы хотите удалить:");
                                        int idToDelete = scanner.nextInt();

                                        String deleteSql = "DELETE FROM workers WHERE IdWorkers = ?";
                                        PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
                                        deleteStatement.setInt(1, idToDelete);
                                        rowsAffected = deleteStatement.executeUpdate();
                                        if (rowsAffected > 0) {
                                            System.out.println("Работник успешно удален.\n");
                                        } else {
                                            System.out.println("Работник с таким ID не найден.\n");
                                        }
                                        break;

                                    case 4:
                                        // Просмотр всех элементов таблицы
                                        String selectSql = "SELECT * FROM workers";
                                        ResultSet resultSet = statement.executeQuery(selectSql);
                                        while (resultSet.next()) {
                                            int id = resultSet.getInt("IdWorkers");
                                            String n = resultSet.getString("Name");
                                            String s = resultSet.getString("Surname");
                                            String p = resultSet.getString("Position");
                                            String e = resultSet.getString("Date of employment");
                                            System.out.printf("%d\t%s\t%s\t%s\t%s%n", id, n, s, p, e);
                                        }
                                        System.out.printf("\n");
                                        break;

                                    case 0:
                                        // Возврат к выбору таблицы
                                        continue tableLoop;
                                    default:
                                        System.out.println("Некорректный ввод.");
                                        break;
                                }
                            }
                        }

                        case 4: {
                            // Обработка выбора таблицы Orders
                            while (true) {
                                System.out.println("Выберите действие:");
                                System.out.println("1. Добавить новый заказ");
                                System.out.println("2. Изменить заказ");
                                System.out.println("3. Удалить заказ");
                                System.out.println("4. Просмотр всех заказов");
                                System.out.println("0. Вернуться к выбору таблицы");

                                int action = scanner.nextInt();

                                switch (action) {
                                    case 1:
                                        // Добавление нового заказа
                                        System.out.println("Введите название продукта:");
                                        String productname = scanner.next();
                                        System.out.println("Введите id клиента:");
                                        int idClients = scanner.nextInt();
                                        System.out.println("Введите дату:");
                                        String date = scanner.next();
                                        System.out.println("Введите сумму:");
                                        double sum = scanner.nextDouble();

                                        String insertSql = "INSERT INTO orders (`The product's name`, Date, IdClients, Sum) VALUES (?, ?, ?, ?)";
                                        PreparedStatement insertStatement = conn.prepareStatement(insertSql);
                                        insertStatement.setString(1, productname);
                                        insertStatement.setString(2, date);
                                        insertStatement.setInt(3, idClients);
                                        insertStatement.setDouble(4, sum);
                                        insertStatement.executeUpdate();
                                        System.out.println("Заказ успешно добавлен.\n");
                                        break;

                                    case 2:
                                        // Изменение заказа
                                        System.out.println("Введите ID заказа, который вы хотите изменить:");
                                        int idToUpdate = scanner.nextInt();
                                        System.out.println("Введите название продукта:");
                                        String newProductname = scanner.next();
                                        System.out.println("Введите id клиента:");
                                        int newIdClients = scanner.nextInt();
                                        System.out.println("Введите дату:");
                                        String newDate = scanner.next();
                                        System.out.println("Введите сумму:");
                                        double newSum = scanner.nextDouble();

                                        String updateSql = "UPDATE orders SET `The product's name` = ?, Date = ?, IdClients = ?, Sum = ? WHERE IdOrders = ?";
                                        PreparedStatement updateStatement = conn.prepareStatement(updateSql);
                                        updateStatement.setString(1, newProductname);
                                        updateStatement.setString(2, newDate);
                                        updateStatement.setInt(3, newIdClients);
                                        updateStatement.setDouble(4, newSum);
                                        updateStatement.setInt(5, idToUpdate);

                                        int rowsAffected = updateStatement.executeUpdate();
                                        if (rowsAffected > 0) {
                                            System.out.println("Заказ успешно изменен.\n");
                                        } else {
                                            System.out.println("Заказ с таким ID не найден.\n");
                                        }
                                        break;

                                    case 3:
                                        // Удаление заказа
                                        System.out.println("Введите ID заказа, который вы хотите удалить:");
                                        int idToDelete = scanner.nextInt();

                                        String deleteSql = "DELETE FROM orders WHERE IdOrders = ?";
                                        PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
                                        deleteStatement.setInt(1, idToDelete);
                                        rowsAffected = deleteStatement.executeUpdate();
                                        if (rowsAffected > 0) {
                                            System.out.println("Заказ успешно удален.\n");
                                        } else {
                                            System.out.println("Заказ с таким ID не найден.\n");
                                        }
                                        break;

                                    case 4:
                                        // Просмотр всех элементов таблицы
                                        String selectSql = "SELECT * FROM orders";
                                        ResultSet resultSet = statement.executeQuery(selectSql);
                                        while (resultSet.next()) {
                                            int id = resultSet.getInt("IdClients");
                                            String n = resultSet.getString("The product's name");
                                            String s = resultSet.getString("Date");
                                            int ic = resultSet.getInt("IdClients");
                                            double su = resultSet.getDouble("Sum");
                                            System.out.printf("%d\t%s\t%s\t%d\t%.2f%n", id, n, s, ic, su);
                                        }
                                        System.out.printf("\n");
                                        break;

                                    case 0:
                                        // Возврат к выбору таблицы
                                        continue tableLoop;
                                    default:
                                        System.out.println("Некорректный ввод.");
                                        break;
                                }
                            }
                        }

                        case 0:
                            System.out.println("Выход из программы.");
                            return;

                        default:
                            System.out.println("Некорректный ввод.");
                            break;
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}