/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author dell
 */
public class FinalBookingEntity {
    String user_name;
    String movie_choosen;
    String showtime_choosen;
    String day_choosen;
    String payment;
    String gender;
    String address;
    String email;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMovie_choosen() {
        return movie_choosen;
    }

    public void setMovie_choosen(String movie_choosen) {
        this.movie_choosen = movie_choosen;
    }

    public String getShowtime_choosen() {
        return showtime_choosen;
    }

    public void setShowtime_choosen(String showtime_choosen) {
        this.showtime_choosen = showtime_choosen;
    }

    public String getDay_choosen() {
        return day_choosen;
    }

    public void setDay_choosen(String day_choosen) {
        this.day_choosen = day_choosen;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
