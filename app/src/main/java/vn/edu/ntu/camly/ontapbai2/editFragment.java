package vn.edu.ntu.camly.ontapbai2;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import vn.edu.ntu.camly.ontapbai2.controller.Icontactcontroller;
import vn.edu.ntu.camly.ontapbai2.model.contact;

public class editFragment extends Fragment {

    Toolbar toolbar;
    EditText edtID, edtname, edtbirth, edtphone, edtaddress;
    Button btnsave;

    NavController navController;
    Icontactcontroller controller;

    int id,kt;
    String ten, birth, phone, address;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        addview(view);
        getdata();
        addevent();
        return view;
    }

    private void addview(View view) {
        edtID = view.findViewById(R.id.edtID);
        edtphone = view.findViewById(R.id.edtphone);
        edtbirth = view.findViewById(R.id.edtbirth);
        edtaddress = view.findViewById(R.id.edtaddr);
        edtname = view.findViewById(R.id.edtname);
        btnsave = view.findViewById(R.id.btnsave);
        toolbar = view.findViewById(R.id.tbedit);

        navController = NavHostFragment.findNavController(editFragment.this);
        controller = ((MainActivity)getActivity()).controller;

    }

    private void getdata() {
        Bundle data = getArguments();
        id = data.getInt("id");
        kt = data.getInt("kt");
        if(kt == 0)
        {
            edtID.setText(String.valueOf(id));
        }
        else
        {
            edtID.setText(String.valueOf(id));
            edtname.setText(data.getString("name"));
            edtbirth.setText(data.getString("birth"));
            edtphone.setText(data.getString("phone"));
            edtaddress.setText(data.getString("address"));
        }

    }

    private void addevent() {
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_editFragment_to_danhsachFragment);
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact contact = new contact(id, edtname.getText().toString(), edtbirth.getText().toString(),
                        edtphone.getText().toString(),edtaddress.getText().toString());
                if (kt == 0)
                    controller.addcontact(contact);
                else
                    controller.editcontact(id,contact);
            }
        });
    }
}