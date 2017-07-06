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
public class NowShowingEntity {
    
    private int nsmid;
    private String movie_name;
    private String  photo;

    public int getNsmid() {
        return nsmid;
    }

    public void setNsmid(int nsmid) {
        this.nsmid = nsmid;
    }

    
    
    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
}
