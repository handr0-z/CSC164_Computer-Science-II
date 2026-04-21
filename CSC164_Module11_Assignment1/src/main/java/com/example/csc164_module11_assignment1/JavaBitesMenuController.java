package com.example.csc164_module11_assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaBitesMenuController {
    private String choice1 = "Show All";
    private String choice2 = "Food";
    private String choice3 = "Drink";
    private String choice4 = "Other";
    private String filterSelection = null;
    private String fileName = "MENU-ITEMS.txt";
    private String message;

    private ArrayList<RestaurantItem> menu = new ArrayList<>();

    @FXML
    private ChoiceBox<String> filterList;

    @FXML
    private ListView<String> menuListView;

    @FXML
    private ToggleButton filterButton;

    @FXML
    private TextField itemInfoTextField;

    public void initialize() {
        // Add options to choice box
        filterList.getItems().add(choice1);
        filterList.getItems().add(choice2);
        filterList.getItems().add(choice3);
        filterList.getItems().add(choice4);

        // Create Menu for Restaurant.
        createMenu(menu);

        filterList.getSelectionModel().selectFirst();

        // Populate ListView with menu items.
        for (int i = 0; i < menu.size(); i++) {menuListView.getItems().add(menu.get(i).getName());}
    }

    @FXML
    void filterMenuHandler(ActionEvent event) {
        filterSelection = filterList.getValue(); // Obtain filter selection from user.
        menuListView.getItems().clear();

        for (int i = 0; i < menu.size(); i++) {
            if (filterSelection.equals(choice2) && menu.get(i) instanceof Food) {menuListView.getItems().add(menu.get(i).getName());}
            else if (filterSelection.equals(choice3) && menu.get(i) instanceof Drink) {menuListView.getItems().add(menu.get(i).getName());}
            else if (filterSelection.equals(choice4) && menu.get(i) instanceof GiftCard){menuListView.getItems().add(menu.get(i).getName());}
            else if (filterSelection.equals(choice1)) {menuListView.getItems().add(menu.get(i).getName());}
        }

    }

    @FXML
    void listViewSelectionHandler(MouseEvent event) {
        String selection = String.valueOf(menuListView.getSelectionModel().getSelectedItems());
        for (int i = 0; i < menu.size(); i++) {
            if (selection.equals("[" + menu.get(i).getName() + "]")) {
                itemInfoTextField.setText(menu.get(i).menuDisplay());
            }
        }
    }

    // Method used to create restaurant menu.
    void createMenu(ArrayList<RestaurantItem> menu)
    {
        try
        {
            // Create a file with a list menu items for the software to pull items from below. NOT NEEDED AFTER INITIAL ATTEMPT.
            /*PrintWriter writeFile = new PrintWriter(fileName);
            writeFile.println("NOTE: When Adding items to list, be sure to follow outline below.");
            writeFile.println("-----------------------------------------------------------------------------------------------------");
            writeFile.println("FOOD,NAME,PRICE,ALLERGEN 1,ALLERGEN 2\n");
            writeFile.println("DRINK,NAME,PRICE,SIZE\n");
            writeFile.println("GIFT CARD,NAME,PRICE,BALANCE,MESSAGE");
            writeFile.println("-----------------------------------------------------------------------------------------------------");
            writeFile.println("Food,Cheeseburger,7.99,Gluten,Dairy");
            writeFile.println("Food,French Fries,4.79,Gluten,Dairy");
            writeFile.println("Food,Salad,6.49,Nuts");
            writeFile.println("Food,Pizza,14.99,Gluten, Dairy");
            writeFile.println("Food,Cheesesteak,12.99,Gluten,Dairy");
            writeFile.println("Drink,Soda (S),0.99,Small");
            writeFile.println("Drink,Soda (M),1.49,Medium");
            writeFile.println("Drink,Soda (L),1.99,Large");
            writeFile.println("Drink,Soda (S),0.99,Small");
            writeFile.println("Drink,Soda (M),1.29,Medium");
            writeFile.println("Drink,Soda (L),1.49,Large");
            writeFile.println("Gift Card,Birthday Gift Card,25.00,25.00,Happy Birthday!");
            writeFile.close();*/

            System.out.println("File " + fileName + " created successfully.\n\n");
            System.out.println("NOTE: When Adding items to list, be sure to follow outline below.");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("FOOD,NAME,PRICE,ALLERGEN 1,ALLERGEN \n");
            System.out.println("DRINK,NAME,PRICE,SIZE\n");
            System.out.println("GIFT CARD,NAME,PRICE,BALANCE,MESSAGE");
            System.out.println("-----------------------------------------------------------------------------------------------------");

            // Obtain text from file created above.
            File readFile = new File(fileName);
            Scanner scanner = new Scanner(readFile);

            while (scanner.hasNextLine()) {
                message = scanner.nextLine();

                String[] itemInfo = message.split(","); // Detect the comma to split each line in the file.
                int i = 0;
                double price;

                // After detecting the type of items that needs to be created. the if statements below will create the objects for the program to display.
                if (itemInfo[i].equals("Food")) {
                    price = Double.parseDouble(itemInfo[i+2]);
                    if (itemInfo.length < 4)
                        menu.add(new Food(itemInfo[i+1],price)); // use to detect if file contains no allergens
                    else if (itemInfo.length < 5)
                        menu.add(new Food(itemInfo[i+1],price,itemInfo[i+3])); // use to detect if file contains 1 allergen item only.
                    else
                        menu.add(new Food(itemInfo[i+1],price,itemInfo[i+3],itemInfo[i+4])); // use to detect if file contains 2 allergen items.
                }
                if (itemInfo[0].equals("Drink")) {
                    price = Double.parseDouble(itemInfo[i+2]);
                    menu.add(new Drink(itemInfo[i+1],price,itemInfo[i+3]));
                }
                if (itemInfo[0].equals("Gift Card")) {
                    price = Double.parseDouble(itemInfo[i+2]);
                    double balance = Double.parseDouble(itemInfo[i+3]);
                    menu.add(new GiftCard(itemInfo[i+1],price,balance,itemInfo[i+4]));
                }
            }
            scanner.close();

        }
        catch (FileNotFoundException e) {System.out.println("Error! Unable to create or read file.");}
    }

    // Method used to obtain menu information from arrayList.
    void obtainMenuInfo(ArrayList<RestaurantItem> menu, String[] menuItemName,String[] menuItemPrice)
    {
        // Obtain menu item names
        for (int i = 0; i < menu.size(); i++)
        {
            if (menu.get(i) instanceof Food)
            {
                Food menuItem = (Food) menu.get(i);
                menuItemName[i] = menuItem.getName();
            }
            else if (menu.get(i) instanceof Drink)
            {
                Drink menuItem = (Drink) menu.get(i);
                menuItemName[i] = menuItem.getName() + " (" +  menuItem.getSize() + ")";
            }
            else
            {
                GiftCard menuItem = (GiftCard) menu.get(i);
                menuItemName[i] = menuItem.getName();
            }
        }

        // Obtain menu item prices
        for (int i = 0; i < menu.size(); i++)
        {
            if (menu.get(i) instanceof Food)
            {
                Food menuItem = (Food) menu.get(i);
                menuItemPrice[i] = "$" + menuItem.getPrice();
            }
            else if (menu.get(i) instanceof Drink)
            {
                Drink menuItem = (Drink) menu.get(i);
                menuItemPrice[i] = "$" + menuItem.getPrice();
            }
            else
            {
                GiftCard menuItem = (GiftCard) menu.get(i);
                menuItemPrice[i] = "$" + menuItem.getPrice();
            }
        }

    }
}