package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

public class RemoveTest {
    @Test
    public void test1() {
        // given
        PhoneBook phoneBook = new PhoneBook();
        String name = "John";
        String phoneNumber = "302-555-4545";
        phoneBook.add(name, phoneNumber);
        Assert.assertEquals(phoneBook.lookup(name).get(0), phoneNumber);

        // when
        phoneBook.remove(name);

        // then
        Assert.assertTrue(phoneBook.lookup(name).isEmpty());
    }

    @Test
    public void test2() {
        // given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Joe";
        String phoneNumber = "302-554-4545";
        phoneBook.add(name, phoneNumber);
        Assert.assertEquals(phoneBook.lookup(name).get(0), phoneNumber);

        // when
        phoneBook.remove(name);

        // then
        Assert.assertTrue(phoneBook.lookup(name).isEmpty());
    }


    @Test
    public void test3() {
        // given
        PhoneBook phoneBook = new PhoneBook();
        String name = "Smith";
        String phoneNumber = "302-554-4535";
        phoneBook.add(name, phoneNumber);
        Assert.assertEquals(phoneBook.lookup(name).get(0), phoneNumber);

        // when
        phoneBook.remove(name);

        // then
        Assert.assertTrue(phoneBook.lookup(name).isEmpty());
    }
}
