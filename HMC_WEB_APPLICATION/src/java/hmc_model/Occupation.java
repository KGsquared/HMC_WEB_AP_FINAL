package hmc_model;

/**
 *
 * @author k_gsquared
 */
public class Occupation {
    private Integer jobid;
    private String jobdesc;
    private Double comm;

    public Occupation() {
    }

    public Occupation(Integer jobid, String jobdesc, Double comm) {
        this.jobid    = jobid;
        this.jobdesc  = jobdesc;
        this.comm     = comm;
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    @Override
    public String toString() {
        return "Job{" + "jobid=" + jobid + ", jobdesc=" + jobdesc + ", comm=" + comm + '}';
    }
}
