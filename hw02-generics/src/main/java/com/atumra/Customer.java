package com.atumra;

public class Customer {
  private final long id;
  private String name;
  private long scores;

  public Customer(long id, String name, long scores) {
    this.id = id;
    this.name = name;
    this.scores = scores;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getScores() {
    return scores;
  }

  public void setScores(long scores) {
    this.scores = scores;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Customer other = (Customer) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", name=" + name + ", scores=" + scores + "]";
  }

}