package vn.edu.ntu.camly.ontapbai2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.ntu.camly.ontapbai2.controller.Icontactcontroller;
import vn.edu.ntu.camly.ontapbai2.model.contact;

public class danhsachFragment extends Fragment {

Toolbar toolbar;
RecyclerView recyclerView;

NavController navController;
Icontactcontroller controller;

List<contact> contactList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_danhsach, container, false);
        addview(view);
        getdata();
        addevent();
        return view;
    }

    private void addview(View view) {
        toolbar = view.findViewById(R.id.tbds);
        toolbar.inflateMenu(R.menu.my_menu);
        recyclerView = view.findViewById(R.id.rcvlist);

        navController = NavHostFragment.findNavController(danhsachFragment.this);
        controller = ((MainActivity)getActivity()).controller;
    }

    private void getdata() {
        recyclerView.setLayoutManager(new LinearLayoutManager(danhsachFragment.this.getActivity()));
        contactList = controller.GetAllContact();
        ContactAdapter adapter = new ContactAdapter(contactList);
        recyclerView.setAdapter(adapter);
    }

    private void addevent() {
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Bundle data = new Bundle();
                data.putInt("id", contactList.size() + 1);
                data.putInt("kt", 0);
                navController.navigate(R.id.action_danhsachFragment_to_editFragment,data);
                return false;
            }
        });

    }

    private class ContactViewHolder extends RecyclerView.ViewHolder
    {

        TextView txtten, txtbirth, txtphone;
        ImageView imgedit;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.txtname);
            txtphone = itemView.findViewById(R.id.txtphone);
            txtbirth = itemView.findViewById(R.id.txtbirth);
            imgedit = itemView.findViewById(R.id.imgedit);
        }

        public void bind(contact c)
        {
            txtbirth.setText(c.getBirth());
            txtten.setText(c.getName());
            txtphone.setText(c.getPhone());
        }
    }

    private class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder>
    {
        List<contact> listcontacts;

        public ContactAdapter(List<contact> listProducts) {
            this.listcontacts = listProducts;
        }


        @NonNull
        @Override
        public danhsachFragment.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.contact, parent, false);
            return new ContactViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull danhsachFragment.ContactViewHolder holder, final int position) {
            holder.bind(listcontacts.get(position));
            holder.imgedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle data = new Bundle();
                    data.putInt("kt",1);
                    data.putInt("id",listcontacts.get(position).getId());
                    data.putString("name",listcontacts.get(position).getName());
                    data.putString("birth",listcontacts.get(position).getBirth());
                    data.putString("phone",listcontacts.get(position).getPhone());
                    data.putString("address",listcontacts.get(position).getAddress());
                    navController.navigate(R.id.action_danhsachFragment_to_editFragment,data);
                }
            });
        }

        @Override
        public int getItemCount() {
            return listcontacts.size();
        }
    }
}