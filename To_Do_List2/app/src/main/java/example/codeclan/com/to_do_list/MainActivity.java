package example.codeclan.com.to_do_list;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button homeScreenButton;
    Button showTaskButton;
    Button createTaskButton;
    Button saveTask;
    TextView welcomeMessage;
    TextView displayTaskDetails;
    EditText taskTitle;
    EditText taskDetails;
    ListView taskList;
    Task_details task;
    ArrayList<Task_details> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeScreenButton = (Button) findViewById(R.id.home_button);
        showTaskButton = (Button) findViewById(R.id.show_task_button);
        createTaskButton = (Button) findViewById(R.id.create_task_button);
        saveTask = (Button) findViewById(R.id.save_task);
        welcomeMessage = (TextView) findViewById(R.id.welcome_message);
        taskTitle = (EditText) findViewById(R.id.task_title_text_box);
        taskDetails = (EditText) findViewById(R.id.task_details_text_box);
        taskList = (ListView) findViewById(R.id.task_list);
        displayTaskDetails = (TextView) findViewById(R.id.task_details_display_box);

        homeScreenButton.setVisibility(View.INVISIBLE);
        showTaskButton.setVisibility(View.VISIBLE);
        createTaskButton.setVisibility(View.VISIBLE);
        welcomeMessage.setVisibility(View.VISIBLE);
        taskTitle.setVisibility(View.INVISIBLE);
        taskDetails.setVisibility(View.INVISIBLE);
        taskList.setVisibility(View.INVISIBLE);
        displayTaskDetails.setVisibility(View.INVISIBLE);
        saveTask.setVisibility(View.INVISIBLE);




        saveTask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String getTitle = taskTitle.getText().toString();
                String getDetails = taskDetails.getText().toString();

                task = new Task_details(getTitle, getDetails);

                 if (task.getName() == null || getTitle.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Name is empty", Toast.LENGTH_LONG).show();
                } else if (task.getDetails() == null || getDetails.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Details are empty", Toast.LENGTH_LONG).show();
                } else {
                    tasks.add(task);
                    displayTaskNames();
                    ((EditText) findViewById(R.id.task_title_text_box)).setText("");
                    ((EditText) findViewById(R.id.task_details_text_box)).setText("");
                }

            }
        });

        displayTaskNames();
        taskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> l, View v, int position, long id) {
                Intent intent = new Intent(MainActivity.this, TaskActivity.class);
                intent.putExtra("Task Title", tasks.get(position).getName());
                intent.putExtra("Task Details", tasks.get(position).getDetails());
                startActivity(intent);
            }
        });


    }

//    public void saveTask(){
//        SharedPreferences tasks = getSharedPreferences("tasks", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = tasks.edit();
//
//        Gson gson = new Gson();
//        String jsonTasks = gson.toJson(task);
//
//        editor.putString(task.getSpKey(), jsonTasks);
//        editor.apply();
//    }
//


    private void displayTaskNames() {
        ArrayList<String> taskNames = new ArrayList<>();
        for (Task_details task : tasks) {
            taskNames.add(task.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, taskNames);

        taskList.setAdapter(adapter);
    }


    public void onShowTaskButtonClick(View view) {
        homeScreenButton.setVisibility(View.VISIBLE);
        showTaskButton.setVisibility(View.INVISIBLE);
        createTaskButton.setVisibility(View.VISIBLE);
        welcomeMessage.setVisibility(View.INVISIBLE);
        taskTitle.setVisibility(View.INVISIBLE);
        taskDetails.setVisibility(View.INVISIBLE);
        taskList.setVisibility(View.VISIBLE);
        displayTaskDetails.setVisibility(View.INVISIBLE);
        saveTask.setVisibility(View.INVISIBLE);

    }

    public void onCreateTaskButtonClick(View view) {
        homeScreenButton.setVisibility(View.VISIBLE);
        showTaskButton.setVisibility(View.INVISIBLE);
        createTaskButton.setVisibility(View.INVISIBLE);
        welcomeMessage.setVisibility(View.INVISIBLE);
        taskTitle.setVisibility(View.VISIBLE);
        taskDetails.setVisibility(View.VISIBLE);
        taskList.setVisibility(View.INVISIBLE);
        displayTaskDetails.setVisibility(View.INVISIBLE);
        saveTask.setVisibility(View.VISIBLE);


    }


    public void onHomeScreenButtonClick(View view) {
        homeScreenButton.setVisibility(View.INVISIBLE);
        showTaskButton.setVisibility(View.VISIBLE);
        createTaskButton.setVisibility(View.VISIBLE);
        welcomeMessage.setVisibility(View.VISIBLE);
        taskTitle.setVisibility(View.INVISIBLE);
        taskDetails.setVisibility(View.INVISIBLE);
        taskList.setVisibility(View.INVISIBLE);
        displayTaskDetails.setVisibility(View.INVISIBLE);
        saveTask.setVisibility(View.INVISIBLE);

    }




}
