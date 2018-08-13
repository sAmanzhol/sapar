package kz.amanzhol.ejb;

import kz.amanzhol.domain.DayTask;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class TaskManagerBean {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public DayTask crateDayTask(String task, String groupName) {
        DayTask dayTask = new DayTask();
        dayTask.setTask(task);
        dayTask.setGroupName(groupName);
        dayTask.setFinished(false);
        entityManager.persist(dayTask);

        return dayTask;
    }

    public List<DayTask> getDayTasks() {
        TypedQuery<DayTask> query = entityManager.createQuery("select c from DayTask c ", DayTask.class);
        return query.getResultList();
    }
}
