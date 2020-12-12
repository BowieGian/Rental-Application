package com.example.rentalapplication.data;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class RentalTest {
    Rental rental = new Rental();

    @Test
    void setPrice() {
        Assert.assertTrue(rental.setPrice(500.0), "Set positive price didn't return true");
        Assert.assertEquals(rental.getPrice(), 500.0, "Set/get price not equal");
        Assert.assertFalse(rental.setPrice(-5.0), "Set negative price didn't return false");
        Assert.assertEquals(rental.getPrice(), 500.0, "Negative price");
    }

    @Test
    void setRating() {
        Assert.assertTrue(rental.setRating(4.5), "Set positive price didn't return true");
        Assert.assertEquals(rental.getRating(), 4.5, "Set/get rating not equal");
        Assert.assertFalse(rental.setRating(-5), "Set negative rating didn't return false");
        Assert.assertEquals(rental.getRating(), 4.5, "Negative rating");
    }
}