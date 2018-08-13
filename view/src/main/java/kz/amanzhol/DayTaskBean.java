package kz.amanzhol;

import kz.amanzhol.domain.DayTask;
import kz.amanzhol.ejb.TaskManagerBean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class DayTaskBean implements Serializable {
    @EJB
    TaskManagerBean taskManagerBean;

    private DayTask dayTask;
    private String task;
    private String groupName;
    private boolean finished;

    public void createDayTask () {
        taskManagerBean.crateDayTask(task, groupName);

        task = null;
        groupName = null;
    }

    public List<DayTask> getDayTasks(){
        return taskManagerBean.getDayTasks();
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
