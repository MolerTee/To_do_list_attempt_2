package example.codeclan.com.to_do_list;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by user on 24/01/2017.
 */

public class Task_Details_Test {

    @Test
    public void getTaskNameTest() {
        Task_details task = new Task_details("title", "details");
        assertNotNull(task.getName());
    }

    @Test
    public void getTaskDetailsTest() {
        Task_details task = new Task_details("title", "details");
        assertNotNull(task.getDetails());
    }

}
