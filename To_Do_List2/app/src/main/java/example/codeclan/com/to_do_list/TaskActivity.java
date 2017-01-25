package example.codeclan.com.to_do_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 24/01/2017.
 */

public class TaskActivity extends AppCompatActivity {

    Button home;
    TextView taskNameDisplayBox;
    TextView taskDetailsDisplayBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        taskNameDisplayBox = (TextView) findViewById(R.id.task_name_display_box);
        taskDetailsDisplayBox = (TextView) findViewById(R.id.task_details_display_box);
        home = (Button) findViewById(R.id.home_button);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String title = extras.getString("Task Title");
        taskNameDisplayBox.setText(title);
        String details = extras.getString("Task Details");
        taskDetailsDisplayBox.setText(details);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(TaskActivity.this, MainActivity.class);
                startActivity(home);
            };
        });


    }





}
