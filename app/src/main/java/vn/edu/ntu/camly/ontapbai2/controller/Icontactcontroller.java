package vn.edu.ntu.camly.ontapbai2.controller;

import java.util.List;

import vn.edu.ntu.camly.ontapbai2.model.contact;

public interface Icontactcontroller {
    public List<contact> GetAllContact();
    public void addcontact(contact c);
    public void editcontact(int id, contact c);
    public void deletecontact(int id);
}
