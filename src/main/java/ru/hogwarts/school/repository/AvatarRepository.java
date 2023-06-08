package ru.hogwarts.school.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.dto.AvatarDto;
import ru.hogwarts.school.entity.Avatar;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    Optional<Avatar> findByStudent_Id(long studentId);

    @Query("SELECT new ru.hogwarts.school.dto.AvatarDto(id, fileSize, mediaType, 'http://localhost:8080/download-from-db?studentId=' || id) FROM Avatar")
    Page<AvatarDto> getPage(PageRequest pageable);
}
