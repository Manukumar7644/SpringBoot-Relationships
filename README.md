# SpringBoot-Relationships
Spring Relationships define how different entities (tables) in a database are connected with each other using JPA annotations like @OneToOne, @OneToMany, @ManyToOne, and @ManyToMany.
# 🔗 Spring Relationships (JPA / Hibernate)

This repository demonstrates how **Entity Relationships** work in **Spring Boot using JPA and Hibernate**.

In real-world applications, database tables are connected with each other.
Spring Data JPA provides powerful annotations to define these relationships between entities.

---

## 📚 Types of Relationships in Spring

### 1️⃣ One-to-One Relationship

A **One-to-One relationship** means one entity is associated with exactly one other entity.

Example:
A **User** has one **Profile**.

```java
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Profile profile;
}
```

---

### 2️⃣ One-to-Many Relationship

A **One-to-Many relationship** means one entity can be associated with multiple entities.

Example:
One **Department** can have many **Employees**.

```java
@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
```

---

### 3️⃣ Many-to-One Relationship

A **Many-to-One relationship** means multiple entities can be related to a single entity.

Example:
Many **Employees** belong to one **Department**.

```java
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Department department;
}
```

---

### 4️⃣ Many-to-Many Relationship

A **Many-to-Many relationship** means multiple entities are connected to multiple entities.

Example:
Many **Students** can enroll in many **Courses**.

```java
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private List<Course> courses;
}
```

---

## ⚙️ Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

---

## 🚀 Purpose of This Repository

* Understand **Entity Relationships in Spring Boot**
* Learn **JPA Annotations**
* Practice **Database Mapping Concepts**
* Help beginners understand **real-world database relationships**

---

⭐ If you find this repository helpful, consider giving it a star!
