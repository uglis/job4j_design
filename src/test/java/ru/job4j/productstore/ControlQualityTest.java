package ru.job4j.productstore;

import org.junit.Test;
import ru.job4j.productstore.products.Juice;
import ru.job4j.productstore.products.Meat;
import ru.job4j.productstore.products.Milk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {
    private SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
    private ControlQuality quality = new ControlQuality();

    @Test
    public void whenHave1FoodToShopAdn1ToWarehouse() throws ParseException {
        Date milkCreate = format.parse("23 01 2020");
        Date milkExp = format.parse("12 12 2020");
        Milk iceCream = new Milk("ice cream", milkCreate, milkExp, 12, 0);
        Date createJuice = format.parse("12 06 2020");
        Date expJuice = format.parse("12 11 2020");
        Juice juice = new Juice("orange", createJuice, expJuice, 20, 0);
        quality.add(iceCream);
        quality.add(juice);
        quality.checkProducts();
        Warehouse warehouse = Warehouse.getInstance();
        Shop shop = Shop.getInstance();
        assertThat(shop.getStore().get(0), is(
                new Milk("ice cream", milkCreate, milkExp, 12, 0)));
        assertThat(warehouse.getStore().get(0), is(
                new Juice("orange", createJuice, expJuice, 20, 0)));
    }

    @Test
    public void whenHave1FoodToTrash() throws ParseException {
        Date meatCreate = format.parse("10 01 2020");
        Date meatExp = format.parse("26 06 2020");
        Meat meat = new Meat("pig", meatCreate, meatExp, 20, 0);
        quality.add(meat);
        quality.checkProducts();
        Trash trash = Trash.getInstance();
        assertThat(trash.getStore().get(0), is(new Meat("pig", meatCreate, meatExp, 20, 0)));
    }
}