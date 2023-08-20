import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobAlert {

    private List<Job> jobs;

    public JobAlert() {
        jobs = new ArrayList<>();
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void searchJobs(String criteria) {
        List<Job> results = new ArrayList<>();
        for (Job job : jobs) {
            if (job.getTitle().contains(criteria) || job.getCompany().contains(criteria)) {
                results.add(job);
            }
        }

        System.out.println("Results:");
        for (Job job : results) {
            System.out.println(job.getTitle() + " - " + job.getCompany());
        }
    }

    public static void main(String[] args) throws IOException {
        JobAlert jobAlert = new JobAlert();

        jobAlert.addJob(new Job("Software Engineer", "Google", "Mountain View, CA", 100000));
        jobAlert.addJob(new Job("Data Scientist", "Facebook", "Menlo Park, CA", 120000));
        jobAlert.addJob(new Job("Product Manager", "Amazon", "Seattle, WA", 150000));

        System.out.println("Enter your search criteria:");
        String criteria = System.console().readLine();

        jobAlert.searchJobs(criteria);
    }
}
