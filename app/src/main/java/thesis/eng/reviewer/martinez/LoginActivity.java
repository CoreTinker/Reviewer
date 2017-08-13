package thesis.eng.reviewer.martinez;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;
import thesis.eng.reviewer.R;
import thesis.eng.reviewer.activity.MainActivity;
import thesis.eng.reviewer.app.MyApplication;
import thesis.eng.reviewer.dao.DaoSession;
import thesis.eng.reviewer.dao.SessionManager;
import thesis.eng.reviewer.dao.SessionManagerDao;

public class LoginActivity extends AppCompatActivity {
    TextView textView;
    Button login_button;
    EditText UserName,Password;
    String username,password;
    String login_url = "http://uopcereviewer.16mb.com/android/login3.php";
    ImageView image;
    String name;
    AlertDialog.Builder builder;

    public static final String DEFAULT="N/A";
    private final DaoSession daoSession = MyApplication.getInstance().getDaoSession();
    private final SessionManagerDao sessionManagerDao= daoSession.getSessionManagerDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.move);

        builder = new AlertDialog.Builder(this);
        login_button = (Button)findViewById(R.id.btn_login);
        UserName = (EditText)findViewById(R.id.login_name);
        Password = (EditText)findViewById(R.id.login_pass);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                username = UserName.getText().toString();
                password = Password.getText().toString();
                Log.e("username",username);
                if (UserName.getText().toString().equals("")|| (Password.getText().toString().equals("")))
                {
                    UserName.setError("Please fill username");
                    Password.setError("Please fill password");
                    Toast.makeText(LoginActivity.this, "Please fill up username and password!",
                            Toast.LENGTH_LONG).show();
                }if ((UserName.getText().toString().equals(""))) {
                    UserName.setError("Please fill username");
                    Toast.makeText(LoginActivity.this, "Please fill up username...",

                            Toast.LENGTH_LONG).show();
                } else if ((UserName.getText().toString().equals(""))) {
                    Password.setError("Please fill password");
                    Toast.makeText(LoginActivity.this, "Please fill up password...",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    SweetAlertDialog pDialog = new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);
                    pDialog.getProgressHelper().setBarColor(Color.parseColor("#ffe240"));
                    pDialog.setTitleText("Loading");
                    pDialog.setCancelable(false);
                    pDialog.show();
                    login(pDialog,username, password);
                }
            }


        });
    }
    public void login(final SweetAlertDialog pDialog, final String uname, final String pass){
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, login_url,

             new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response",response.toString());
            pDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            boolean error = obj.getBoolean("error");

                            if (!error){
                                Toast.makeText(getApplicationContext(),"Login success..",Toast.LENGTH_LONG).show();
                                Log.e("sess",uname);
                                SessionManager sessionManager = new SessionManager();
                                sessionManager.setIsLoggedIn(true);
                                sessionManager.setUsername(username);
                                sessionManagerDao.deleteAll();
                                sessionManagerDao.insert(sessionManager);
                                Intent i = new Intent(getApplicationContext(),MainActivity.class);

                                startActivity(i);
                                finish();


                            }else{
                                new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("Oops...")
                                        .setContentText("Invalid Credentials!")
                                        .show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                            new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("Oops...")
                                    .setContentText("Connection Problem!")
                                    .show();
                        }


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    pDialog.dismiss();
                        new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Oops...")
                                .setContentText("Connection Problem!")
                                .show();
                    }
                }){

            @Override
            protected Map<String, String> getParams() {
                Map<String,String>params = new HashMap<String, String>();
                params.put("StudentNumber",uname);
                params.put("Password", pass);

                return params;
            }


        };
        MyApplication.getInstance().addToRequestQueue(stringRequest);
    }


    public  void displayAlert(final String message) {
        builder.setMessage(message);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UserName.setText("");
                Password.setText("");
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    @Override
    public void onBackPressed(){



    }

    public void onHelp(View view){
        Intent intent=new Intent(getApplicationContext(),HelpActivity.class);
        startActivity(intent);

    }



}
