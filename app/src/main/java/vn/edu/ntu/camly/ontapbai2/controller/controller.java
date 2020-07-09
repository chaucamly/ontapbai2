package vn.edu.ntu.camly.ontapbai2.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.camly.ontapbai2.model.contact;

public class controller extends Application implements Icontactcontroller {

    List<contact> contactList;

    public controller() {
        contactList = new ArrayList<>();
        contactList.add(new contact(1,"Tô Phước Thái","10/10/1998","0338303823","Nha Trang"));
        contactList.add(new contact(2,"Nguyễn Xuân Huy","11/10/1998","0338303823","Nha Trang"));
        contactList.add(new contact(3,"Nguyễn Nga","12/10/1998","0338303823","Nha Trang"));
    }

    @Override
    public List<contact> GetAllContact() {
        return contactList;
    }

    @Override
    public void addcontact(contact c) {
        contactList.add(c);
    }

    @Override
    public void editcontact(int id, contact c) {
        for(contact p: contactList)
        {
            if(p.getId() == id) {
                p.setName(c.getName());
                p.setBirth(c.getBirth());
                p.setPhone(c.getPhone());
                p.setAddress(c.getAddress());
            }

        }
    }

    @Override
    public void deletecontact(int id) {
        for(contact p: contactList)
        {
            if(p.getId() == id) {
              contactList.remove(p);
            }

        }
    }
}
