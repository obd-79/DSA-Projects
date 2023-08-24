package com.company;

public class LinearProbingHashTable {
    private int  maxSize;
    private String[] keys;
    private Student[] studnet;
    public LinearProbingHashTable(int capacity) {
        maxSize = capacity;
        keys = new String[maxSize];
        studnet = new Student[maxSize];
    }

    private int hash(String key) {
        return key.length() % maxSize;
    }
    public void insert(String key, Student ss , int numberOfTxt) {
        int tmp = hash(key);
        int i = tmp;
        do {
            if (keys[i] == null) {
                keys[i] = key;
                studnet[i] = ss;
                studnet[i].numberOfTxt.add(numberOfTxt);
                return;
            }
            if (keys[i].equals(key)) {
                studnet[i].numberOfTxt.add(numberOfTxt);
                return;
            }
            i = (i + 1) % maxSize;
        }
        while (i != tmp);
    }
    public Student search(String key){
        int hash  = hash(key);
        int saveHash = hash(key);
        while (keys[hash] != null){
            if (keys[hash].equals(key)){
                return studnet[hash];
            }
            hash = (hash+1) % maxSize;
            if (saveHash == hash){
                return null;
            }
        }
        return null;
    }
    //testing
    public void printHashTable() {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println(keys[i] +" "+  studnet[i].numberOfTxt);
        System.out.println();
    }
}
