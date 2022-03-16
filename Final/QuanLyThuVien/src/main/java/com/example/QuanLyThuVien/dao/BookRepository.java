package com.example.QuanLyThuVien.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.QuanLyThuVien.entities.Book;

public interface BookRepository extends JpaRepository <Book, Integer>
{

}
