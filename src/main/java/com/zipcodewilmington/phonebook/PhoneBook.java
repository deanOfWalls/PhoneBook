package com.zipcodewilmington.phonebook;

import java.util.*;

public class PhoneBook {

    // Define a private field to store the phonebook data using a Map.
    // We use a LinkedHashMap to maintain the order of entries in the phonebook.
    private final Map<String, List<String>> phonebook;

    // Constructor that takes an existing Map to initialize the phonebook with.
    public PhoneBook(Map<String, List<String>> map) {
        // If the passed-in map is null, create a new LinkedHashMap.
        // Otherwise, use the passed-in map.
        this.phonebook = (map == null) ? new LinkedHashMap<>() : map;
    }

    // Default constructor that initializes an empty phonebook.
    public PhoneBook() {
        this(null);
    }

    // Method to add a single phone number to the phonebook for a given name.
    public void add(String name, String phoneNumber) {
        // Get the list of phone numbers associated with the given name, or create a new list if none exist.
        List<String> phoneNumbers = phonebook.getOrDefault(name, new ArrayList<>());
        // Add the new phone number to the list.
        phoneNumbers.add(phoneNumber);
        // Update the phonebook entry for the given name.
        phonebook.put(name, phoneNumbers);
    }

    // Method to add multiple phone numbers to the phonebook for a given name.
    public void addAll(String name, String... phoneNumbers) {
        // Get the list of phone numbers associated with the given name, or create a new list if none exist.
        List<String> existingPhoneNumbers = phonebook.getOrDefault(name, new ArrayList<>());
        // Add the new phone numbers to the existing list.
        existingPhoneNumbers.addAll(Arrays.asList(phoneNumbers));
        // Update the phonebook entry for the given name.
        phonebook.put(name, existingPhoneNumbers);
    }

    // Method to remove a phonebook entry for a given name.
    public void remove(String name) {
        phonebook.remove(name);
    }

    // Method to check if a phonebook entry exists for a given name.
    public Boolean hasEntry(String name, String phoneNumber) {
        return phonebook.containsKey(name);
    }

    // Method to get a list of phone numbers associated with a given name.
    public List<String> lookup(String name) {
        // Get the list of phone numbers associated with the given name, or create a new empty list if none exist.
        return phonebook.getOrDefault(name, new ArrayList<>());
    }

    // Method to get the name associated with a given phone number.
    public String reverseLookup(String phoneNumber) {
        // Iterate through each phonebook entry.
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            // If the current entry's list of phone numbers contains the given number, return the name associated with the entry.
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        // If no match is found, return null.
        return null;
    }

    // Method to get a list of all names in the phonebook.
    public List<String> getAllContactNames() {
        // Create a new ArrayList of keys (i.e., names) in the phonebook.
        return new ArrayList<>(phonebook.keySet());
    }

    // Method to get the entire phonebook data as a Map.
    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
