package thesis.eng.reviewer.martinez;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import thesis.eng.reviewer.R;

public class HelpActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_help);



    }


    public void backk(View v){
        finish();
    }

}
