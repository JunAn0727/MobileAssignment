package com.example.mobileassignment.models;

public class Job {
    private String position;
    private String desc;
    private String requirement;
    private int salary;
    private Category category;
    private Company company;

    public Job(){
    }

    public Job(String position, String desc, String requirement, int salary, Category category, Company company) {
        this.position = position;
        this.desc = desc;
        this.requirement = requirement;
        this.salary = salary;
        this.category = category;
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
