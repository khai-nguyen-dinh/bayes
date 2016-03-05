package controllers;

import play.*;
import play.mvc.*;

import java.text.Normalizer;
import java.util.*;

import models.*;

public class Application extends Controller {

    public static float c2;
    public static float ngoai_troi_c1;
    public static float ngoai_troi_c2;
    public static float nhiet_do_c1;
    public static float nhiet_do_c2;
    public static float do_am_c1;
    public static float do_am_c2;
    public static float gio_c1;
    public static float gio_c2;
    public static float Pz1;
    public static float Pz2;

    public static void index() {
        render();
    }
    public static String submit(String ngoai_troi, String nhiet_do, String do_am, String gio){
        float c1;
        List<Tennis> data = Tennis.findAll();
        for(Tennis temp : data){
            if(temp.getNhiet_do().equals(nhiet_do)&&temp.getGio().equals(gio)&&temp.getDo_am().equals(do_am)&&temp.getNgoai_troi().equals(ngoai_troi)){
                return temp.getChoi_tennis();
            }
        }
        int temp = 0;
        for(Tennis d : data){
            if(d.getChoi_tennis().equals("yes")){
                temp++;
            }
        }

        c1 = (float) temp/ data.size();
        c2 = (float) (data.size()-temp)/data.size();
        int count_nhiet_do_c1 = 0;
        int count_nhiet_do_c2 = 0;
        for(Tennis d : data){
            if(d.getNhiet_do().equals(nhiet_do)&&d.getChoi_tennis().equals("yes")){
                count_nhiet_do_c1 ++;
            }else if(d.getNhiet_do().equals(nhiet_do)&&d.getChoi_tennis().equals("no")){
                count_nhiet_do_c2 ++;
            }
        }
        nhiet_do_c1 = (float) count_nhiet_do_c1/c1;

        nhiet_do_c2 = (float) count_nhiet_do_c2/c2;

        int count_ngoai_troi_c1 = 0;
        int count_ngoai_troi_c2 = 0;
        for(Tennis d : data){
            if(d.getNgoai_troi().equals(ngoai_troi)&&d.getChoi_tennis().equals("yes")){
                count_ngoai_troi_c1 ++;
            }else if(d.getNgoai_troi().equals(ngoai_troi)&&d.getChoi_tennis().equals("no")){
                count_ngoai_troi_c2 ++;
            }
        }
        ngoai_troi_c1 = (float) count_ngoai_troi_c1/c1;
        ngoai_troi_c2 = (float) count_ngoai_troi_c2/c2;

        int count_do_am_c1 = 0;
        int count_do_am_c2 = 0;
        for(Tennis d : data){
            if(d.getDo_am().equals(do_am)&&d.getChoi_tennis().equals("yes")){
                count_do_am_c1 ++;
            }else if(d.getDo_am().equals(do_am)&&d.getChoi_tennis().equals("no")){
                count_do_am_c2 ++;
            }
        }

        do_am_c1 = (float) count_do_am_c1/c1;
        do_am_c2 = (float) count_do_am_c2/c2;
        int count_gio_c1 = 0;
        int count_gio_c2 = 0;
        for(Tennis d : data){
            if(d.getGio().equals(gio)&&d.getChoi_tennis().equals("yes")){
                count_gio_c1 ++;
            }else if(d.getGio().equals(gio)&&d.getChoi_tennis().equals("no")){
                count_gio_c2 ++;
            }
        }
        gio_c1 = (float) count_gio_c1/c1;
        gio_c2 = (float) count_gio_c2/c2;
        Pz1 =ngoai_troi_c1*do_am_c1*gio_c1*nhiet_do_c1;
        Pz2 =ngoai_troi_c2*do_am_c2*gio_c2*nhiet_do_c2;

        if(Pz1*c1>Pz2*c2){
            return("anh ấy có đi chơi tennis");
        }else{
            return ("anh ấy không đi chơi tennis");
        }
    }

}