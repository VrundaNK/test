package com.company.bookReader;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by vnagpurkar on 7/23/16.
 */
/* Assumptions:
1. Only one user login at a time
2. Only one book will be read by user

// functions supported by BookReader
//1. Login a user
//2. Maintain one active user and one active/in progress reading book
//3. User can choose an active/in progress book
//3. Page forward and Page backword to continue reading
*/
public class BookReader {

    private UserManager userManager;
    private Library library;
    private Display display;

    public BookReader(){

        userManager = new UserManager();
        library = new Library();
        display = new Display();
    }

    public void Login(String userId){

        if(userManager.isAuthenticated(userId)){
            display.setActiveUser(userManager.getUser(userId));
        } else {
            throw new Error("Login Error");
        }
    }

    public void chooseBook(int index){

        if(display.getActiveUser() == null){
            throw new Error("No User is logged in");
        }

        Book book = library.getBook(index);
        if( book!= null) {
            display.setActiveBook(book);
        } else {
            throw new Error("Requested book does not exist");
        }
    }

}

class Book {

    private int index;
    private String name;
    private int maxPages;
    private String details;

    public Book(int index, String name, int maxPages, String details){

        this.index = index;
        this.name = name;
        this.maxPages = maxPages;
        this.details = details;
    }

    public int getIndex(){
        return this.index;
    }

    public String getName(){
        return this.name;
    }

    public int getMaxPages(){
        return this.maxPages;
    }

    public String getDetails(){
        return this.details;
    }
}

class Library {

    private Map<Integer, Book> books;

    public Library(){
        books = new HashMap<Integer, Book>();
    }

    public void addBook(int index, String name, int maxPages, String details){

        Book newBook = new Book(index, name,maxPages,details);
        books.put(index, newBook);
    }
    public void removeBook(int index){
        books.remove(index);
    }

    public Book getBook(int index){
        return books.get(index);
    }

}

class User {

    private String userId;
    private String name;
    private AccountType accountType;

    public User(String userId, String name, AccountType accountType){
        this.userId = userId;
        this.name = name;
        this.accountType = accountType;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}

class UserManager {

    private Map<String, User> allUsers;
    public UserManager(){

        allUsers = new HashMap<String, User>();
    }

    public boolean addNewUser(String userId, String userName, AccountType accountType){
        boolean success;
        try {
            User newUser = new User(userId, userName, accountType);
            allUsers.put(userId, newUser);
            success = true;
        } catch (Exception ex){
            success = false;
        }
        return success;
    }

    public boolean removeUser(String userId){
        boolean success;
        try {
            if(allUsers.containsKey(userId)) {
                allUsers.remove(userId);
                success = true;
            } else {
                success = false;
            }
        } catch (Exception ex){
            success = false;
        }
        return success;
    }

    public User getUser(String userId){
        return allUsers.get(userId);
    }

    // implement some sort of mechanism to authenticate the user
    public boolean isAuthenticated(String userId){
        if(allUsers.containsKey(userId)// && authenticated
        ) {
            return true;
        }

        return false;
    }
}

enum AccountType {

    READER,
    ADMIN
}

class Display {

    private User activeUser;
    private Book activeBook;
    private int currentPageIndex = 0;

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public Book getActiveBook() {
        return activeBook;
    }

    public void setActiveBook(Book activeBook) {
        this.activeBook = activeBook;
        currentPageIndex = 0; // reset page index to zero when new book is selected
    }

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public void readForward(){

        if(this.getActiveBook() != null && this.getCurrentPageIndex()<this.activeBook.getMaxPages()) {
            this.setCurrentPageIndex(this.getCurrentPageIndex()+1);
        } else {
            throw new Error("End of book!!");
        }
    }

    public void readBackword(){

        if(this.getActiveBook() != null && this.getCurrentPageIndex() > 1) {
            this.setCurrentPageIndex(this.getCurrentPageIndex()-1);
        } else {
            throw new Error("First page, cannot go backword!!");
        }
    }
}


