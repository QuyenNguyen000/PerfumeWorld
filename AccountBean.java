package project;

import java.util.HashMap;
import java.util.Map;

public class AccountBean {
	private String name;
    private String password;
    private Map<Item, Integer> inventory = new HashMap<>();

    public AccountBean() {
    }

    public AccountBean(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void addItem(Item item, Integer quantity) {
        inventory.put(item, quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "Password: " + this.password;
    }
}
