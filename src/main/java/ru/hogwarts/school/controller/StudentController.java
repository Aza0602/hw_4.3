package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.entity.Faculty;
import ru.hogwarts.school.entity.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @GetMapping
    public Collection<Student> getAll(@RequestParam(value = "age", required = false) Integer age) {
        return Optional.ofNullable(age)
                .map(studentService::getAllByAge)
                .orElseGet(studentService::getAll);
    }

    @PostMapping("/")
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PutMapping("/{id}")
    public Optional<Student> update(@PathVariable Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public Optional<Student> deleteById(@PathVariable Long id) {
        return studentService.deleteById(id);
    }

    @GetMapping(params = {"min", "max"})
    public Collection<Student> getAllByAgeBetween(@RequestParam("min") int minAge, @RequestParam("max") int maxAge) {
        return studentService.getAllByAgeBetween(minAge, maxAge);
    }

    @GetMapping("/{id}/faculty")
    public Optional<Faculty> getFacultyByStudentId(@PathVariable Long id) {
        return studentService.getFacultyByStudentId(id);
    }

    @GetMapping("/count")
    public int getCountOfStudents() {
        return studentService.getCountOfStudents();
    }

    @GetMapping("/averageAge")
    public double getAverageAgeOfStudents() {
        return studentService.getAverageAgeOfStudents();
    }

    @GetMapping("/lastStudents")
    public List<Student> getLastStudents(@RequestParam(value = "count", defaultValue = "5") int count) {
        return studentService.getLastStudents(count);
    }

}
