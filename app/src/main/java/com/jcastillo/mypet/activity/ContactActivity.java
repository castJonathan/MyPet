package com.jcastillo.mypet.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcastillo.mypet.R;
import com.jcastillo.mypet.utils.Constantes;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactActivity extends AppCompatActivity {

    private EditText tietNombre;
    private EditText tietCorreo;
    private EditText tietMensaje;
    private Button btnEnviarComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tietNombre = findViewById(R.id.tietNombre);
        tietCorreo = findViewById(R.id.tietCorreo);
        tietMensaje = findViewById(R.id.tietMensaje);
        btnEnviarComentario = findViewById(R.id.btnEnviarComentario);

        btnEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Properties properties = new Properties();
                /*properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");*/

                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");

                Session session = Session.getDefaultInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Constantes.email, Constantes.psw);
                    }
                });

                try {
                    MimeMessage message = new MimeMessage(session);

                    //sender mail
                    message.setFrom(new InternetAddress(Constantes.email));

                    //recipient mail
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(Constantes.email));

                    //email subject
                    message.setSubject(getString(R.string.contacto_email_subject));

                    //email message
                    String mensaje = "Nombre: "+tietNombre.getText().toString() +"\nCorreo: "+tietCorreo.getText().toString()+"\nMensaje: "+tietMensaje.getText().toString();
                    message.setText(mensaje);

                    SendMail s = new SendMail();
                    s.execute(message);

                } catch (MessagingException e) {
                    Log.e(Constantes.TAG, e.getMessage());
                }
            }
        });
    }

    private class SendMail extends AsyncTask<Message, String, String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(ContactActivity.this, getString(R.string.contacto_progress_title), getString(R.string.contacto_progress_mensaje), true, false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return Constantes.success;
            } catch (MessagingException e) {
                Log.e(Constantes.TAG, e.getMessage());
                return Constantes.error;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            if (s.equals(Constantes.success)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ContactActivity.this);
                builder.setCancelable(false);
                builder.setTitle(R.string.contacto_alerta_titulo);
                builder.setMessage(R.string.contacto_alerta_mensaje);
                builder.setPositiveButton(R.string.contacto_alerta_btnOK, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        tietNombre.setText("");
                        tietCorreo.setText("");
                        tietMensaje.setText("");
                    }
                });
                builder.show();
            } else {
                Toast.makeText(ContactActivity.this, R.string.contacto_mensaje_error_envio, Toast.LENGTH_LONG).show();
            }
        }
    }
}