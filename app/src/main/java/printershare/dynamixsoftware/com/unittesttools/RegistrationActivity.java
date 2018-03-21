package printershare.dynamixsoftware.com.unittesttools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hp on 3/20/2018.
 */

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final EditText editText = findViewById(R.id.name_edit);
        Button submit = findViewById(R.id.submit);
        Button navigation = findViewById(R.id.nav);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lanName = editText.getText().toString();
                if (TextUtils.isEmpty(lanName))
                    return;

                Intent intent = MainActivity.newStartIntent(RegistrationActivity.this, lanName);
                startActivity(intent);
            }
        });

        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegistrationActivity.this, NavActivity.class);
                startActivity(intent);
            }
        });
    }

}
