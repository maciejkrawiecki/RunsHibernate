package maciejkrawiecki.entity;


import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private int startNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "run_id")
    private Run run;

    public Long getId() {
        return id;
    }

    public Member setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Member setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public Member setStartNumber(int startNumber) {
        this.startNumber = startNumber;
        return this;
    }

    public Run getRun() {
        return run;
    }

    public Member setRun(Run run) {
        this.run = run;
        return this;
    }
}
