package com.onlinesareeshoppingsystem;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.onlinesareesshopping.entities.Admin;
import com.onlinesareesshopping.entities.Customer;
import com.onlinesareesshopping.entities.Login;
import com.onlinesareesshopping.entities.Products;
import com.onlinesareesshopping.entities.Register;
import com.onlinesareesshoppingdao.Admindaoimpl;
import com.onlinesareesshoppingdao.Customerdaoimpl;
import com.onlinesareesshoppingdao.Logindaoimpl;
import com.onlinesareesshoppingdao.Productsdaoimpl;
import com.onlinesareesshoppingdao.Registerdaoimpl;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("Welcome to Online Sarees Shopping System!");
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

            
            SessionFactory sf = meta.getSessionFactoryBuilder().build();
            Session session = sf.openSession();
            Scanner scanner = new Scanner(System.in);
            int choice;

            Registerdaoimpl registerDao = new Registerdaoimpl(session);
            Admindaoimpl adminDao = new Admindaoimpl(session);
            Customerdaoimpl customerDao = new Customerdaoimpl(session);
            Logindaoimpl loginDao = new Logindaoimpl(session); // Create an instance of LoginDaoImpl
            Productsdaoimpl productDao = new Productsdaoimpl(session);
            do {
                System.out.println("Main-menu");
                System.out.println("1. Registration");
                System.out.println("2. Sign-in / Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        registrationMenu(scanner, registerDao, adminDao, customerDao);
                        break;
                    case 2:
                        login(scanner, loginDao, adminDao, customerDao); // Pass LoginDaoImpl instance to login method
                        break;
                    case 3:
                        System.out.println("Exiting the system. Thank you for using our service!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } while (choice != 3);

            scanner.close();
            session.close();
            sf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void login(Scanner scanner, Logindaoimpl loginDao, Admindaoimpl adminDao, Customerdaoimpl customerDao) {
        Login login = new Login();
        System.out.println("**************  LOGIN ************");
        System.out.println("Enter Email:");
        String email = scanner.next();
        login.setEmail(email);
        System.out.println("Enter Password:");
        String password = scanner.next();
        login.setPassword(password);

        // Attempt to log in as an admin or customer
        Admin loggedInAdmin = adminDao.getAdminByEmailAndPassword(email, password);
        if (loggedInAdmin != null) {
            System.out.println("Admin login successful!");
            adminMenu(loggedInAdmin, null, null);
        } else {
            Customer loggedInCustomer = customerDao.getCustomerByEmailAndPassword(email, password);
            if (loggedInCustomer != null) {
                System.out.println("Customer login successful!");
                customerMenu(loggedInCustomer);
            } else {
                System.out.println("Login failed. Invalid email or password.");
            }
        }
    }

    private static void customerMenu(Customer loggedInCustomer) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Session session = null;
        do {
            System.out.println("Customer Menu");
            System.out.println("1. View Products");
            System.out.println("2. Order Products");
            System.out.println("3. Place Order");
            System.out.println("4. Payment");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewProducts(session);
                    break;
                case 2:
                    orderProducts();
                    break;
                case 3:
                    placeOrder();
                    break;
                case 4:
                    makePayment();
                    break;
                
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (true);
    }

    private static void viewProducts(Session session) {
    	try {
            List<Products> productList = session.createQuery("FROM Products", Products.class).getResultList();

            if (productList.isEmpty()) {
                System.out.println("No products available.");
            } else {
                System.out.println("All Products:");
                for (Products product : productList) {
                    System.out.println("Name: " + product.getProductName());
                    System.out.println("Price: " + product.getPrice());
                    System.out.println("color: " + product.getColor());
                    System.out.println("Description: " + product.getDescription());
                    System.out.println("Qunatity: " + product.getQuantity());
                    // Display other product details as needed
                    System.out.println("-----------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void orderProducts() {
    	
    	    Scanner scanner = new Scanner(System.in);
    	    System.out.println("Order Products");

    	   
    	    System.out.print("Enter the ID of the product you want to order: ");
    	    int productId = scanner.nextInt();

    	    boolean continueOrdering = true;
    	    while (continueOrdering) {
    	        System.out.print("Do you want to order more products? (yes/no): ");
    	        String choice = scanner.next();
    	        if (choice.equalsIgnoreCase("yes")) {
    	            System.out.print("Enter the ID of the next product you want to order: ");
    	            productId = scanner.nextInt();
    	            // Add logic to validate and process the next product order
    	        } else if (choice.equalsIgnoreCase("no")) {
    	            continueOrdering = false;
    	            System.out.println("Exiting ordering products.");
    	        } else {
    	            System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
    	        }
    	    }
    	    // Close the scanner to prevent resource leak
    	    scanner.close();
    	}

    

    private static void placeOrder() {
    
    	    Scanner scanner = new Scanner(System.in);
    	    System.out.println("Place Order");

    	    
    	    System.out.print("Confirm order and proceed with payment? (yes/no): ");
    	    String confirmation = scanner.next();
    	    if (confirmation.equalsIgnoreCase("yes")) {
    	        // Implement logic to finalize the order and proceed with payment
    	        System.out.println("Your order has been placed successfully!");
    	      
    	    } else if (confirmation.equalsIgnoreCase("no")) {
    	        System.out.println("Order placement cancelled.");
    	    } else {
    	        System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
    	    }

    	    // Close the scanner to prevent resource leak
    	    scanner.close();
    	}

    private static void makePayment() {
        // Implementing payment functionality here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Payment");

        System.out.println("Select Payment Method:");
        System.out.println("1. Cash on Delivery");
        System.out.println("2. Online payment");
        System.out.print("Enter your choice: ");
        int paymentMethod = scanner.nextInt();

        switch (paymentMethod) {
            case 1:
                processCashOnDelivery();
                break;
            case 2:
                processOnlinePayment();
                break;
            default:
                System.out.println("Invalid payment method.");
                break;
        }

        // Close the scanner to prevent resource leak
        scanner.close();
    }

    private static void processCashOnDelivery() {
        // Implement logic for cash on delivery payment
        System.out.println("Cash on Delivery Payment Selected.");
        System.out.println("Your order will be delivered, and payment will be collected upon delivery.");
    }

    private static void processOnlinePayment() {
       
        System.out.println("Online Payment Selected.");
        System.out.println("Processing online payment...");
        System.out.println("Payment successful. Thank you for your order!");
    }

    private static void adminMenu(Admin loggedInAdmin, Productsdaoimpl productDao, Session session) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Admin Menu");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addProduct(scanner, productDao); // Pass productDao here
                    break;
                case 2:
                    viewAllProducts(productDao);
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (true);
    }

	

    private static void viewAllProducts(Productsdaoimpl productDao) {
        try {
            List<Products> productList = productDao.select();

            if (productList.isEmpty()) {
                System.out.println("No products available.");
            } else {
                System.out.println("All Products:");
                for (Products product : productList) {
                    System.out.println("Name: " + product.getProductName());
                    System.out.println("Price: " + product.getPrice());
                    System.out.println("Color: " + product.getColor());
                    System.out.println("Description: " + product.getDescription());
                    System.out.println("Quantity: " + product.getQuantity());
                    System.out.println("-----------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addProduct(Scanner scanner, Productsdaoimpl productDao) {
        try {
            System.out.println("Adding Product:");
            System.out.print("Enter product name: ");
            String productName = scanner.next();
            System.out.print("Enter description: ");
            String description = scanner.next();
            System.out.print("Enter quantity: ");
            double quantity = scanner.nextDouble();
            System.out.print("Enter color: ");
            String color = scanner.next();
            System.out.print("Enter product price: ");
            double price = scanner.nextDouble();

            Products product = new Products();
            product.setProductName(productName);
            product.setDescription(description);
            product.setQuantity(quantity);
            product.setColor(color);
            product.setPrice(price);
               productDao.insert(product);
            System.out.println("Product added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

	public static void registrationMenu(Scanner scanner, Registerdaoimpl registerDao, Admindaoimpl adminDao, Customerdaoimpl customerDao) {
        int choice;
        do {
            System.out.println("1. Admin Registration");
            System.out.println("2. Customer Registration");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    adminRegistration(scanner, registerDao, adminDao);
                    break;
                case 2:
                    customerRegistration(scanner, registerDao, customerDao);
                    break;
                case 3:
                    System.out.println("Exiting registration menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);
    }

    public static void adminRegistration(Scanner scanner, Registerdaoimpl registerDao, Admindaoimpl adminDao) {
        Admin admin = new Admin();
        System.out.print("Enter admin username: ");
        admin.setAdminName(scanner.next());
        System.out.print("Enter admin email: ");
        admin.setEmail(scanner.next());
        System.out.print("Enter admin contact number: ");
        admin.setMobile(scanner.nextInt());
        System.out.print("Enter admin password: ");
        admin.setPassword(scanner.next());
        Register adminRegister = new Register();
        adminRegister.setDateOfRegister(java.time.LocalDate.now().toString());
        registerDao.insert(adminRegister);
        admin.setRegister(adminRegister);
        adminDao.insert(admin);
        System.out.println("Admin registered successfully.");
    }

    public static void customerRegistration(Scanner scanner, Registerdaoimpl registerDao, Customerdaoimpl customerDao) {
        Customer customer = new Customer();
        System.out.print("Enter customer name: ");
        customer.setCustName(scanner.next());
        System.out.print("Enter customer address: ");
        customer.setCustAdd(scanner.next());
        System.out.print("Enter customer email: ");
        customer.setCustEmail(scanner.next());
        System.out.print("Enter customer gender: ");
        customer.setGender(scanner.next());
        System.out.print("Enter customer mobile number: ");
        customer.setCustMobile(scanner.nextInt());
        System.out.print("Enter customer password: ");
        customer.setPassword(scanner.next());
        Register customerRegister = new Register();
        customerRegister.setDateOfRegister(java.time.LocalDate.now().toString());
        registerDao.insert(customerRegister);
        customer.setRegister(customerRegister);
        customerDao.insert(customer);
        System.out.println("Customer registered successfully.");
    }
}
