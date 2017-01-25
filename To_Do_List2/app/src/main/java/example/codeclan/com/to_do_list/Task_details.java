package example.codeclan.com.to_do_list;

import static android.R.attr.id;

/**
 * Created by user on 24/01/2017.
 */

public class Task_details {
    private String taskName;
    private String taskDetails;

    public Task_details(String taskName, String taskDetails){
        this.taskName = taskName;
        this.taskDetails = taskDetails;
    }

    public String getName(){
        return this.taskName;
    }

    public String getDetails(){
        return this.taskDetails;
    }




}
