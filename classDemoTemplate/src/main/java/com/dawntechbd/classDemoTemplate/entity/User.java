package com.dawntechbd.classDemoTemplate.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Please Enter RoleName")
    @Column(name = "username", unique = true)
    private String userName;

    @NotEmpty(message = "Please Enter Password")
    @Column(name = "password")
    @Size(min = 8, message = "At least 8 Characters")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @NotEmpty(message = "Please Enter Email Address")
    @Column(name = "enail", unique = true)
    private String email;

    @Length(min = 11, message = "*Your mobile must have at lest 11 chatacer")
    @NotEmpty(message = "*Please enter Your Modile")
    @Column(name = "mobile", unique = true)
    private String mobile;
    @Column(name = "joining_date")
    private Date joiningDate;

    @Column(name = "is_Active")
    private boolean isActice;

    @Size(min = 0, max = 100)
    @Column(name = "activation_key")
    private String activationKey;

    @Size(min = 0, max = 100)
    @Column(name = "reset_pass_key")
    private String resetPasswordKey;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )


    private Set<Role> roles;


    public User() {
    }

    public User(User user) {
        this.userName = user.userName;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.mobile = user.mobile;
        this.joiningDate = user.joiningDate;
        this.isActice = user.isActice;
        this.activationKey = user.activationKey;
        this.resetPasswordKey = user.resetPasswordKey;
        this.roles = user.roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public boolean isActice() {
        return isActice;
    }

    public void setActice(boolean actice) {
        isActice = actice;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getResetPasswordKey() {
        return resetPasswordKey;
    }

    public void setResetPasswordKey(String resetPasswordKey) {
        this.resetPasswordKey = resetPasswordKey;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
