package com.bookat.readings_manager.repository;

import com.bookat.readings_manager.entity.Book;
import com.bookat.readings_manager.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
}
