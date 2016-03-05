package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * Created by khain on 2/24/2016.
 */
@Entity
public class Tennis extends Model{

    String ngoai_troi;
    String nhiet_do;
    String do_am;
    String gio;
    String choi_tennis;

    public Tennis(String ngoai_troi, String nhiet_do, String do_am, String gio, String choi_tennis) {
        this.ngoai_troi = ngoai_troi;
        this.nhiet_do = nhiet_do;
        this.do_am = do_am;
        this.gio = gio;
        this.choi_tennis = choi_tennis;
    }

    public String getNgoai_troi() {
        return ngoai_troi;
    }

    public String getNhiet_do() {
        return nhiet_do;
    }

    public String getDo_am() {
        return do_am;
    }

    public String getGio() {
        return gio;
    }

    public String getChoi_tennis() {
        return choi_tennis;
    }
}
