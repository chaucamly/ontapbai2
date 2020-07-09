package vn.edu.ntu.camly.ontapbai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.edu.ntu.camly.ontapbai2.controller.Icontactcontroller;
import vn.edu.ntu.camly.ontapbai2.controller.controller;

public class MainActivity extends AppCompatActivity {

    Icontactcontroller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new controller();
        controller = (Icontactcontroller) getApplication();
    }
}