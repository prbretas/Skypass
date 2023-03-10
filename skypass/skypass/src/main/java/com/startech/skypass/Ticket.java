package com.startech.skypass;

public class Ticket {

    private String id;
    private String idClient; //(fk_Client_Ticket)
    private String idFlight; //(fk_Flight_Ticket)
    private String idSeat;

    private Category category; //( ECONOMICA/ EXECUTIVA/ PRIMEIRA_CLASSE)
    private int amoutLuggage;
    private double weightLuggage;
    private String date;
    private double ticketPrice;
    private boolean ativo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
    public String getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(String idFlight) {
        this.idFlight = idFlight;
    }

    public String getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(String idSeat) {
        this.idSeat = idSeat;
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
        return weightLuggage;
    }

    public void setWeightLuggage(double weightLuggage) {
        this.weightLuggage = weightLuggage;
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


    public Ticket(String id,  String idClient, String idFlight, String idSeat, Category category, int amoutLuggage,
                  double weightLuggage, String date, double ticketPrice) {
        this.id = id;
        this.idClient = idClient;
        this.idFlight = idFlight;
        this.idSeat = idSeat;
        this.category = category;
        this.amoutLuggage = amoutLuggage;
        this.weightLuggage = weightLuggage;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.ativo = true;
    }

    public Ticket() {

    }

    @Override
    public String toString() {
        return "\nTicket{" +
                "\nid=" + getId() +
                "\nidClient=" + getIdClient() +
                "\nidFlight=" + getIdFlight() +
                "\nidSeat=" + getIdSeat() +
                "\ncategory=" + getCategory() +
                "\namoutLuggage=" + getAmoutLuggage() +
                "\nweightLuggage=" + getWeightLuggage() + "kg"+
                "\ndate=" + getDate() +
                "\nticketPrice=R$" + getTicketPrice() +
                "\nativo=" + getAtivo() +
                "\n}";
    }

    public boolean ativar(){
        return this.ativo = true;
    }
    public boolean inativar(){
        return this.ativo = false;
    }


}
