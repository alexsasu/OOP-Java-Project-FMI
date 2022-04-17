package service;

import model.Job;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobService {
    private static JobService INSTANCE = null;
    private final ReadService readService = ReadService.getInstance();
    private final WriteService writeService = WriteService.getInstance();

    private final String fileName = "src/csvFiles/Jobs.csv";
    private List<Job> jobs = new ArrayList<>();

    private JobService() { }

    public static JobService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JobService();
        }

        return INSTANCE;
    }

    public Job getJobById(Integer idJob) {
        try {
            int currentPosition = 0, index = -1;
            for (Job job : jobs) {
                if (job.getIdJob().equals(idJob)) {
                    index = currentPosition;
                    break;
                }
                ++currentPosition;
            }
            return jobs.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            return null;
        }
    }

    public Job getJobByName(String name) {
        try {
            int currentPosition = 0, index = -1;
            for (Job job : jobs) {
                if (job.getName().equals(name)) {
                    index = currentPosition;
                    break;
                }
                ++currentPosition;
            }
            return jobs.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
            return null;
        }
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    //    public void updateJobById(Integer idJob) {
    //
    //    }

    public void deleteJobById(Integer idJob) {
        try {
            int currentPosition = 0, index = -1;
            for (Job job : jobs) {
                if (job.getIdJob().equals(idJob)) {
                    index = currentPosition;
                }
                ++currentPosition;
            }
            jobs.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void readJobsFromFile() {
        String[] jobs = readService.readFromFile(this.fileName).split("\n");

        try {
            for (String job : jobs) {
                String[] jobInfo = job.split(",");
                Job jobToBeAdded = new Job(Integer.parseInt(jobInfo[0]), jobInfo[1]);
                this.jobs.add(jobToBeAdded);
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    public void writeJobsToFile() {
        // Deleting file contents
        try {
            new FileOutputStream(this.fileName).close();
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }

        for (Job job : jobs) {
            String jobInfo = job.getIdJob() + "," + job.getName();

            writeService.writeToFile(fileName, jobInfo);
        }
    }
}
