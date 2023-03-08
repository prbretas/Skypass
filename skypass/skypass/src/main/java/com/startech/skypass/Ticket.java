package com.startech.skypass;

public class Ticket {

    private String id;
    private String idFlight; //(fk_Flight_Ticket)
    private String idClient; //(fk_Client_Ticket)
    private Category category; //( ECONOMICA/ ECONOMICA PREMIUM/ EXECUTIVA/ 1ª CLASSE)
    private int amoutLuggage;
    private double WeightLuggage;
    private String date;
    private double ticketPrice;
    private boolean ativo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(String idFlight) {
        this.idFlight = idFlight;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAmoutLuggage() {
        return amoutLuggage;
    }

    public void setAmoutLuggage(int amoutLuggage) {
        this.amoutLuggage = amoutLuggage;
    }

    public double getWeightLuggage() {
        return WeightLuggage;
    }

    public void setWeightLuggage(double weightLuggage) {
        WeightLuggage = weightLuggage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean getAtivo() {
        return ativo;
    }


    public Ticket(String id, String idFlight, String idClient, Category category, int amoutLuggage,
                  double weightLuggage, String date, double ticketPrice) {
        this.id = id;
        this.idFlight = idFlight;
        this.idClient = idClient;
        this.category = category;
        this.amoutLuggage = amoutLuggage;
        WeightLuggage = weightLuggage;
        this.date = date;
        this.ticketPrice = ticketPrice;
    }

    public Ticket() {

    }

    @Override
    public String toString() {
        return "Ticket{" + '\'' +
                "id=" + getId() + '\'' +
                "idFlight=" + getIdFlight() + '\'' +
                "idClient=" + getIdClient() + '\'' +
                "category=" + getCategory() +
                "amoutLuggage=" + getAmoutLuggage() +
                "WeightLuggage=" + getWeightLuggage() +
                "date=" + getDate() + '\'' +
                "ticketPrice=" + getTicketPrice() +
                "ativo=" + getAtivo() +
                '}';
    }

    public boolean ativar(){
        return this.ativo = true;
    }
    public boolean inativar(){
        return this.ativo = false;
    }
}
