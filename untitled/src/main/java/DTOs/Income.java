package DTOs;

import java.util.Date;

public class Income {
    private int id;
    private String title;
    private Double amount;
    private Date dateearned;

    public Income(int incomeId, String title, Double amount, Date dateearned) {
        this.id = incomeId;
        this.title = title;
        this.amount = amount;
        this.dateearned = dateearned;
    }

    public Income(String title, Double amount, Date dateearned) {
        this.id = 0;
        this.title = title;
        this.amount = amount;
        this.dateearned = dateearned;
    }

    public Income() {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDateearned() {
        return dateearned;
    }

    public void setDateearned(Date dateearned) {
        this.dateearned = dateearned;
    }

    @Override
    public String toString() {
        return "Income{" + "id=" + id + ", title=" + title + ", amount=" + amount + ", date=" + dateearned + '}';
    }

}

