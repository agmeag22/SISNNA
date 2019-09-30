/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.objects;

/**
 *
 * @author Azure
 */
public class Usuario {
    private String id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String role;
    private String department;
    private String committee;
    private String email;
    private String createdAlert;
    private String assignedAlert;
    private String state;
    private int number;

    public Usuario(String id, String username, String password, String name, String lastname, String role, String department, String committee, String email, String createdAlert, String assignedAlert, String state, int number) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
        this.department = department;
        this.committee = committee;
        this.email = email;
        this.createdAlert = createdAlert;
        this.assignedAlert = assignedAlert;
        this.state = state;
        this.number = number;
    }
    
    
    
    public Usuario(){
        super();
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAlert() {
        return createdAlert;
    }

    public void setCreatedAlert(String createdAlert) {
        this.createdAlert = createdAlert;
    }

    public String getAssignedAlert() {
        return assignedAlert;
    }

    public void setAssignedAlert(String assignedAlert) {
        this.assignedAlert = assignedAlert;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    
    
}
