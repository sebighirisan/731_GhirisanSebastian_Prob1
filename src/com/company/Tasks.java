package com.company;

enum Status {
    Open, In_Progress, Done
}

class Tasks{
    int Id;
    String Taskname;
    int spent;
    int budget;
    Status status;
    int restBudget;

    public Tasks(int id, String taskname, int spent, int budget, Status status) {
        Id = id;
        Taskname = taskname;
        this.spent = spent;
        this.budget = budget;
        this.status = status;
        //fur d
        this.restBudget=budget-spent;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "Id=" + Id +
                ", Taskname='" + Taskname + '\'' +
                ", spent=" + spent +
                ", budget=" + budget +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTaskname() {
        return Taskname;
    }

    public void setTaskname(String taskname) {
        Taskname = taskname;
    }

    public int getSpent() {
        return spent;
    }

    public void setSpent(int spent) {
        this.spent = spent;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public int getRestBudget() {
        return restBudget;
    }

    public void setRestBudget(int restBudget) {
        this.restBudget = restBudget;
    }
}