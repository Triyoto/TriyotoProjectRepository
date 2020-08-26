package com.example.smarschool2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smarschool2.model.PelajaranModel;

public interface PelajaranRepository extends JpaRepository<PelajaranModel, String> {

}
