package maciejkrawiecki.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "runs")
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String place;

    private int membersLimit;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "run")
    private Set<Member> members = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Run setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Run setName(String name) {
        this.name = name;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public Run setPlace(String place) {
        this.place = place;
        return this;
    }

    public int getMembersLimit() {
        return membersLimit;
    }

    public Run setMembersLimit(int membersLimit) {
        this.membersLimit = membersLimit;
        return this;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public Run setMembers(Set<Member> members) {
        this.members = members;
        return this;
    }
}
