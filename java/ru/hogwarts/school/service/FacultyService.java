package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.DataNotFoundedException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> map = new HashMap<>();
    private Long COUNTER = 1L;
    public Collection<Faculty> getByColor(String color){
        return map.values().stream().
                filter(faculty -> faculty.getColor().equalsIgnoreCase(color)).
                collect(Collectors.toList());
    }

    public Faculty getById(Long id){
        return map.get(id);
    }
    public Collection<Faculty> getAll(){
        return map.values();
    }
    public Faculty create(Faculty faculty){
        Long nextId = COUNTER++;
        faculty.setId(nextId);
        map.put(faculty.getId(), faculty);
        return faculty;
    }
    public Faculty update(Long id, Faculty faculty){
        if (!map.containsKey(id)){
            throw new DataNotFoundedException();
        }
        Faculty existingFaculty = map.get(id);
        existingFaculty.setName(faculty.getName());
        existingFaculty.setColor(faculty.getColor());
        return existingFaculty;
    }
    public void delete(Long id){
        if (map.remove(id)==null){
            throw new DataNotFoundedException();
        }
    }
}
