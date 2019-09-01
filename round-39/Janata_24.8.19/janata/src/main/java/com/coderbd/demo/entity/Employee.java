package com.coderbd.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Min(value = 18, message = "Hey, Minium Age is 18")
    private byte age;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date joiningDate=new Date();

    @NotEmpty(message = "Enter Gender")
    private String gender;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name = "salary")
    private double salary;

    @Column(name = "bloodGroup")
    private String bloodGroup;

    @Column(name = "address")
    private String address;

    @Column(name = "contactNo",unique = true)
    private String contactNo;


    @NotNull(message = "Enter An Email Address")
    @Email
    @Column(name = "email",unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "compnany_id")
    private Company company;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Employee() {
    }

    public Employee(String firstName, String lastName, @Min(value = 18, message = "Hey, Minium Age is 18") byte age, Date joiningDate, @NotEmpty(message = "Enter Gender") String gender, Date birthDate, double salary, String bloodGroup, String address, String contactNo, @NotNull(message = "Enter An Email Address") @Email String email, Branch branch, Company company, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.joiningDate = joiningDate;
        this.gender = gender;
        this.birthDate = birthDate;
        this.salary = salary;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
        this.branch = branch;
        this.company = company;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getAge() == employee.getAge() &&
                Double.compare(employee.getSalary(), getSalary()) == 0 &&
                Objects.equals(getId(), employee.getId()) &&
                Objects.equals(getFirstName(), employee.getFirstName()) &&
                Objects.equals(getLastName(), employee.getLastName()) &&
                Objects.equals(getJoiningDate(), employee.getJoiningDate()) &&
                Objects.equals(getGender(), employee.getGender()) &&
                Objects.equals(getBirthDate(), employee.getBirthDate()) &&
                Objects.equals(getBloodGroup(), employee.getBloodGroup()) &&
                Objects.equals(getAddress(), employee.getAddress()) &&
                Objects.equals(getContactNo(), employee.getContactNo()) &&
                Objects.equals(getEmail(), employee.getEmail()) &&
                Objects.equals(getBranch(), employee.getBranch()) &&
                Objects.equals(getCompany(), employee.getCompany()) &&
                Objects.equals(getUser(), employee.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAge(), getJoiningDate(), getGender(), getBirthDate(), getSalary(), getBloodGroup(), getAddress(), getContactNo(), getEmail(), getBranch(), getCompany(), getUser());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", joiningDate=" + joiningDate +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", branch=" + branch +
                ", company=" + company +
                ", user=" + user +
                '}';
    }
}
