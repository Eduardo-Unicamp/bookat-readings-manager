package com.bookat.readings_manager.repository;

import com.bookat.readings_manager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
