package com.example.satyanishanth.politics;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

public class Login extends AppCompatActivity {
    MaterialEditText newuser,newemail,newpass,newpassconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button signup = findViewById(R.id.sign_up);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                show_signup_dialog();

            }
        });
    }
    private void show_signup_dialog() {

        final Context gd = this;


        LayoutInflater Inflater = this.getLayoutInflater();
        View view = Inflater.inflate(R.layout.signup, null);
        newuser = view.findViewById(R.id.newuser);
        newemail = view.findViewById(R.id.email);
        newpass = view.findViewById(R.id.newpassword);
        newpassconfirm = view.findViewById(R.id.newconifrmpassword);

        newpass.setMinCharacters(6);
        newpass.setMaxCharacters(8);
        newuser.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (newuser.getText().toString().isEmpty()) {
                    newuser.setError("Username can't be empty");
                }
            }
        });
        newpass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (newpass.getText().toString().isEmpty()) {
                    newpass.setError("Password can't be empty");
                }
            }
        });
        newemail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (newemail.getText().toString().isEmpty()) {
                    newemail.setError("Email can't be empty");
                }
            }
        });

        final AlertDialog mdialog = new AlertDialog.Builder(this)
                .setView(view)
                .setMessage("Fill up all the credentials")
                .setTitle("Sign Up")
                .setIcon(R.drawable.ic_person_black_24dp)
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, null) //Set to null. We override the onclick
                .setNegativeButton(android.R.string.cancel, null)
                .create();

        mdialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(final DialogInterface dialog) {



                Button b = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                b.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        final ProgressDialog dilalog = new ProgressDialog(gd);
                        dilalog.setMessage("Loading");
                        // TODO Do something


                        dilalog.show();

                        if ((newuser.getText().toString().isEmpty()) || (newemail.getText().toString().isEmpty()) || (newpass.getText().toString().isEmpty())) {
                            Toast.makeText(Login.this, "Invalid Credential(s)", Toast.LENGTH_LONG).show();
                            dilalog.dismiss();
                            return;
                        } else if (!newemail.getText().toString().contains("@bml.edu.in")) {
                            Toast.makeText(Login.this, "Please enter college email id", Toast.LENGTH_LONG).show();
                            dilalog.dismiss();
                            return;
                        } else if (newpass.getText().toString().length() < 6 || newpass.getText().toString().length() > 8) {

                            Toast.makeText(Login.this, "Password length should be between 6 to 8 letters", Toast.LENGTH_LONG).show();
                            dilalog.dismiss();
                            return;
                        } else if (!newpassconfirm.getText().toString().equals(newpass.getText().toString())) {
                            newpassconfirm.setError("Password didn't match");
                            dilalog.dismiss();
                            return;
                        }

                        else {


                            mdialog.dismiss();


                        }

                    }
                });
                Button c = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEGATIVE);
                c.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        // TODO Do something
                        mdialog.dismiss();

                    }
                });


            }
        });
        mdialog.show();
    }

}
