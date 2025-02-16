package DTOs;


import java.util.Date;

public class User {
    private int id;
    private String title;
    private String category;
    private Double amount;
    private Date dateincured;

    public User(int expenseId, String title, String category, Double amount, Date dateincured) {
        this.id = expenseId;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateincured = dateincured;
    }

    public User(String title, String category, Double amount, Date dateincured) {
        this.id = 0;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateincured = dateincured;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDateincured() {
        return dateincured;
    }

    public void setDateincured(Date dateincured) {
        this.dateincured = dateincured;
    }

    @Override
    public String toString() {
        return "Expense{" + "id=" + id + ", title=" + title + ", category=" +
                category + ", amount=" + amount + ", date=" + dateincured + '}';
    }

}
