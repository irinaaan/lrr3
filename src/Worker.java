public class Worker {
    private int idWorkers;
    private String name;
    private String surname;
    private String position;
    private String employment;

    public Worker(int idWorkers, String name, String surname, String position, String employment) {
        this.idWorkers = idWorkers;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.employment = employment;
    }

    public Worker() {
    }

    public int getIdWorkers() {
        return idWorkers;
    }

    public void setIdWorkers(int idWorkers) {
        this.idWorkers = idWorkers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }
}