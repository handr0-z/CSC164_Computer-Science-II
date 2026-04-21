package com.example.csc164_module9_assignment1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class JavaBitesMenuController {

    private String[] menuItemName = new String[12];
    private String[] menuItemPrice = new String[12];

    @FXML
    private ToggleButton addtoCartButton1;

    @FXML
    private ToggleButton addtoCartButton11;

    @FXML
    private ToggleButton addtoCartButton110;

    @FXML
    private ToggleButton addtoCartButton111;

    @FXML
    private ToggleButton addtoCartButton12;

    @FXML
    private ToggleButton addtoCartButton13;

    @FXML
    private ToggleButton addtoCartButton14;

    @FXML
    private ToggleButton addtoCartButton15;

    @FXML
    private ToggleButton addtoCartButton16;

    @FXML
    private ToggleButton addtoCartButton17;

    @FXML
    private ToggleButton addtoCartButton18;

    @FXML
    private ToggleButton addtoCartButton19;

    @FXML
    private ChoiceBox<?> filterList;

    @FXML
    private Label foodLabel001;

    @FXML
    private Label foodLabel002;

    @FXML
    private Label foodLabel003;

    @FXML
    private Label foodLabel004;

    @FXML
    private Label foodLabel005;

    @FXML
    private Label foodLabel006;

    @FXML
    private Label foodLabel007;

    @FXML
    private Label foodLabel008;

    @FXML
    private Label foodLabel009;

    @FXML
    private Label foodLabel010;

    @FXML
    private Label foodLabel011;

    @FXML
    private Label foodLabel012;

    @FXML
    private Label priceLabel001;

    @FXML
    private Label priceLabel002;

    @FXML
    private Label priceLabel003;

    @FXML
    private Label priceLabel004;

    @FXML
    private Label priceLabel005;

    @FXML
    private Label priceLabel006;

    @FXML
    private Label priceLabel007;

    @FXML
    private Label priceLabel008;

    @FXML
    private Label priceLabel009;

    @FXML
    private Label priceLabel010;

    @FXML
    private Label priceLabel011;

    @FXML
    private Label priceLabel012;

    @FXML
    private ToggleButton showAllButton;

    public void initialize() {

        // Create Menu for Restaurant.
        ArrayList<RestaurantItem> menu = new ArrayList<>();
        createMenu(menu);
        obtainMenuInfo(menu, menuItemName, menuItemPrice);

        foodLabel001.setText(menuItemName[0]);
        priceLabel001.setText(menuItemPrice[0]);
        foodLabel002.setText(menuItemName[1]);
        priceLabel002.setText(menuItemPrice[1]);
        foodLabel003.setText(menuItemName[2]);
        priceLabel003.setText(menuItemPrice[2]);
        foodLabel004.setText(menuItemName[3]);
        priceLabel004.setText(menuItemPrice[3]);
        foodLabel005.setText(menuItemName[4]);
        priceLabel005.setText(menuItemPrice[4]);
        foodLabel006.setText(menuItemName[5]);
        priceLabel006.setText(menuItemPrice[5]);
        foodLabel007.setText(menuItemName[6]);
        priceLabel007.setText(menuItemPrice[6]);
        foodLabel008.setText(menuItemName[7]);
        priceLabel008.setText(menuItemPrice[7]);
        foodLabel009.setText(menuItemName[8]);
        priceLabel009.setText(menuItemPrice[8]);
        foodLabel010.setText(menuItemName[9]);
        priceLabel010.setText(menuItemPrice[9]);
        foodLabel011.setText(menuItemName[10]);
        priceLabel011.setText(menuItemPrice[10]);
        foodLabel012.setText(menuItemName[11]);
        priceLabel012.setText(menuItemPrice[11]);
    }

    // Method used to create restaurant menu.
    void createMenu(ArrayList<RestaurantItem> menu)
    {
        menu.add(new Food("Cheeseburger", 7.99, "Gluten, Dairy"));
        menu.add(new Food("French Fries", 4.79, "Gluten, Dairy"));
        menu.add(new Food("Salad", 6.49, "Nuts"));
        menu.add(new Food("Pizza", 14.99, "Gluten, Dairy"));
        menu.add(new Food("Cheesesteak", 12.99, "Gluten, Dairy"));
        menu.add(new Drink("Soda", 0.99, "Small"));
        menu.add(new Drink("Soda", 1.49, "Medium"));
        menu.add(new Drink("Soda", 1.99, "Large"));
        menu.add(new Drink("Juice", 0.99, "Small"));
        menu.add(new Drink("Juice", 1.29, "Medium"));
        menu.add(new Drink("Juice", 1.49, "Large"));
        menu.add(new GiftCard("Gift Card", 25.00));
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